package com.example.weathermvvm.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.weathermvvm.DateTimeFormatter
import com.example.weathermvvm.R
import com.example.weathermvvm.scope.ScopeFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : ScopeFragment() {

    private val TAG = HomeFragment::class.java.simpleName

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val weatherViewModel : WeatherViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        getData("Semarang")
        return root
    }

    private fun getData(city: String) = launch {
        weatherViewModel.getCurrentWeather(city).observe(this@HomeFragment, Observer {
            view!!.text_city.text = "$city City"
            view!!.text_hum.text = "Humidity: ${it.main!!.humidity}"
            view!!.text_temp.text = "Temperature: ${it.main.temp} F"
            view!!.text_pressure.text = "Pressure: ${it.main.pressure} hpa"
            view!!.text_sunrise_time.text = "Sunrise Time: ${DateTimeFormatter.toHourMinute(it.sys!!.sunrise!!.toLong())}"
            view!!.text_sunset_time.text = "Sunset Time: ${DateTimeFormatter.toHourMinute(it.sys.sunset!!.toLong())}"
            view!!.text_wind_speed.text = "Wind speed: ${it.wind!!.speed}"
        })
    }

    private fun populateUsers() {

    }
}