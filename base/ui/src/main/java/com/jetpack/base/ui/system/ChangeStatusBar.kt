package com.jetpack.base.ui.system

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBar(color: Color) {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(color) {
        systemUiController.setStatusBarColor(color = color)
    }
}