package com.jetpack.demo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpack.demo.presentation.wallet.ScreenWallet
import com.jetpack.demo.presentation.profile.ScreenProfile
import com.jetpack.demo.presentation.scan.ScreenScan

@Composable
fun MainNavigation(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationTarget.Wallet.route
    ) {
        composable(route = NavigationTarget.Wallet.route) {
            ScreenWallet()
        }
        composable(route = NavigationTarget.Scan.route) {
            ScreenScan()
        }
        composable(route = NavigationTarget.Profile.route) {
            ScreenProfile()
        }
    }
}
