package com.tuojie.openroadai.uiframe.menus_actions

import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun QButtons(
    type: String,
    text: String,
    qmodifier: Modifier,
){
    //Elevated, filled, filled tonal, outlined, and text buttons
    when(type){
        "plain" -> {
            TextButton(onClick = { }, modifier = qmodifier) { Text(text) }
        }
        "tinted" -> {
            FilledTonalButton(onClick = { }, modifier = qmodifier) { Text(text) }
        }
        "filled" -> {
            Button(onClick = {}, modifier = qmodifier) { Text(text) }
        }
    }
}
