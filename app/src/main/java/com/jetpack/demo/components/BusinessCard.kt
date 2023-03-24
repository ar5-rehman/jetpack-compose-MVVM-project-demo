package com.jetpack.demo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jetpack.demo.R

@Composable
fun BusinessCard() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp, 25.dp, 25.dp, 25.dp))
    ) {
        val (introduction, contacts, wasteLink, qrCode, buttons) = createRefs()

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            painter = painterResource(R.drawable.ic_card_background),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .constrainAs(introduction) {
                    start.linkTo(parent.start, 20.dp)
                    top.linkTo(parent.top, 25.dp)
                }
        ) {

            Text(
                text = "John Doe",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_bold))
            )

            Text(
                text = "Co Founder",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily(Font(R.font.sf_pro_display_regular))
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(contacts) {
                    start.linkTo(parent.start, 20.dp)
                    bottom.linkTo(parent.bottom, 25.dp)
                }) {

            Row(
                modifier = Modifier.padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.shadow(elevation = 15.dp),
                    painter = painterResource(id = R.drawable.ic_call),
                    contentDescription = "call_icon",
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "+91 98989 44444",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily(Font(R.font.sf_pro_display_medium))
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.shadow(elevation = 15.dp),
                    painter = painterResource(id = R.drawable.ic_message),
                    contentDescription = "message_icon",
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "abc@gmail.com",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily(Font(R.font.sf_pro_display_medium))
                )
            }
        }

        Text(
            modifier = Modifier
                .constrainAs(wasteLink) {
                    end.linkTo(parent.end, 20.dp)
                    top.linkTo(parent.top, 25.dp)
                },
            text = stringResource(id = R.string.waste_link),
            maxLines = 1,
            color = colorResource(id = R.color.gnt_light_green),
            fontFamily = FontFamily(Font(R.font.sf_pro_display_medium))
        )

        Image(
            modifier = Modifier
                .constrainAs(qrCode) {
                    end.linkTo(parent.end, 20.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            painter = painterResource(id = R.drawable.ic_qrcode),
            contentDescription = "qr_code_icon",
        )

        Row(
            modifier = Modifier
                .constrainAs(buttons) {
                    end.linkTo(parent.end, 20.dp)
                    bottom.linkTo(parent.bottom, 25.dp)
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "edit_icon",
                )
            }

            Card(
                elevation = CardDefaults
                    .cardElevation(
                        defaultElevation = 10.dp
                    ),
                shape = RoundedCornerShape(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "send_icon",
                )
            }
        }
    }

}

@Preview
@Composable
fun MyViewPreview() {
    BusinessCard()
}