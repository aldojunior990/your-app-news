package com.aldoj.yournewsapp.ui.commons

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Date

fun formatString(value: String, max: Int): String {
    return if (value.length <= max) {
        value
    } else {
        value.substring(0, max) + "..."
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(date: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME // Ajuste conforme o formato da data fornecida
    val parsedDate = LocalDateTime.parse(date, formatter)
    val now = LocalDateTime.now()

    val years = ChronoUnit.YEARS.between(parsedDate, now)
    if (years > 0) {
        return "$years anos atrás"
    }

    val months = ChronoUnit.MONTHS.between(parsedDate, now)
    if (months > 0) {
        return "$months meses atrás"
    }

    val days = ChronoUnit.DAYS.between(parsedDate, now)
    if (days > 0) {
        return "$days dias atrás"
    }

    val hours = ChronoUnit.HOURS.between(parsedDate, now)
    return "$hours horas atrás"
}