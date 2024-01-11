package com.tuojie.openroadai.ui.navigation

sealed class Destinations(val router: String){
    object HomeScreenNav : Destinations("home")
    object PostScreenNav : Destinations("PostView")
    object AiDialogueScreenNav : Destinations("AiDialogueView")
    object LoginScreenNav : Destinations("Login")
    object TaskEditScreenNav : Destinations("TaskEdit")

}