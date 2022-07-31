package com.test.turtlemint.utils

import java.text.SimpleDateFormat
import java.util.*

//2022-07-26T20:04:15Z
fun String.formatDate(): String {
    return try {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = dateFormat.parse(this)

        val formatter = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())

        formatter.format(date ?: "")
    } catch (e: Exception) {
        "";
    }
}