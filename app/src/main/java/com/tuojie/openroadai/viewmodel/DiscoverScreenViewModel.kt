package com.tuojie.openroadai.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tuojie.openroadai.model.entity.DiscoverScreenData.TabCategory
import com.tuojie.openroadai.model.entity.DiscoverScreenData.PostInformation

class DiscoverScreenViewModel: ViewModel() {
    val tabRowCategory by mutableStateOf(
        listOf(
            TabCategory("热 点"),
            TabCategory("社 区")
        )
    )

    var tabRowCategoryIndex by mutableStateOf(0)
        private set

    fun updatatabRowCategoryIndex(index:Int){
        tabRowCategoryIndex = index
    }

    val discoverPostList by mutableStateOf(
        listOf(
            PostInformation("Pid1001","HerSen",
                "http://q2.qlogo.cn/headimg_dl?dst_uin=2985222366&spec=100","2024/1/1","启麓开发日志",
                "今天是拓界·启麓的开发日志第五天啦！现在已经开发了很多的界面和功能啦，等待后续的公测和大家相见吧！",
                100,100,"池塘"),
            PostInformation("Pid1002","杰哥",
                "http://q2.qlogo.cn/headimg_dl?dst_uin=3592128405&spec=100","2024/1/1","",
                "我这一生如履薄冰又如何到达对岸呢",
                100,100,"池塘"),
            PostInformation("Pid1003","黑沐",
                "http://q2.qlogo.cn/headimg_dl?dst_uin=17179830&spec=100","2024/1/1","启麓登岛成功！",
                "诶嘿！终于体验一把了！",
                100,100,"池塘")

        )
    )
}