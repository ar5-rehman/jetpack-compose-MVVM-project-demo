package com.jetpack.base.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetpack.base.theme.colorMain

@Composable
fun CtaButton(text: String, enable: Boolean = true, onClicked: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        contentPadding = PaddingValues(16.dp),
        enabled = enable,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorMain,
            contentColor = Color.White
        ),
        onClick = onClicked
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.titleMedium
        )
    }
}