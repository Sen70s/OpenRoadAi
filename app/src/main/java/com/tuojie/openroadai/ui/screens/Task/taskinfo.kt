package com.tuojie.openroadai.ui.screens.Task

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.Button
import androidx.compose.material3.TimePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import java.text.SimpleDateFormat
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale
import androidx.compose.material3.AlertDialog as AlertDialog1

@SuppressLint("RememberReturnType")
@Composable
fun TaskInformation(): Int{
    val isOpen = remember { mutableStateOf(1) }
    AlertDialog1(
        /*当用户点击对话框以外的地方或者按下系统返回键将会执行的代码*/
        onDismissRequest = { isOpen.value = 0 },
        title =
        {
            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "高等数学B", style = MaterialTheme.typography.titleLarge)
                IconButton(onClick = { isOpen.value = 2 }) {
                    Icon(Icons.Default.Edit,"编辑")
                }
            }
        },
        text = {
            Column {
                Text( "2023/12/27", style = MaterialTheme.typography.bodyLarge)
                Text( "周三|第3-4节|10:25-11:55", style = MaterialTheme.typography.bodyLarge)
                Text( "教师：范老师", style = MaterialTheme.typography.bodyLarge)
                Text( "教室：B507", style = MaterialTheme.typography.bodyLarge)
            }

        },
        confirmButton = {
            Button(
                onClick = { isOpen.value = 0 }
            ) {
                Text("确认")
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = { isOpen.value = 0 },
                //colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Text("删除")
            }
        }

    )
    return isOpen.value
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditView(navController: NavController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("编辑事件", style = MaterialTheme.typography.titleLarge)},
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {  }) { Icon(Icons.Default.Save, "Save") }
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { innerPadding -> TaskEditBody(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditBody(innerPadding: PaddingValues){
    val isOpenDatePicker = remember { mutableStateOf(false) }
    val isOpenTimePicker = remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
    val TimePickerState = rememberTimePickerState()
    val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){

        item{
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFieldValue,
                onValueChange = {
                    textFieldValue = it
                },
                label = {
                    Text(text = "添加事件")
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
                textStyle = TextStyle.Default
            )
        }

        /*事件描述*/
        item{
            ListItem(
                leadingContent = { Icon( Icons.Default.TextFields, "The info of the Task") },
                headlineText = {
                    TextField(
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValue = it
                        },
                        label = {
                            Text(text = "添加描述")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        ),
                        shape = TextFieldDefaults.outlinedShape
                    )
                }
            )
        }

        /*事件类型*/
        item{
            ListItem(
                leadingContent = { Icon( Icons.Default.Tag, "The Tag of the Task") },
                headlineText = {
                    LazyRow (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                    ){
                        item {
                            SuggestionChip(
                                enabled = true,
                                onClick = { },
                                label = { Text("课程") }
                            )
                        }
                        item {
                            SuggestionChip(
                                enabled = true,
                                onClick = { },
                                label = { Text("比赛") }
                            )
                        }
                    }

                },
                trailingContent = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Add,"Add Task Style")
                    }
                }
            )
        }

        /*选择日期*/
        item{
            ListItem(
                leadingContent = { Icon( Icons.Default.DateRange, "The DateRange of the Task") },
                headlineText = {
                    Row (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                    ){
                        SuggestionChip(
                            enabled = true,
                            onClick = { isOpenDatePicker.value = true },
                            label = { Text("2023/12/27") }
                        )
                        SuggestionChip(
                            enabled = true,
                            onClick = { isOpenTimePicker.value = true },
                            label = { Text("10:25-11:25") }
                        )

                    }
                }
                /*实现：点击纸片弹出时间选择器*/
            )
        }

        /*事件地点*/
        item{
            ListItem(
                leadingContent = { Icon( Icons.Default.LocationOn, "The info of the Task") },
                headlineText = {
                    TextField(
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValue = it
                        },
                        label = {
                            Text(text = "事件地点")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        ),
                        shape = TextFieldDefaults.outlinedShape
                    )
                }
            )
        }

        /*事件关联者-老师*/
        item{
            ListItem(
                leadingContent = { Icon( Icons.Default.Person, "The info of the Task") },
                headlineText = {
                    TextField(
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValue = it
                        },
                        label = {
                            Text(text = "授课教师")
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        ),
                        shape = TextFieldDefaults.outlinedShape
                    )
                }
            )
        }

    }

    if (isOpenDatePicker.value){
        DatePickerDialog(
            onDismissRequest = { isOpenDatePicker.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        isOpenDatePicker.value = false
                    },

                ) {
                    Text("确认")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = { isOpenDatePicker.value = false }
                ) {
                    Text("取消")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if (isOpenTimePicker.value){
        DatePickerDialog(
            onDismissRequest = { isOpenTimePicker.value = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        isOpenTimePicker.value = false
                    },
                ) {
                    Text("确认")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { isOpenTimePicker.value = false }
                ) {
                    Text("取消")
                }
            }
        ) {
            Box(
                Modifier.fillMaxWidth().padding(20.dp),
                contentAlignment = Alignment.Center
            ){
                TimePicker(state = TimePickerState)
            }
        }
    }
}
