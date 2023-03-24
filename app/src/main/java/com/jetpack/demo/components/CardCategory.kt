package com.jetpack.demo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
fun CardCategory(
    onClick: () -> Unit = {}
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            .background(color = colorResource(id = R.color.gnt_light_grey))
    ) {
        val (cardImage, introduction, contacts) = createRefs()

        Image(
            modifier = Modifier
                .size(height = 40.dp, width = 68.dp)
                .constrainAs(cardImage) {
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(R.drawable.card),
            contentDescription = "card_image",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .constrainAs(introduction) {
                    start.linkTo(cardImage.end, 10.dp)
                    top.linkTo(parent.top, 10.dp)
                    bottom.linkTo(parent.bottom, 10.dp)
                }
        ) {

            Text(
                text = "Saket Dave",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                ),
                color = colorResource(id = R.color.gnt_dark_grey),
                fontFamily = FontFamily(Font(R.font.sf_pro_display_bold))
            )

            Text(
                text = "Co Founder",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 11.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                ),
                color = colorResource(id = R.color.gnt_dark_grey_2),
                fontFamily = FontFamily(Font(R.font.sf_pro_text_medium))
            )

            Text(
                text = "Waste Link",
                fontSize = 9.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                ),
                color = colorResource(id = R.color.gnt_light_grey_2),
                fontFamily = FontFamily(Font(R.font.sf_pro_display_regular))
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(contacts) {
                    end.linkTo(parent.end, 10.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }) {

            Card(
                modifier = Modifier
                    .padding(4.dp),
                elevation = CardDefaults
                    .cardElevation(
                        defaultElevation = 10.dp
                    ),
                shape = RoundedCornerShape(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_message),
                    contentDescription = "message_icon",
                )
            }

            Card(
                modifier = Modifier
                .padding(4.dp),
                elevation = CardDefaults
                    .cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_call),
                    contentDescription = "call_icon",
                )
            }
        }
    }

}

@Preview
@Composable
fun CardCategoryPreview() {
    CardCategory()
}