@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tuojie.openroadai.compositionLocal.LocalMainActivityViewModel
import com.tuojie.openroadai.ui.components.NavHostControl
import com.tuojie.openroadai.ui.screens.Discover.DiscoverScreen
import com.tuojie.openroadai.ui.screens.Discover.DiscoverScreenTopBar
import com.tuojie.openroadai.ui.screens.Home.HomeScreen
import com.tuojie.openroadai.ui.screens.Home.HomeScreenTopBar
import com.tuojie.openroadai.ui.screens.Myself.MineScreen
import com.tuojie.openroadai.ui.screens.Myself.MineScreenTopBar
import com.tuojie.openroadai.ui.theme.OpenRoadAiTheme
import com.tuojie.openroadai.viewmodel.MainActivityViewModel


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            OpenRoadAiTheme {
                NavHostControl()
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFarm(
    onNavigateToPostEdit: () -> Unit = {},
    onNavigateToTaskEdit: () -> Unit = {},
    onNavigateToAiDialog: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
){
    val mainVM = LocalMainActivityViewModel.current
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    mainVM.bottomBarItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(item.icons, contentDescription = item.title) },
                            label = { Text(item.title) },
                            selected = mainVM.BottomBarItemIndex == index,
                            onClick = { mainVM.updataBottomBarItemIndex(index) },
                            alwaysShowLabel = item.isAlwayShowTitle
                        )
                    }
                },

                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { onNavigateToAiDialog.invoke() },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            painterResource(id = R.mipmap.icon_logo),
                            "AiLogo",
                            tint = Color.Unspecified,
                            modifier = Modifier.width(32.dp)
                        )
                    }
                }
            )
        },
        topBar = {
            when(mainVM.BottomBarItemIndex){
                0 -> HomeScreenTopBar()
                1 -> DiscoverScreenTopBar(onNavigateToPostEdit)
                2 -> {if (mainVM.logged) MineScreenTopBar()}
            }
        }
    ) { innerPadding ->
        when (mainVM.BottomBarItemIndex) {
            0 -> { HomeScreen(innerPadding,onNavigateToTaskEdit) }
            1 -> { DiscoverScreen(innerPadding) }
            2 -> {
                if (!mainVM.logged){
                    onNavigateToLogin.invoke()
                    mainVM.updataBottomBarItemIndex(0)
                }
                MineScreen(innerPadding)
            }
            }
        }
}




