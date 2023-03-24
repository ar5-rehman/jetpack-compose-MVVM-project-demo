package com.jetpack.demo.presentation

import android.os.Bundle
import com.jetpack.demo.R
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jetpack.base.theme.AppTheme
import com.jetpack.demo.presentation.navigation.MainNavigation
import com.jetpack.demo.presentation.navigation.NavigationTarget
import dagger.hilt.android.AndroidEntryPoint

private sealed class NavItem(
    val icon: Int,
    @StringRes val title: Int,
    val target: NavigationTarget
) {
    companion object {
        fun bottomBarItems() = listOf(Wallet, Scan, Profile)
    }

    object Wallet : NavItem(
        R.drawable.ic_home,
        R.string.wallet,
        NavigationTarget.Wallet
    )

    object Scan : NavItem(
        R.drawable.ic_scan,
        R.string.scan,
        NavigationTarget.Scan
    )

    object Profile : NavItem(
        R.drawable.ic_profile,
        R.string.profile,
        NavigationTarget.Profile
    )
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainApp() }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainApp() {
        val navController = rememberNavController()
        AppTheme(useDarkTheme = false) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding(),
                bottomBar = {
                    BottomBar(navController = navController)
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        MainNavigation(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            navController = navController
                        )
                    }
                }
            )
        }
    }

    @Composable
    private fun BottomBar(navController: NavController) {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)),
            contentPadding = PaddingValues(0.dp)
        ) {
            NavItem.bottomBarItems().forEach {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val isSelected = navBackStackEntry?.destination?.route == it.target.route
                BottomBarItem(
                    navItem = it,
                    isSelected = isSelected,
                    contentColor = colorResource(id = R.color.gnt_grey),
                    selectedContentColor = colorResource(id = R.color.gnt_white),
                    onClick = {
                        navController.navigate(it.target.route)
                    }
                )
            }
        }
    }
}

@Composable
private fun RowScope.BottomBarItem(
        navItem: NavItem,
        isSelected: Boolean,
        contentColor: Color,
        selectedContentColor: Color,
        onClick: (NavItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color.Black)
            .clickable { onClick(navItem) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(
                    if(isSelected){
                        colorResource(id = R.color.gnt_light)
                    }else{
                        Color.Black
                    }
                ),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(navItem.icon),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(if (isSelected) selectedContentColor else contentColor)
                )

                Text(
                    fontSize = 11.sp,
                    fontFamily = FontFamily(
                        if(isSelected){
                            Font(R.font.urbanist_bold)
                        }else{
                            Font(R.font.urbanist_medium)
                        }
                    ),
                    text = stringResource(id = navItem.title),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isSelected) selectedContentColor else contentColor
                )
            }
        }
    }
}
