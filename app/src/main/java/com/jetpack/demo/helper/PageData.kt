package com.jetpack.demo.helper

data class PageData<T>(
    val isEnd: Boolean,
    val data: List<T>
)