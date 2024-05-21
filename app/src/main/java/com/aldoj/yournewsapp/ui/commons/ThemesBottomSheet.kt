package com.aldoj.yournewsapp.ui.commons

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.aldoj.yournewsapp.ui.theme.YourNewsAppTheme
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemesBottomSheet(showBottomSheet: MutableState<Boolean>) {
    val sheetState = rememberModalBottomSheetState()

    var themeValue by remember {
        mutableStateOf("")
    }

    YourNewsAppTheme {
        if (showBottomSheet.value) {
            ModalBottomSheet(onDismissRequest = {
                showBottomSheet.value = false
            }, sheetState = sheetState) {
                TextField(value = themeValue, onValueChange = { themeValue = it })
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Adicionar")
                }
            }
        }
    }
}