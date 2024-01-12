package com.tuojie.openroadai.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tuojie.openroadai.MainFarm
import com.tuojie.openroadai.compositionLocal.LocalMainActivityViewModel
import com.tuojie.openroadai.ui.navigation.Destinations
import com.tuojie.openroadai.ui.screens.AiDialogue.AiDialogueView
import com.tuojie.openroadai.ui.screens.Login.LoginView
import com.tuojie.openroadai.ui.screens.PostPosts.PostView
import com.tuojie.openroadai.ui.screens.Task.TaskEditView
import com.tuojie.openroadai.viewmodel.MainActivityViewModel


@Composable
fun NavHostControl() {

    val navController = rememberNavController()
    CompositionLocalProvider(LocalMainActivityViewModel provides MainActivityViewModel(LocalContext.current)) {

        NavHost(
            navController, startDestination = Destinations.HomeScreenNav.router
        ) {
            composable(Destinations.HomeScreenNav.router) {
                MainFarm(
                    { navController.navigate(Destinations.PostScreenNav.router) },
                    { navController.navigate(Destinations.TaskEditScreenNav.router) },
                    {navController.navigate(Destinations.AiDialogueScreenNav.router) },
                    {navController.navigate(Destinations.LoginScreenNav.router){popUpTo(Destinations.HomeScreenNav.router)} }
                )
            }
            composable(Destinations.PostScreenNav.router) {
                PostView()
            }

            composable(Destinations.TaskEditScreenNav.router){
                TaskEditView()
            }

            composable(Destinations.AiDialogueScreenNav.router){
                AiDialogueView()
            }

            composable(Destinations.LoginScreenNav.router){
                LoginView{navController.popBackStack()}
            }
        }



    }


}