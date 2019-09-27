package com.example.weathermvvm

import java.text.SimpleDateFormat
import java.util.*

class DateTimeFormatter {
    companion object{
        private val dateTime = Calendar.getInstance()
        private val hourMinute = SimpleDateFormat("HH:mm", Locale.US)

        fun toHourMinute(millis: Long) : String{
            dateTime.timeInMillis = millis
            return hourMinute.format(dateTime.time)
        }
    }
}