package com.exam.albo.service.beers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BeerK(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("tagline")
    val tagline: String? = null,

    @SerializedName("first_brewed")
    val firstBrewed: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    @SerializedName("abv")
    val abv: Float,

    @SerializedName("ibu")
    val ibu: Float,

    @SerializedName("target_fg")
    val targetFg: Float,

    @SerializedName("target_og")
    val targetOg: Float,

    @SerializedName("ebc")
    val ebc: Float,

    @SerializedName("srm")
    val srm: Float,

    @SerializedName("ph")
    val ph: Float,

    @SerializedName("attenuation_level")
    val attenuationLevel: Float,

    @SerializedName("volume")
    val volume: Volume? = null,

    @SerializedName("boil_volume")
    val boilVolume: BoilVolume? = null,

    @SerializedName("method")
    @Expose
    val method: Method? = null,

    @SerializedName("ingredients")
    val ingredients: Ingredients? = null,

    @SerializedName("food_pairing")
    val foodPairing: List<String>? = null,

    @SerializedName("brewers_tips")
    val brewersTips: String? = null,

    @SerializedName("contributed_by")
    val contributedBy: String? = null
)