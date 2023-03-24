package com.jetpack.base.ui.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface IconSource {
    data class Vector(val icon: ImageVector) : IconSource
    data class IconResourceSource(@DrawableRes val icon: Int) : IconSource
}