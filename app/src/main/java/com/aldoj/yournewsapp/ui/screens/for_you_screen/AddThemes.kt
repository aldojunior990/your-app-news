package com.aldoj.yournewsapp.ui.screens.for_you_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aldoj.yournewsapp.R
import com.aldoj.yournewsapp.models.Theme
import com.aldoj.yournewsapp.ui.commons.ThemeChip
import com.aldoj.yournewsapp.ui.commons.ThemesBottomSheet

@Composable
fun AddThemes(padding: PaddingValues) {
    val showBottomSheet = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = padding.calculateBottomPadding(),
                top = padding.calculateTopPadding(),
                start = 24.dp,
                end = 24.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(
                text = stringResource(R.string.add_themes_presentation_text),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            ThemeChip(theme = Theme(title = "Esportes", isActive = false))
            ThemeChip(theme = Theme(title = "Comedia", isActive = true))

        }
        Button(onClick = { showBottomSheet.value = true }) {
            Text(
                text = stringResource(R.string.to_start),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        ThemesBottomSheet(showBottomSheet = showBottomSheet)
    }
}
