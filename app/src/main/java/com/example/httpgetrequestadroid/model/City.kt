package com.example.httpgetrequestadroid.model

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("city_name")
    var CityName:String
){
    override fun toString(): String {
        return CityName
    }
}
