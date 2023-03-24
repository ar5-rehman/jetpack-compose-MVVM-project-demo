package com.jetpack.demo.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.jetpack.base.ui.TopBar
import com.jetpack.demo.components.BusinessCard
import com.jetpack.demo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenProfile(
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(id = R.string.my_business_card)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    color = colorResource(
                        id = R.color.gnt_white
                    )
                )
        ) {

            BusinessCard()

            Text(
                modifier =  Modifier.padding(10.dp),
                text = stringResource(id = R.string.personal_details),
                fontFamily = FontFamily(Font(R.font.sf_pro_display_bold))
            )
        }
    }
}
