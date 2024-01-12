package com.tuojie.openroadai.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuojie.openroadai.model.entity.BottomBarItem
import com.tuojie.openroadai.model.entity.UserInformation
import com.tuojie.openroadai.model.manager.UserInformationManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class MainActivityViewModel(context:Context): ViewModel() {

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

    /*处理用户信息*/

    var userInfo: UserInformation? = null
        private  set


    private  val userInfoManager = UserInformationManager(context)

    init{
        viewModelScope.launch {
            val userName = userInfoManager.userName.firstOrNull()
            val userID = userInfoManager.userID.firstOrNull()
            userInfo = if(userName?.isEmpty() == true){
                null
            }else{
                userName?.let { UserInformation(it, userID!!) }
            }
        }
    }

    val logged: Boolean
        get(){
            return  userInfo != null
        }

    fun login(){
        //网络请求回传
        userInfo = UserInformation("HerSen",1001)
        viewModelScope.launch {
            userInfoManager.saveData("HerSen",1001)
        }
    }

    fun exit(){
        userInfo = null
        viewModelScope.launch {
            userInfoManager.clearData()
        }
    }

}