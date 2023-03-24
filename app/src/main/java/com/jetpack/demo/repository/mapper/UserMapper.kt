package com.jetpack.demo.repository.mapper

import com.jetpack.demo.data.api.model.DtoUser
import com.jetpack.demo.domain.User


fun DtoUser.toUser() = User(
    id = id,
    email = email.orEmpty()
)