package com.tuojie.openroadai.model.entity.HomeScreenData

import androidx.compose.ui.graphics.vector.ImageVector

data class TodayToDoData(
    val title:String,
    val teacherName:String,
    val classroom: String,
    val otherinfo:String,
    val icons: ImageVector
)