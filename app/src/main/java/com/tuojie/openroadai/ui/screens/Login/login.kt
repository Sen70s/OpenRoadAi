@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tuojie.openroadai.R

@Composable
fun LoginView(navController: NavController) {
    var text by remember {mutableStateOf("")}
    var accounttext by remember{ mutableStateOf("")}
    var passwordtext by remember{mutableStateOf("")}
    var passwordHidden by remember{ mutableStateOf(false)}

    LazyColumn(
        Modifier.fillMaxWidth().fillMaxHeight().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        item{
            Image(
                painter = painterResource(R.mipmap.icon_logo),
                contentDescription = "background",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        item{
            Surface(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxSize(),
            ){
                Column (
                    Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 50.dp, 30.dp, 50.dp),
                ){
                    Column (
                        Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Column (
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text(
                                "Team Up!",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                "Time To Play!",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }

                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = accounttext,
                            onValueChange = {
                                accounttext = it
                            },
                            singleLine = true,
                            label = {
                                Text("拓界ID")
                            }
                        )

                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = passwordtext,
                            onValueChange = {
                                passwordtext = it
                            },
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordHidden = !passwordHidden
                                    }
                                ){
                                    Icon(Icons.Filled.CheckCircle, null)
                                }
                            },
                            label = {
                                Text("密码")
                            },
                            visualTransformation = if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None
                        )

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            ElevatedAssistChip(
                                enabled = true,
                                onClick = { },
                                label = { Text(
                                    text = "申请许可",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                ) }
                            )

                            ElevatedAssistChip(
                                enabled = true,
                                onClick = { },
                                label = { Text(
                                    text = "忘记密码",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                ) }
                            )
                        }


                        Row(modifier = Modifier.fillMaxWidth()){
                            RadioButton(
                                selected = (text == "11"),
                                onClick = null // null recommended for accessibility with screenreaders
                            )
                            Text(
                                text = "登录即同意《用户协议》与《隐私协议》",
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ){
                            FloatingActionButton(
                                onClick = {  },
                                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                            ) {
                                Icon(Icons.Filled.Send,"AiLogo",tint = Color.Unspecified, modifier = Modifier.width(46.dp))
                            }
                        }
                    }



                }
            }
        }
    }
}

