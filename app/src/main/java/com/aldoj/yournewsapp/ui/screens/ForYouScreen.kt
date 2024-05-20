package com.aldoj.yournewsapp.ui.screens

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
        Column(modifier = Modifier.padding(it)) {
            Text(text = "For You")
        }
    }
}