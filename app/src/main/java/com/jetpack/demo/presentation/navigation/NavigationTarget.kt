package com.jetpack.demo.presentation.navigation


sealed class NavigationTarget(var route: String) {
    object Wallet : NavigationTarget("app://home")
    object Scan : NavigationTarget("app://scan")
    object Profile : NavigationTarget("app://profile")
}
