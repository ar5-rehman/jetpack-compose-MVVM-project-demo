package com.jetpack.demo.presentation.scan

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jetpack.demo.R
import com.jetpack.base.ui.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenScan() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(id = R.string.scan_card)
            )
        }
    ) {
        ContentScan(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
private fun ContentScan(
    modifier: Modifier
) {

    LazyColumn(
        modifier = modifier
    ) {

    }

}