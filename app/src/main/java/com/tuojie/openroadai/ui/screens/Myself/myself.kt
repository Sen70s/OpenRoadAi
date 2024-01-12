@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Myself

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.tuojie.openroadai.viewmodel.MainActivityViewModel

/*Version0.1 MD3*/
@Composable
fun MineScreen(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item{
            UserInfoView()
        }
        item{
            UserData()
        }
        item {
            MegaMemberData()
        }
        item {
            MoreFunctionView()
        }
    }
}


@Composable
fun MineScreenTopBar(){
    TopAppBar(
        title = {
            Text(
                "我的",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "信息"
                )
            }
        }
    )
}

/*Version0.1 MD3*/
@Composable
fun UserInfoView(){
    Row (
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            "http://q2.qlogo.cn/headimg_dl?dst_uin=2985222366&spec=100", "Avatar",
            Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(Color.Transparent)
        )
        Column (verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 10.dp)){
            Text(text = "HerSen", fontWeight = FontWeight.Bold)
            Row{
                SuggestionChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("Developer") }
                )
                SuggestionChip(
                    modifier = Modifier.padding(start = 10.dp),
                    enabled = true,
                    onClick = { },
                    label = { Text("星会员") }
                )
            }
        }
    }
}

/*Version0.1 MD3*/
@Composable
fun UserData(){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Column {
            Text(text = "90")
            Text(text = "帖子")
        }
        Column {
            Text(text = "142")
            Text(text = "收藏")
        }
        Column {
            Text(text = "90")
            Text(text = "题本")
        }
    }
}

/*Version0.1 MD3*/
@Composable
fun MegaMemberData(){
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row (verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "MegaMemberIcon",
                        Modifier.size(32.dp)
                    )
                    Column (Modifier.padding(start = 5.dp),verticalArrangement = Arrangement.Center){
                        Text(text = "成为星会员", fontWeight = FontWeight.Bold)
                        Text(text = "了解更多权益")
                    }
                }
                Text(text = "立即开通  >", fontWeight = FontWeight.Bold)
            }
        }
}

/*Version0.1 MD3*/
@Composable
fun MoreFunctionView(){
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation( defaultElevation = 1.dp )
    ) {
        Column {
            ListItem(
                headlineContent = { Text("对话记录") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.Message, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineContent = { Text("小鹿建议") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.Check, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineContent = { Text("小鹿日程") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.DateRange, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineContent = { Text("个人信息") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.AccountCircle, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineContent = { Text("热门活动") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.LocalActivity, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineContent = { Text("新手教程") },
                leadingContent = {
                    Icon( imageVector = Icons.Filled.EmojiPeople, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
        }
    }
}
