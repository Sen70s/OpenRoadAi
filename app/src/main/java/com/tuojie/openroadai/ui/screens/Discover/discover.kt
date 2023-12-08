@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Discover

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuojie.openroadai.R

@Composable
fun ViewPrintDiscover( innerPadding: PaddingValues, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item{
            HotSpotsView()
        }
        item{
            PostCard()
        }
        item{
            PostCard()
        }
    }
}

/*Version0.1 MD3*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDiscover(navController: NavController) {
    var dragDistance by remember { mutableStateOf(0F) }
    val draggableState = rememberDraggableState(onDelta = { dragDistance += it })
    TopAppBar(
        title = {
            Text(
                "发现",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(end=10.dp)
            )
        },
        actions = {
            ElevatedAssistChip(
                modifier = Modifier
                    .draggable(
                        draggableState, Orientation.Vertical,
                        onDragStarted = { offset ->
                            if(dragDistance.dp > 250.dp){
                                navController.navigate("postView"){ popUpTo("home") }
                            }
                        }
                    ),
                enabled = true,
                onClick = { },
                label = { Text("长按我然后下滑发帖") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Send,
                        contentDescription = "post",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            )
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "信息"
                )
            }
        }
    )

}

/*Version0.1 MD3*/
@Composable
fun HotSpotsView(){
    Column {
        Row{
            SuggestionChip(
                enabled = true,
                onClick = { },
                label = { Text("热门话题") }
            )
            SuggestionChip(
                modifier = Modifier.padding(start = 10.dp),
                onClick = { },
                label = { Text("查看更多 >") }
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ){
            item{
                ElevatedCard(modifier = Modifier.width(250.dp)
                ) {
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                }
            }
            item{
                ElevatedCard(modifier = Modifier.width(250.dp)
                ) {
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                    Column {
                        ListItem(
                            headlineText = { Text("每日一练") },
                            supportingText = { Text("999人参与") },
                            leadingContent = { Icon( imageVector = Icons.Filled.Star, contentDescription = "信息" ) }
                        )
                    }
                }
            }
        }
    }
}

/*Version0.1 MD3*/
@Composable
fun PostCard(){
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation( defaultElevation = 6.dp )
    ) {
        Column(Modifier.padding(5.dp,10.dp,5.dp,10.dp)) {
            /*顶部 发帖人信息*/
            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painterResource(R.mipmap.icon_logo),"头像",
                    Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(Color(0xff3491FA))
                )
                Column (verticalArrangement = Arrangement.Center){
                    Text(text = "HerSen", fontWeight = FontWeight.Bold)
                    Text(text = "OpenRoadAi - developer")
                }
                FloatingActionButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Localized description"
                    )
                }
            }

            /*中部内容 - 图片滚动表*/
            LazyRow(
                Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
                    .clip(RoundedCornerShape(20.dp)),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                item {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .fillMaxSize()
                            .background(Color(0xff3491FA))
                    )
                }
                item {
                    Image(
                        painterResource(R.mipmap.iamge_success),"LOGO",
                        Modifier
                            .fillMaxSize()
                            .background(Color(0xff3491FA))
                    )
                }
                item {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .fillMaxSize()
                            .background(Color(0xff3491FA))
                    )
                }
            }

            /*中部内容 - 文本 and 话题标签*/
            Column {
                Text(
                    "启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.启麓 - 启明你的一生之路.",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                SuggestionChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("# 每日分享") },
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            /*底部 - 操作按钮*/
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround){
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.ThumbUp,
                        contentDescription = "Localized description"
                    )
                }
            }

        }
    }
}


