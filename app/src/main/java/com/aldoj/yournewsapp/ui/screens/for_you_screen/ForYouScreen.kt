package com.aldoj.yournewsapp.ui.screens.for_you_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ForYouScreen() {
    Scaffold(containerColor = MaterialTheme.colorScheme.background) {
        AddThemes(it)
    }
}