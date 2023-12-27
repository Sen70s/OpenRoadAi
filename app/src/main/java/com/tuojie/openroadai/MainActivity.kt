@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tuojie.openroadai.ui.screens.AiDialogue.AiDialogueView
import com.tuojie.openroadai.ui.screens.Discover.TopBarDiscover
import com.tuojie.openroadai.ui.screens.Discover.ViewPrintDiscover
import com.tuojie.openroadai.ui.screens.Home.TopBarHome
import com.tuojie.openroadai.ui.screens.Home.ViewPrintHome
import com.tuojie.openroadai.ui.screens.Login.LoginView
import com.tuojie.openroadai.ui.screens.Myself.TopBarMyself
import com.tuojie.openroadai.ui.screens.Myself.ViewPrintMyself
import com.tuojie.openroadai.ui.screens.PostPosts.PostView
import com.tuojie.openroadai.ui.screens.Task.TaskEditView
import com.tuojie.openroadai.ui.theme.OpenRoadAiTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)

        val res = super.getResources()

        if (res != null) {
            val config = res.configuration
            config.fontScale = 1.0f
        }

        setContent{
            OpenRoadAiTheme{
                PagesController()
            }
        }
    }
}

@Composable
fun PagesController (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { AppNavBar(navController) }
        composable("postView"){PostView(navController)}
        composable("AiDialogueView"){AiDialogueView(navController)}
        composable("Login"){LoginView(navController)}
        composable("TaskEdit"){TaskEditView(navController)}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavBar(navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    Scaffold(

        bottomBar = {
            BottomAppBar(
                actions = {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text("首页") },
                        selected = selectedItem == 0,
                        onClick = { selectedItem = 0 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Discover") },
                        label = { Text("发现") },
                        selected = selectedItem == 1,
                        onClick = { selectedItem = 1 }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Face, contentDescription = "My") },
                        label = { Text("我的") },
                        selected = selectedItem == 2,
                        onClick = { selectedItem = 2 }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { navController.navigate("AiDialogueView"){ popUpTo("home") } },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(painterResource(id = R.mipmap.icon_logo),"AiLogo",tint = Color.Unspecified, modifier = Modifier.width(32.dp))
                    }
                }
            )
        },
        topBar = {
            GetAppTopBar( selectedItem, navController)
        }
        ) {
            innerPadding ->
            when(selectedItem) {
                0 -> { ViewPrintHome(innerPadding,navController) }
                1 -> { ViewPrintDiscover(innerPadding,navController) }
                2 -> { ViewPrintMyself(innerPadding) }
                else -> { /*ViewPrintHome(innerPadding,navController) */}
            }
    }
}


@Composable
fun GetAppTopBar(indexNum : Int, navController: NavController) {
    when(indexNum){
        0 -> { TopBarHome() }
        1 -> { TopBarDiscover(navController) }
        2 -> { TopBarMyself() }
    }
}