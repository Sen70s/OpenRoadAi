@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Home

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tuojie.openroadai.R

/*
@Composable
fun SearchBar(){
    Row(
        Modifier
            .padding(24.dp, 2.dp, 24.dp, 6.dp)
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(2.dp, Color.Gray, RoundedCornerShape(20.dp))
            .background(Color.Gray)
            .padding(1.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var searchText by remember { mutableStateOf("") }
        BasicTextField(
            searchText,
            { searchText = it },
            Modifier.padding(start = 24.dp).weight(1f),
            textStyle = TextStyle(fontSize = 24.sp)
        )
        {
            if(searchText.isEmpty()){
                Text(text = "Input Something?",color= Color(0xffb4b4b4), fontSize = 24.sp)
            }
            it()
        }
        Box(
            Modifier
                .padding(6.dp)
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(CircleShape)
                //.background(Color(0xfffa9e51))
                .clickable( onClick = { Log.d("Clickable", " clicked.") })
            ){
            Icon(
                painterResource(R.drawable.icon_camera), "搜索",
                modifier = Modifier.size(24.dp).align(Alignment.Center),
                tint = Color.Gray
            )
        }
    }
}
*/

/* Version:0.2 MD3 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskView(){
    Column {
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            SuggestionChip(
                enabled = true,
                onClick = { },
                label = { Text("我的日程 - 小鹿建议") }
            )
            SuggestionChip(
                enabled = true,
                onClick = { },
                label = { Text("2023/12/02") },
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation( defaultElevation = 6.dp )
        ) {
            ElevatedButton(onClick = {  },Modifier.padding(start = 10.dp,5.dp))
            {
                Icon(Icons.Filled.Create, "More")
                Text(text = "编辑日程")
            }
            Column {
                ListItem(
                    overlineText = { Text("课程") },
                    headlineText = { Text("高等数学C") },
                    supportingText = { Text("8:45-11:45 | B507 | 范老师") },
                    leadingContent = {
                        Image(
                            painterResource(R.mipmap.icon_logo),"LOGO",
                            Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xff3491FA))
                        )
                    },
                    trailingContent = { Text("重要") }
                )
                ListItem(
                    overlineText = { Text("课程") },
                    headlineText = { Text("大学英语") },
                    supportingText = { Text("14:25-17:45 | A102  | 范老师") },
                    leadingContent = {
                        Image(
                            painterResource(R.mipmap.icon_logo),"LOGO",
                            Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xff3491FA))
                        )
                    },
                    trailingContent = { Text("重要") }
                )
                ListItem(
                    overlineText = { Text("比赛") },
                    headlineText = { Text("启麓App首页制作") },
                    supportingText = { Text("F304 | TuoJie") },
                    leadingContent = {
                        Image(
                            painterResource(R.mipmap.icon_logo),"LOGO",
                            Modifier
                                .size(64.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xff3491FA))
                        )
                                     },
                    trailingContent = { Text("次重要") }
                )
            }
        }



    }
}

/* Version:0.3 MD3 */
@Composable
fun FunctionView(){
    Column {
        SuggestionChip(
            enabled = true,
            onClick = { },
            label = { Text("启麓技能 - 小鹿Ai") }
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            FloatingActionButton( onClick = {  }, ) { Icon(Icons.Filled.AddCircle, "训练计划") }
            FloatingActionButton( onClick = {  }, ) { Icon(Icons.Filled.Create, "AI智写") }
            FloatingActionButton( onClick = {  }, ) { Icon(Icons.Filled.PlayArrow, "AI翻译") }
            ExtendedFloatingActionButton(onClick = {  })
            {
                Icon(Icons.Filled.Menu, "More")
                Text(text = "更多技能")
            }
        }
    }
}

@Composable
fun TopBarHome() {
    TopAppBar(
        title = {
            Text(
                "启麓 - 启明你的一生之路.",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Localized description"
                )
            }
        },
    )
}

@Composable
fun ViewPrintHome( innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item{
            FunctionView()
        }
        item{
            TaskView()
        }
    }
}

