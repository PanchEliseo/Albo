package com.exam.albo.ui.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exam.albo.service.ListBeers
import com.exam.albo.service.Resource
import com.exam.albo.service.SecondRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondViewModel : ViewModel()  {

    val beersLiveData = MutableLiveData<Resource<ListBeers>>()

    private val secondRepository by lazy {
        SecondRepository()
    }

    fun getBeers(){
        try {
            viewModelScope.launch {
                beersLiveData.value = Resource.loading(null)
                val responseData = secondRepository.getBeers()
                withContext(Dispatchers.IO){
                    beersLiveData.postValue(responseData)
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}