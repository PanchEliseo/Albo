package com.exam.albo.ui.second

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.albo.R
import com.exam.albo.SecondPartActivity
import com.exam.albo.service.Status
import com.exam.albo.service.beers.Beer
import com.exam.albo.service.beers.BeerK
import com.exam.albo.ui.main.MainFragment
import com.exam.albo.ui.main.ReportsAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.second_part_fragment.*

class SecondPartFragment : Fragment(), ClickItemList {

    private lateinit var viewModel: SecondViewModel
    private val modelDetail: DetailViewModel by activityViewModels()
    var page = 1
    var adapter : BeersAdapter? = null
    private var recreate = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.second_part_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = ""
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        subscribeLiveData()
        setListeners()
        recreate = true
        if (modelDetail.listLiveData.value == null)
            viewModel.getBeers(page, 20)
        else {
            setListView(modelDetail.listLiveData.value!!)
        }
    }

    private fun setListView(listBeers: MutableList<BeerK>){
        adapter = activity?.let { BeersAdapter(requireContext(), listBeers) }!!
        rvBeers.adapter = adapter
        rvBeers.layoutManager = LinearLayoutManager(activity)
        adapter?.setListenerClick(this)
    }

    private fun updateList(listBeers: MutableList<BeerK>){
        adapter?.updateList(listBeers)
    }

    override fun clickButtons(view: View, position: Int, list: MutableList<BeerK>) {
        modelDetail.select(list[position])
        modelDetail.setList(list)
        findNavController().navigate(R.id.action_beersFragment_to_detailBeer)
    }
    
    private fun setListeners() {
        swipeLayout.setOnRefreshListener {
            page++
            recreate = false
            viewModel.getBeers(page, 20)
        }
    }

    private fun subscribeLiveData(){
        viewModel.beersLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status){
                Status.LOADING -> {
                    Log.i("ON", "LOADING")
                    swipeLayout.isRefreshing = true
                }
                Status.SUCCESS -> {
                    Log.i("ON", "SUCCESS ${it.data}")
                    //listBeers = it.data!!.listBeers
                    //updateInfo()
                    swipeLayout.isRefreshing = false
                    if (modelDetail.listLiveData.value == null) {
                        if (page == 1 || recreate)
                            setListView(it.data!!.listBeers)
                        else
                            updateList(it.data!!.listBeers)
                    } else {
                        if (!recreate)
                            updateList(it.data!!.listBeers)
                    }
                }
                Status.ERROR -> {
                    Log.i("ON", "ERROR")
                    swipeLayout.isRefreshing = false
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter = null
        rvBeers.adapter = null
        rvBeers.layoutManager = null
    }

}