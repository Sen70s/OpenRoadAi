package com.tuojie.openroadai.model.entity.DiscoverScreenData

import android.icu.text.CaseMap.Title

data class PostInformation(
    val postID:String,
    val postername:String,
    val posterAvatar:String,
    val postTime:String,
    val title: String,
    val content:String,
    val likeNumber:Int,
    val discussNumber: Int,
    val tag: String
)
