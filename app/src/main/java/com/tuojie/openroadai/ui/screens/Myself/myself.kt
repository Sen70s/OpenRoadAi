@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Myself

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Tsunami
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tuojie.openroadai.R

/*Version0.1 MD3*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMyself() {
    CenterAlignedTopAppBar(
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

@Composable
fun ViewPrintMyself( innerPadding: PaddingValues) {
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

/*Version0.1 MD3*/
@Composable
fun UserInfoView(){
    Row (
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painterResource(R.mipmap.icon_logo),"头像",
            Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(Color(0xff3491FA))
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
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ), modifier = Modifier.fillMaxWidth()
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
        elevation = CardDefaults.cardElevation( defaultElevation = 2.dp )
    ) {
        Column {
            ListItem(
                headlineText = { Text("对话记录") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.Message, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineText = { Text("小鹿建议") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.Check, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineText = { Text("小鹿日程") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.DateRange, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineText = { Text("个人信息") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.AccountCircle, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineText = { Text("热门活动") },
                leadingContent = {
                    Icon( imageVector = Icons.Outlined.LocalActivity, contentDescription = "FunctionName", Modifier.size(32.dp) )
                },
                trailingContent = {
                    Icon( imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "GoTo", Modifier.size(32.dp) )
                }
            )
            ListItem(
                headlineText = { Text("新手教程") },
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
