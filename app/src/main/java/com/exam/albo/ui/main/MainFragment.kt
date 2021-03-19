package com.exam.albo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.albo.R
import com.exam.albo.service.ReportResponse
import com.exam.albo.service.Status
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlin.collections.HashMap

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var numMonth = 0
    private lateinit var viewModel: MainViewModel
    private var map = hashMapOf<Int, MutableList<ReportResponse>>()
    private var listReportsByMonth = mutableListOf<ReportResponse>()
    var hashMapCategories = hashMapOf<String, Double>()
    var mapCategoriesForMonth = hashMapOf<Int, HashMap<String, Double>>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        subscribeLiveData()
        viewModel.reports()
    }

    private fun subscribeLiveData(){
        viewModel.reportLiveData.observe(viewLifecycleOwner, Observer { it ->
            when (it.status){
                Status.LOADING -> {
                    Log.i("ON", "LOADING")
                }
                Status.SUCCESS -> {
                    Log.i("SUCCES", "JSON ${it.data}")
                    val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                    it.data!!.arrayReports.sortBy {
                        simpleDateFormat.parse(it.creation_date!!)
                    }
                    for (reports in it.data.arrayReports){
                        val dateReport = simpleDateFormat.parse(reports.creation_date!!)
                        val month = getMonth(dateReport!!)
                        processDateReport(month, reports)
                    }
                    setListView()
                }
                Status.ERROR -> {
                    Log.i("ON", "ERROR")
                }
            }
        })

    }

    private fun getMonth(date: Date): Int{
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.MONTH)
    }

    private fun processDateReport(month: Int, report: ReportResponse){
        //Log.i("MONTH", "VALUE ----- $month ---- $numMonth")
        if (numMonth != month) {
            numMonth++
            listReportsByMonth = mutableListOf()
        }
        when (month){
            0 -> {
                listReportsByMonth.add(report)
                map [0] = listReportsByMonth
            }
            1 -> {
                listReportsByMonth.add(report)
                map [1] = listReportsByMonth
            }
            2 -> {
                listReportsByMonth.add(report)
                map [2] = listReportsByMonth
            }
            3 -> {
                listReportsByMonth.add(report)
                map [3] = listReportsByMonth
            }
            4 -> {
                listReportsByMonth.add(report)
                map [4] = listReportsByMonth
            }
            5 -> {
                listReportsByMonth.add(report)
                map [5] = listReportsByMonth
            }
            6-> {
                listReportsByMonth.add(report)
                map [6] = listReportsByMonth
            }
            7 -> {
                listReportsByMonth.add(report)
                map [7] = listReportsByMonth
            }
            8 -> {
                listReportsByMonth.add(report)
                map [8] = listReportsByMonth
            }
            9 -> {
                listReportsByMonth.add(report)
                map [9] = listReportsByMonth
            }
            10 -> {
                listReportsByMonth.add(report)
                map [10] = listReportsByMonth
            }
            11 -> {
                listReportsByMonth.add(report)
                map [11] = listReportsByMonth
            }
        }
    }

    private fun setListView(){
        map.toSortedMap()
        getListCategories()
        val adapter = activity?.let { ReportsAdapter(requireContext(), it, map, mapCategoriesForMonth) }
        rvReports.adapter = adapter
        rvReports.layoutManager = LinearLayoutManager(activity)
    }

    private fun getListCategories(){
        val listPosition = mutableListOf<Int>()
        for (report in map){
            Log.i("POSICION", "POR ----> ${report.key}")
            listPosition.add(report.key)
        }
        var totalAmountOut = 0.0
        var totalPercent = 0.0
        for (mapReport in map){
            for (report in mapReport.value) {
                if (report.operation == "out") {
                    when (report.category) {
                        Categories.Feeding.value -> {
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            val listFeeding = mutableListOf<ReportResponse>()
                            listFeeding.add(report)
                            for (feeding in listFeeding){
                                totalAmountOut += feeding.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Feeding.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Home.value -> {
                            val listHome = mutableListOf<ReportResponse>()
                            listHome.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (home in listHome) {
                                totalAmountOut += home.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Home.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Entretaiment.value -> {
                            val listEntretaiment = mutableListOf<ReportResponse>()
                            listEntretaiment.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (entretaiment in listEntretaiment) {
                                totalAmountOut += entretaiment.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Entretaiment.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Services.value -> {
                            val listServices = mutableListOf<ReportResponse>()
                            listServices.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (services in listServices){
                                totalAmountOut += services.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Services.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Transfers.value -> {
                            val listTransfers = mutableListOf<ReportResponse>()
                            listTransfers.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (transfers in listTransfers){
                                totalAmountOut += transfers.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Transfers.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Retreats.value -> {
                            val listRetreats = mutableListOf<ReportResponse>()
                            listRetreats.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (retreats in listRetreats){
                                totalAmountOut += retreats.amount!!
                                totalPercent = totalAmountOut / totalAmountOut
                            }
                            hashMapCategories[Categories.Retreats.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Other.value -> {
                            val listOther = mutableListOf<ReportResponse>()
                            listOther.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (other in listOther) {
                                totalAmountOut += other.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Other.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                        Categories.Transport.value -> {
                            val listTransport = mutableListOf<ReportResponse>()
                            listTransport.add(report)
                            totalAmountOut = 0.0
                            totalPercent = 0.0
                            for (transport in listTransport){
                                totalAmountOut += transport.amount!!
                                totalPercent = totalAmountOut / 100
                            }
                            hashMapCategories[Categories.Transport.value] = totalPercent
                            mapCategoriesForMonth[mapReport.key] = hashMapCategories
                        }
                    }
                }
            }
        }
        hashMapCategories.toList().sortedBy { (k, v) -> v}.toMap()
        /*for (categories in hashMapCategories){
            val itemCategory = View.inflate(context, R.layout.item_categories, null)
            itemCategory.tvTitleCategory.text = categories.key
            val labelTotal = "${formatDoubleToNPlaces(categories.value)}%"
            itemCategory.tvPercent.text = labelTotal
            itemCategory.tag = position
            //binding.llCategories.addView(itemCategory)
        }*/
    }

}