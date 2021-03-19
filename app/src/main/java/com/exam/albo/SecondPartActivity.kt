package com.exam.albo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.exam.albo.service.Status
import com.exam.albo.service.beers.BeerK
import com.exam.albo.ui.main.MainFragment
import com.exam.albo.ui.second.SecondPartFragment
import com.exam.albo.ui.second.SecondViewModel

class SecondPartActivity : AppCompatActivity() {

    private lateinit var viewModel: SecondViewModel
    var listBeers: MutableList<BeerK>? = null
    var beer: BeerK? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_part_activity)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        subscribeLiveData()
        viewModel.getBeers()
    }

    private fun subscribeLiveData(){
        viewModel.beersLiveData.observe(this, Observer {
            when (it.status){
                Status.LOADING -> {
                    Log.i("ON", "LOADING")
                }
                Status.SUCCESS -> {
                    Log.i("ON", "SUCCESS ${it.data}")
                    listBeers = it.data!!.listBeers
                    updateInfo()
                    //setListView(it.data!!.listBeers)
                }
                Status.ERROR -> {
                    Log.i("ON", "ERROR")
                }
            }
        })
    }

    private fun updateInfo(){
        val currentFragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        currentFragment.let { navFragment ->
            navFragment!!.childFragmentManager.primaryNavigationFragment.let { fragment ->
                if (fragment is SecondPartFragment)
                    fragment.updateProduct()
            }
        }
    }

}