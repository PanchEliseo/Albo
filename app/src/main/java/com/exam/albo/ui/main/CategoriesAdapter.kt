package com.exam.albo.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exam.albo.R
import com.exam.albo.databinding.ItemCategoriesBinding

class CategoriesAdapter(private val context : Context, private val map: HashMap<String, Double>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listCategories = mutableListOf<DataCategories>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCategoriesBinding>(
            LayoutInflater.from(context),
            R.layout.item_categories, parent, false)
        getCategories()
        return ItemCategoriesHolder(binding)
    }

    override fun getItemCount(): Int {
        return map.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemCategoriesHolder
        Log.i("VALUES", "---- ${map.size} ${listCategories.size}")
        holder.binding.tvTitleCategory.text = listCategories[position].category
        val labelTotal = "${formatDoubleToNPlaces(listCategories[position].percent)}%"
        holder.binding.tvPercent.text = labelTotal
    }

    private fun getCategories() {
        listCategories = mutableListOf()
        for (categories in map) {
            val dataCategory = DataCategories(category = categories.key,
            percent = categories.value)
            listCategories.add(dataCategory)
        }
    }

    private fun formatDoubleToNPlaces(value:Double) = "%.2f".format(value)

    inner class ItemCategoriesHolder(val binding: ItemCategoriesBinding): RecyclerView.ViewHolder(binding.root)

    data class DataCategories(var category: String,
                              var percent: Double)

}