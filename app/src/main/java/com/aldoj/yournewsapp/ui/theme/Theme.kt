package com.aldoj.yournewsapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    secondary = primary,
    tertiary = Pink80,
    background = darkBackground,
    surface = darkBackground,
    onPrimary = onPrimary,
    onSecondary = onPrimary,
    onTertiary = onPrimary,
    onBackground = onDarkBackground,
    onSurface = onDarkBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    secondary = primary,
    tertiary = primary,
    background = lightBackground,
    surface = lightBackground,
    onPrimary = onPrimary,
    onSecondary = onPrimary,
    onTertiary = onPrimary,
    onBackground = onLightBackground,
    onSurface = onLightBackground,
)

@Composable
fun YourNewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}