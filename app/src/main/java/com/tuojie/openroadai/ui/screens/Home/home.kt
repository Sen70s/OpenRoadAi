@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuojie.openroadai.R
import com.tuojie.openroadai.ui.screens.Task.TaskInformation

@Composable
fun ExpandedSearchView(
) {
    val focusManager = LocalFocusManager.current
    val textFieldFocusRequester = remember { FocusRequester() }
    SideEffect {
        textFieldFocusRequester.requestFocus()
    }
    var textFieldValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(textFieldFocusRequester),
            label = {
                Text(text = "输入内容")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHome() {
    val ExpandState = remember { mutableStateOf(false) }


    val isShowMeuns = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Crossfade(targetState = ExpandState, label = "") { isChange ->
                when(isChange.value){
                    true -> ExpandedSearchView()
                    false -> Text(text = "启麓")
                }
            }
        },
        actions = {
            IconButton(onClick = { ExpandState.value = !ExpandState.value }) {
                Crossfade(targetState = ExpandState, label = "") { isChange ->
                    when(isChange.value){
                        false -> Icon(Icons.Default.Search,"Search")
                        true -> Icon(Icons.Default.Close,"Close")
                    }
                }
            }
            IconButton(onClick = { isShowMeuns.value = !isShowMeuns.value }) {
                Icon(Icons.Default.MoreVert,"More")
            }
            Box(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                DropdownMenu(
                    expanded = isShowMeuns.value,
                    onDismissRequest = { isShowMeuns.value = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Edit") },
                        onClick = { },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Edit,
                                contentDescription = null
                            )
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Settings") },
                        onClick = {  },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Settings,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }

    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FunctionView(){
    Column {
        SuggestionChip(
            enabled = true,
            onClick = { },
            label = { Text("启麓技能 - 小鹿Ai") }
        )
        FlowRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button( onClick = {  }, ) { Icon(Icons.Filled.AddCircle, "训练计划") }
                Text(text = "训练计划", style = MaterialTheme.typography.bodyMedium)
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button( onClick = {  }, ) { Icon(Icons.Filled.Create, "AI智写") }
                Text(text = "AI智写", style = MaterialTheme.typography.bodyMedium)
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button( onClick = {  }, ) { Icon(Icons.Filled.PlayArrow, "AI翻译") }
                Text(text = "AI翻译", style = MaterialTheme.typography.bodyMedium)
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button( onClick = {  }, ) { Icon(Icons.Filled.Menu, "More") }
                Text(text = "更多技能", style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskView(navController: NavController){
    val isShow = remember { mutableIntStateOf(0) }

    Column (
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            SuggestionChip(
                enabled = true,
                onClick = { },
                label = { Text("我的日程 - 小鹿建议") }
            )
            SuggestionChip(
                enabled = true,
                onClick = { },
                label = { Text("2023/12/13") },
                modifier = Modifier.padding(start = 5.dp)
            )
        }

        ElevatedCard {
            ListItem(
                modifier = Modifier.clickable { isShow.value = 1 },
                headlineText = { Text("高等数学C") },
                supportingText = { Text("8:45-11:45 | B507 | 李老师") },
                leadingContent = {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            )
        }

        ElevatedCard {
            ListItem(
                modifier = Modifier.clickable {  isShow.value = 1 },
                headlineText = { Text("高等数学C") },
                supportingText = { Text("8:45-11:45 | B507 | 李老师") },
                leadingContent = {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            )
        }

        ElevatedCard {
            ListItem(
                modifier = Modifier.clickable {  isShow.value = 1 },
                headlineText = { Text("高等数学C") },
                supportingText = { Text("8:45-11:45 | B507 | 李老师") },
                leadingContent = {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            )
        }
         when(isShow.value){
             1 -> isShow.value = TaskInformation()
             2 -> {
                 isShow.value = 0
                 navController.navigate("TaskEdit")
             }
             else -> {}
         }

    }
}

@Composable
fun ViewPrintHome( innerPadding: PaddingValues,navController: NavController) {
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
            TaskView(navController)
        }
    }
}
