package com.aldoj.yournewsapp.ui.commons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aldoj.yournewsapp.ui.theme.YourNewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(title: String, onBack: () -> Unit = {}) {
    YourNewsAppTheme {
        Column {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onBackground
                ),
                title = { Text(text = title, style = MaterialTheme.typography.headlineMedium) },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack, contentDescription = ""
                        )
                    }
                })

            Divider(thickness = 0.5.dp, color = Color.LightGray, modifier = Modifier.fillMaxWidth())
        }
    }
}