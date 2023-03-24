package com.jetpack.demo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jetpack.demo.R

@Composable
fun Category(
    category: String,
    isClicked: Boolean = false,
    onCategoryClick: () -> Unit = {}
) {

    ConstraintLayout(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onCategoryClick()
            }
            .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
            .background(color = if(isClicked){
                colorResource(id = R.color.gnt_c_green)
            }else{
                colorResource(id = R.color.gnt_light_grey_3)
            })

    ) {

        val (categoryText) = createRefs()

        Text(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                .constrainAs(categoryText) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            text = category,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
            ),
            color = if(isClicked){
                colorResource(id = R.color.gnt_white)
            }else{
                colorResource(id = R.color.gnt_light_white)
                 },
            fontFamily = FontFamily(Font(R.font.sf_pro_display_bold))
        )
    }

}

@Preview
@Composable
fun CategoryPreview() {
    Category("Finance")
}