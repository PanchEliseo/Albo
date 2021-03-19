package com.exam.albo.service

import com.exam.albo.service.beers.Beer
import com.exam.albo.service.beers.BeerK

data class ListBeers(
        val listBeers: MutableList<BeerK>
)