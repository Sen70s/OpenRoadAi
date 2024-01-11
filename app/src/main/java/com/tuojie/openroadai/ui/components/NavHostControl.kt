package com.tuojie.openroadai.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tuojie.openroadai.MainFarm
import com.tuojie.openroadai.ui.navigation.Destinations
import com.tuojie.openroadai.ui.screens.AiDialogue.AiDialogueView
import com.tuojie.openroadai.ui.screens.PostPosts.PostView
import com.tuojie.openroadai.ui.screens.Task.TaskEditView


@Composable
fun NavHostControl() {

    val navController = rememberNavController()

    NavHost(
        navController, startDestination = Destinations.HomeScreenNav.router
    ) {
        composable(Destinations.HomeScreenNav.router) {
            MainFarm(
                { navController.navigate(Destinations.PostScreenNav.router) },
                { navController.navigate(Destinations.TaskEditScreenNav.router) },
                {navController.navigate(Destinations.AiDialogueScreenNav.router) }
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

    }
}