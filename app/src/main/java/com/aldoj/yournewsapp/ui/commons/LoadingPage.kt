package com.aldoj.yournewsapp.ui.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aldoj.yournewsapp.ui.theme.YourNewsAppTheme

@Composable
fun LoadingPage(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    content: @Composable () -> Unit = {}
) {
    YourNewsAppTheme {
        Column(modifier = modifier) {
            if (isLoading) {
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(32.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            } else content()
        }
    }
}