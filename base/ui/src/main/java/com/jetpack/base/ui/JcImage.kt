package com.jetpack.base.ui

import android.net.Uri
import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@Composable
fun JcImage(modifier: Modifier, url: String?, placeHolder: Int = R.drawable.place_holder) {
    var originUrl = remember { url }
    AndroidView(
        modifier = modifier,
        factory = {
            ImageView(it).apply {
                Glide.with(this)
                    .load(Uri.parse(originUrl.orEmpty()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(placeHolder)
                    .into(this)
            }
        },
        update = {
            if (originUrl != url) {
                originUrl = url
                Glide.with(it)
                    .load(Uri.parse(originUrl.orEmpty()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(placeHolder)
                    .into(it)
            }
        }
    )
}