package com.exam.albo.ui.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exam.albo.service.beers.BeerK

class DetailViewModel: ViewModel() {
    val beerLiveData = MutableLiveData<BeerK>()
    val listLiveData = MutableLiveData<MutableList<BeerK>>()

    fun select(beer: BeerK) {
        beerLiveData.value = beer
    }

    fun setList(list: MutableList<BeerK>){
        listLiveData.value = list
    }

    fun updateList(list: MutableList<BeerK>){
        listLiveData.value!!.addAll(0, list)
    }

}