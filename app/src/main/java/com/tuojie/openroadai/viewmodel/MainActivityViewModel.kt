package com.tuojie.openroadai.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tuojie.openroadai.model.entity.BottomBarItem

class MainActivityViewModel: ViewModel() {
    val bottomBarItems by mutableStateOf(
        listOf(
            BottomBarItem("首页",Icons.Filled.Home,false),
            BottomBarItem("发现",Icons.Filled.Camera,false),
            BottomBarItem("我的",Icons.Filled.Face,false)
        )
    )

    var BottomBarItemIndex by mutableStateOf(0)
        private set

    fun updataBottomBarItemIndex(index:Int){
        BottomBarItemIndex = index
    }
}