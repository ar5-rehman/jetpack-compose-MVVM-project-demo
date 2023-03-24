package com.jetpack.base.ui.settings

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jetpack.base.ui.icon.IconSource

@Composable
fun JcSettingButton(
    modifier: Modifier,
    icon: IconSource? = null,
    title: String,
    summary: String? = null,
    buttonText: String,
    onBtnClicked: () -> Unit
) {
    JcSettingItem(
        modifier = modifier,
        title = title,
        summary = summary,
        icon = icon,
        widget = {
            Button(onClick = onBtnClicked) {
                Text(text = buttonText)
            }
        }
    )
}