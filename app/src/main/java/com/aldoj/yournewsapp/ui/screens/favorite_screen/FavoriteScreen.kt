package com.aldoj.yournewsapp.ui.screens.favorite_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteScreen() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Favorites")
        }
    }
}