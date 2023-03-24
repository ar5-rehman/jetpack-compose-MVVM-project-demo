package com.jetpack.demo.presentation.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.jetpack.demo.R
import com.jetpack.base.ui.TopBar
import com.jetpack.demo.components.BusinessCard
import com.jetpack.demo.components.CardCategory
import com.jetpack.demo.components.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWallet() {

    var isCategoryClicked by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(
                title = stringResource(id = R.string.sales)
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

            LazyRow{
                items(1) {
                    Category(
                        category = "Finance",
                        isClicked = isCategoryClicked,
                        onCategoryClick = {
                            isCategoryClicked = !isCategoryClicked
                        }
                    )
                }
            }

            LazyColumn {
                items(10) {
                    CardCategory(
                        onClick = {

                        }
                    )
                }
            }
        }
    }

}
