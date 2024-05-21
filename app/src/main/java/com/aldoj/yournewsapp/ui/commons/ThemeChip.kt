package com.aldoj.yournewsapp.ui.commons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aldoj.yournewsapp.models.Theme
import com.aldoj.yournewsapp.ui.theme.YourNewsAppTheme

@Composable
fun ThemeChip(theme: Theme, onClick: () -> Unit = {}) {
    YourNewsAppTheme {
        AssistChip(onClick = { onClick() },
            shape = MaterialTheme.shapes.extraLarge,
            colors = AssistChipDefaults.assistChipColors(
                containerColor = if (theme.isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
            ),
            label = {
                Text(
                    text = theme.title,
                    style = MaterialTheme.typography.labelLarge,
                    color = if (theme.isActive) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onBackground
                )
            },
            trailingIcon = {
                if (theme.isActive) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(16.dp)
                    )
                }
            })
    }
}