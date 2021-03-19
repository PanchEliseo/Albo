package com.exam.albo.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.exam.albo.R
import com.exam.albo.SecondPartActivity
import com.exam.albo.databinding.ItemBeersBinding
import com.exam.albo.service.beers.BeerK
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailBeerFragment : Fragment() {

    var beer: BeerK? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        beer = (activity as SecondPartActivity).beer
        (activity as AppCompatActivity).supportActionBar?.title = beer!!.name
        downloadImage()
        val tag = "Tagline: ${beer!!.tagline}"
        tvTagLine.text = tag
        val description = "Description: ${beer!!.description}"
        tvDescription.text = description
        val date = "Date: ${beer!!.firstBrewed}"
        tvDate.text = date
        var food = ""
        for(data in beer!!.foodPairing!!){
            food += "$data "
        }
        val foodPairing = "Food Pairing: $food"
        tvFood.text = foodPairing
    }

    private fun downloadImage(){
        Picasso.with(context)
            .load(beer!!.imageUrl)
            .into(ivDetailBeer)
    }

}