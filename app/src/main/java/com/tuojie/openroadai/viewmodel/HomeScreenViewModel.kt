package com.tuojie.openroadai.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Extension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tuojie.openroadai.model.entity.HomeScreenData.TodayToDoData
import com.tuojie.openroadai.model.entity.HomeScreenData.AIDeerSkill

class HomeScreenViewModel: ViewModel() {

    //小鹿AI技能
    val AIDeerSkill by mutableStateOf(
        listOf(
            AIDeerSkill("训练计划",Icons.Filled.AddCircle),
            AIDeerSkill("AI智写",Icons.Filled.Edit),
            AIDeerSkill("AI翻译",Icons.Filled.ChangeCircle),
            AIDeerSkill("更多技能",Icons.Filled.Extension),
        )
    )

    //技能索引下标
    var AIDeerSkillIndex by mutableStateOf(0)
        private set

    //更新技能索引下标
    fun updataAIDeerSkillIndex (index: Int) {
        AIDeerSkillIndex = index
    }

    //我的日程
    val todayToDoLists by mutableStateOf(
        listOf(
            TodayToDoData(
                "高等数学B","范老师","B507","8:45-11:45",
                Icons.Filled.Class
            ),
            TodayToDoData(
                "大学英语","李老师","A305","13:45-15:45",
                Icons.Filled.ClearAll
            )
        )
    )

}


