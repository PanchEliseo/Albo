package com.exam.albo.ui.second

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exam.albo.R
import com.exam.albo.databinding.ItemBeersBinding
import com.exam.albo.service.beers.BeerK
import com.squareup.picasso.Picasso

class BeersAdapter(private val context : Context, private val listBeers: MutableList<BeerK>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickItem: ClickItemList? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemBeersBinding>(
            LayoutInflater.from(context),
            R.layout.item_beers, parent, false)
        return ItemBeerHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBeers.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemBeerHolder
        downloadImage(holder.binding, position)
        holder.binding.tvName.text = listBeers[position].name
        holder.binding.tvTagline.text = listBeers[position].tagline
    }

    private fun downloadImage(binding: ItemBeersBinding, position: Int){
        Picasso.with(context)
            .load(listBeers[position].imageUrl)
            .placeholder(R.drawable.progress_animation)
            .into(binding.ivBeer)
    }

    fun updateList(list: MutableList<BeerK>){
        listBeers.addAll(0, list)
        notifyDataSetChanged()
    }

    fun setListenerClick(clickItemMovements: ClickItemList) {
        this.onClickItem = clickItemMovements
    }

    inner class ItemBeerHolder(val binding: ItemBeersBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.containerItem.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onClickItem!!.clickButtons(v!!, adapterPosition, listBeers)
        }
    }

}