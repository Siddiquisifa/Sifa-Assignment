package com.example.httpgetrequestadroid.network

import androidx.constraintlayout.widget.ConstraintLayoutStates
import com.example.httpgetrequestadroid.model.City
import com.example.httpgetrequestadroid.model.Country
import com.example.httpgetrequestadroid.model.State
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers(
        "Accept: application/vnd.yourapi.v1.full+json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJyZWhhbjEyQGdhbWlsLmNvbSIsImFwaV90b2tlbiI6Imt1UGJFYS1uV3JEdEV5SnNZcTV2aDgwdW9ocm1zb21CTllLcFk3SWNRaWUwYkJoY3dyV3g4d3haVnlLZDFyMkpZWVkifSwiZXhwIjoxNjU5MTA3NzU1fQ.aGQ3GgECJzQu7VkhFuzlQtFforvSP-Gy442RLckXCuk"
    )
    @GET("countries")
    fun getCountryList() : Call<List<Country>>

    @Headers(
        "Accept: application/vnd.yourapi.v1.full+json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJyZWhhbjEyQGdhbWlsLmNvbSIsImFwaV90b2tlbiI6Imt1UGJFYS1uV3JEdEV5SnNZcTV2aDgwdW9ocm1zb21CTllLcFk3SWNRaWUwYkJoY3dyV3g4d3haVnlLZDFyMkpZWVkifSwiZXhwIjoxNjU5MTA3NzU1fQ.aGQ3GgECJzQu7VkhFuzlQtFforvSP-Gy442RLckXCuk"
    )
    @GET("states/{ct}")
    fun getStateList(@Path("ct") country:String) : Call<List<State>>

    @Headers(
        "Accept: application/vnd.yourapi.v1.full+json",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJyZWhhbjEyQGdhbWlsLmNvbSIsImFwaV90b2tlbiI6Imt1UGJFYS1uV3JEdEV5SnNZcTV2aDgwdW9ocm1zb21CTllLcFk3SWNRaWUwYkJoY3dyV3g4d3haVnlLZDFyMkpZWVkifSwiZXhwIjoxNjU5MTA3NzU1fQ.aGQ3GgECJzQu7VkhFuzlQtFforvSP-Gy442RLckXCuk"
    )
    @GET("cities/{st}")
    fun getCityList(@Path("st")states:String) : Call<List<City>>
}