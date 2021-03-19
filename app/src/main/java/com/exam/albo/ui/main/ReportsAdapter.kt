package com.exam.albo.ui.main

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.albo.R
import com.exam.albo.databinding.ItemListReportsBinding
import com.exam.albo.service.ReportResponse
import kotlinx.android.synthetic.main.item_categories.view.*
import kotlinx.android.synthetic.main.main_fragment.*

enum class MonthReport(val value: String) {
    January("Enero"),
    February("Febrero"),
    March("Marzo"),
    April("Abril"),
    May("Mayo"),
    June("Junio"),
    July("Julio"),
    August("Agosto"),
    September("Septiembre"),
    October("Octubre"),
    November("Noviembre"),
    December("Diciembre")
}

enum class Categories(val value: String) {
    Feeding("Alimentacion"),
    Home("Hogar"),
    Entretaiment("Entretenimiento"),
    Services("Servicios"),
    Transfers("Transferencias"),
    Retreats("Retiros en cajero"),
    Other("Otros"),
    Transport("Transporte")
}

class ReportsAdapter(private val context : Context, private val activity: Activity, private val map: HashMap<Int, MutableList<ReportResponse>>,
                    private val listCategoriesByMonth: HashMap<Int, HashMap<String, Double>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemListReportsBinding>(LayoutInflater.from(context),
        R.layout.item_list_reports, parent, false)
        return ItemReportsHolder(binding)
    }

    override fun getItemCount(): Int {
        return map.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemReportsHolder
        setTitleMonth(holder.binding, position)
    }

    private fun setTitleMonth(binding: ItemListReportsBinding, position: Int){
        when (position){
            0 -> {
                binding.tvMonth.text = MonthReport.January.value
            }
            1 -> {
                binding.tvMonth.text = MonthReport.February.value
            }
            2 -> {
                binding.tvMonth.text = MonthReport.March.value
            }
            3 -> {
                binding.tvMonth.text = MonthReport.April.value
            }
            4 -> {
                binding.tvMonth.text = MonthReport.May.value
            }
            5 -> {
                binding.tvMonth.text = MonthReport.June.value
            }
            6 -> {
                binding.tvMonth.text = MonthReport.July.value
            }
            7 -> {
                binding.tvMonth.text = MonthReport.August.value
            }
            8 -> {
                binding.tvMonth.text = MonthReport.September.value
            }
            9 -> {
                binding.tvMonth.text = MonthReport.October.value
            }
            10 -> {
                binding.tvMonth.text = MonthReport.November.value
            }
            11 -> {
                binding.tvMonth.text = MonthReport.December.value
            }
        }
        //Se cuentan las pendientes y se aumenta el contador para saber cuantas estan pendientes(pendings) y cuantas estan bloqueadas(rejected)
        var contPendings = 0
        var contRejected = 0
        var amountTotalIncome = 0.0
        var amountTotalOut = 0.0
         for (report in map[position]!!){
            when (report.status){
                "pending" -> {
                    contPendings ++
                }
                "rejected" -> {
                    contRejected ++
                }
            }
            if (report.operation == "in" && report.status == "done")
                amountTotalIncome += report.amount!!
            if (report.operation == "out" && report.status == "done")
                amountTotalOut += report.amount!!
         }
        binding.tvPending.text = contPendings.toString()
        binding.tvBlocked.text = contRejected.toString()
        val labelIncome = "$"+formatDoubleToNPlaces(amountTotalIncome)
        binding.tvIncome.text = labelIncome
        val labelOut = "$"+formatDoubleToNPlaces(amountTotalOut)
        binding.tvExpenses.text = labelOut
        listCategoriesByMonth[position]?.let { setListView(binding, it) }
    }

    private fun setListView(binding: ItemListReportsBinding, listCategories: HashMap<String, Double>){
        //map.toSortedMap()
        val adapter = CategoriesAdapter(context, listCategories)
        binding.rvCategories.adapter = adapter
        binding.rvCategories.layoutManager = LinearLayoutManager(activity)
    }

    private fun formatDoubleToNPlaces(value:Double) = "%.2f".format(value)

    inner class ItemReportsHolder(val binding: ItemListReportsBinding): RecyclerView.ViewHolder(binding.root)
}