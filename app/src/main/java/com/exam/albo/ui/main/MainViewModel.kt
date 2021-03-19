package com.exam.albo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exam.albo.service.ListReportResponse
import com.exam.albo.service.ReportsDomainModel
import com.exam.albo.service.ReportsRepository
import com.exam.albo.service.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val reportLiveData = MutableLiveData<Resource<ListReportResponse>>()

    private val reportsRepository by lazy {
        ReportsRepository()
    }

    fun reports(){
        try {
            viewModelScope.launch {
                reportLiveData.value = Resource.loading(null)
                val responseData = reportsRepository.getReports()
                withContext(Dispatchers.IO) {
                    reportLiveData.postValue(responseData)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}