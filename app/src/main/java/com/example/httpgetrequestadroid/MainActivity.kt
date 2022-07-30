package com.example.httpgetrequestadroid

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.httpgetrequestadroid.databinding.ActivityMainBinding
import com.example.httpgetrequestadroid.model.City
import com.example.httpgetrequestadroid.model.Country
import com.example.httpgetrequestadroid.model.State
import com.example.httpgetrequestadroid.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var city1 = ""
   var country1 = ""
    var state1=""
    private lateinit var binding: ActivityMainBinding//this is called global variable in class but not in function

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCountryList()
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(this, "country:$country1 \n state:$state1 \n city:$city1", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loadCountryList() {
        ApiClient.init().getCountryList().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                // success

                if (response.isSuccessful) {
                    var list = response.body() as MutableList<Country>

                    var adapter = ArrayAdapter(
                        applicationContext,
                        R.layout.simple_spinner_dropdown_item,
                        list
                    )
                    binding.autoCountry.setAdapter(adapter)

                    binding.autoCountry.setOnItemClickListener { adapterView, view, pos, l ->

                        var country = list[pos].countryName
                        country1 = country
                        //Toast.makeText(applicationContext,"$country", Toast.LENGTH_SHORT).show()
                        binding.autoState.text.clear()
                        binding.autoCity.text.clear()
                        loadStateList(country)
                    }
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {

            }

        })
    }

    private fun loadStateList(country: String) {

        ApiClient.init().getStateList(country).enqueue(object : Callback<List<State>> {

            override fun onResponse(call: Call<List<State>>, response: Response<List<State>>) {

                var list = response.body()
                if (list == null && list?.size == 0) {
                    list = mutableListOf()
                } else {
                    list = response.body() as MutableList<State>
                }

                var adapter = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_dropdown_item,
                    list
                )
                binding.autoState.setAdapter(adapter)

                binding.autoState.setOnItemClickListener { adapterView, view, pos, l ->

                    var state = list[pos].stateName
                    state1=state
                    Toast.makeText(applicationContext, "$state", Toast.LENGTH_SHORT).show()
                    loadCityList(state)

                }

            }

            override fun onFailure(call: Call<List<State>>, t: Throwable) {

            }

        })

    }

    private fun loadCityList(states: String) {

        ApiClient.init().getCityList(states).enqueue(object : Callback<List<City>> {

            override fun onResponse(call: Call<List<City>>, response: Response<List<City>>) {

                var list = response.body()
                if (list == null && list?.size == 0) {
                    list = mutableListOf()
                } else {
                    list = response.body() as MutableList<City>
                }

                var adapter = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_dropdown_item,
                    list
                )
                binding.autoCity.setAdapter(adapter)

                binding.autoCity.setOnItemClickListener { adapterView, view, pos, l ->

                    var city = list[pos].CityName
                    city1 = city
                    Toast.makeText(applicationContext, "$city", Toast.LENGTH_SHORT).show()

                }

            }

            override fun onFailure(call: Call<List<City>>, t: Throwable) {

            }
        })
    }
}
