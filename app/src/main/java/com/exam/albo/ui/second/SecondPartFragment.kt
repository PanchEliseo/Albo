package com.exam.albo.ui.second

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.second_part_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = ""
        val list = (activity as SecondPartActivity).listBeers
        if (list != null)
            setListView(list)
    }

    private fun setListView(listBeers: MutableList<BeerK>){
        val adapter = activity?.let { BeersAdapter(requireContext(), listBeers) }
        rvBeers.adapter = adapter
        rvBeers.layoutManager = LinearLayoutManager(activity)
        adapter!!.setListenerClick(this)
    }

    override fun clickButtons(view: View, position: Int) {
        val list = (activity as SecondPartActivity).listBeers
        (activity as SecondPartActivity).beer = list?.get(position)
        findNavController().navigate(R.id.action_beersFragment_to_detailBeer)
    }

    fun updateProduct(){
        val list = (activity as SecondPartActivity).listBeers
        if (!list.isNullOrEmpty())
            setListView(list)
    }

}