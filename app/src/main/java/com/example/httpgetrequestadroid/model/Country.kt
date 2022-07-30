package com.example.httpgetrequestadroid.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_name")
    var countryName:String,
    @SerializedName("country_short_name")
    var shortName:String,
    @SerializedName("country_phone_code")
    var phoneCode:Int
){

    override fun toString(): String {
        return "$countryName ($phoneCode)"
    }

}
