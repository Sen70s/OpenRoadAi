package com.tuojie.openroadai.ui.screens.PostPosts

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuojie.openroadai.ui.screens.Discover.HotSpotsView
import com.tuojie.openroadai.ui.screens.Discover.PostCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostView(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    Button(onClick = {  })
                    {
                        Icon(Icons.Filled.Send, "More")
                        Text(text = "发 布")
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ViewPrintPostView(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewPrintPostView(innerPadding: PaddingValues){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item{
            EditingArea()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditingArea(){
    var checked by remember { mutableStateOf(true) }
    var TitleText by rememberSaveable { mutableStateOf("") }
    var BodyText by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        TextField(
            value = TitleText,
            onValueChange = { TitleText = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("标题（必填）") }
        )

        LazyRow(
            Modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            item{
                ElevatedAssistChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("话 题") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "post",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
            item{
                ElevatedAssistChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("表 情") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "post",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
            item{
                ElevatedAssistChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("图 片") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "post",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
            item{
                ElevatedAssistChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("分 割 线") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "post",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
            item{
                ElevatedAssistChip(
                    enabled = true,
                    onClick = { },
                    label = { Text("视频 or 链接") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Send,
                            contentDescription = "post",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
        }

        TextField(
            value = BodyText,
            onValueChange = { BodyText = it },
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            label = { Text("畅所欲言，友善讨论（建议1000字内）") },

        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            elevation = CardDefaults.cardElevation( defaultElevation = 2.dp )
        ) {
            Column {
                ListItem(
                    headlineText = { Text("原创内容", fontWeight = FontWeight.Bold) },
                    supportingText = { Text("声明该内容为本人原创") },
                    leadingContent = {
                        Icon( imageVector = Icons.Filled.Info, contentDescription = "GoTo", Modifier.size(32.dp) )
                    },
                    trailingContent = {
                        Switch(
                            checked = checked,
                            onCheckedChange = {
                                checked = it
                            }
                        )
                    }
                )
            }
        }

    }

}