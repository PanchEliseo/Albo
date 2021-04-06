package com.exam.albo.ui.second

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.exam.albo.service.beers.BeerK

interface ClickItemList {
    fun clickButtons(view: View, position: Int, list: MutableList<BeerK>)
}