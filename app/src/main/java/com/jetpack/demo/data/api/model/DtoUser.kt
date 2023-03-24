package com.jetpack.demo.data.api.model

import com.google.gson.annotations.SerializedName

data class DtoUser(
    @SerializedName("email")
    val email: String?,

    @SerializedName("id")
    val id: Long
)