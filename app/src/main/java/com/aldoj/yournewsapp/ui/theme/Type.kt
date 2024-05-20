package com.aldoj.yournewsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aldoj.yournewsapp.R

val fonts = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.SemiBold),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_light, FontWeight.Light),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.ExtraBold, fontSize = 32.sp
    ), displayMedium = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp
    ), displaySmall = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp
    ), headlineSmall = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 14.sp
    ), headlineMedium = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 16.sp
    ), headlineLarge = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 18.sp
    ), titleSmall = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.SemiBold, fontSize = 12.sp
    ), titleMedium = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.SemiBold, fontSize = 14.sp
    ), titleLarge = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
    ), bodySmall = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 16.sp
    ), bodyMedium = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 18.sp
    ), bodyLarge = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 22.sp
    ), labelLarge = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 10.sp
    ), labelMedium = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 8.sp
    ), labelSmall = TextStyle(
        fontFamily = fonts, fontWeight = FontWeight.Normal, fontSize = 7.sp
    )
)