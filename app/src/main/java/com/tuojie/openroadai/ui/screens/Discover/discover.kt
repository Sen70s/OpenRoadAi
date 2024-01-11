@file:OptIn(ExperimentalMaterial3Api::class)

package com.tuojie.openroadai.ui.screens.Discover

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tuojie.openroadai.model.entity.DiscoverScreenData.PostInformation
import com.tuojie.openroadai.viewmodel.DiscoverScreenViewModel

@Composable
fun DiscoverScreen(
    innerPadding: PaddingValues,
    vm: DiscoverScreenViewModel = viewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            FilterChip(
                selected = true,
                onClick = { },
                colors = FilterChipDefaults.filterChipColors(MaterialTheme.colorScheme.onError),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Warning,
                        "Warning",
                        tint = MaterialTheme.colorScheme.error
                    )
                },
                label = { Text("禁止发布任何违反国家法律法规的内容！") },
            )
        }

        vm.discoverPostList.forEachIndexed { index, infoitem ->
            item {
                PostCard(infoitem)
            }
        }
    }
}


@Composable
fun DiscoverScreenTopBar(onNavigateToPostEdit:() -> Unit = {},){
    TopAppBar(
        title = {
            Text(
                "发现",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(end = 10.dp)
            )
        },
        actions = {
            IconButton(onClick = { onNavigateToPostEdit.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = "发帖"
                )
            }
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
fun PostCard(info: PostInformation) {
    Surface(
        Modifier
            .shadow(5.dp, RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(Modifier.padding(20.dp)) {

            /*
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
                    )
                }
                item {
                    Image(
                        painterResource(R.mipmap.iamge_success),"LOGO",
                        Modifier
                            .fillMaxSize()
                    )
                }
                item {
                    Image(
                        painterResource(R.mipmap.icon_logo),"LOGO",
                        Modifier
                            .fillMaxSize()
                    )
                }
            }*/

            /*顶部 发帖人信息*/
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = info.posterAvatar, "Avatar",
                        Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(Color.Transparent)
                    )
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            info.postername,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(info.postTime, style = MaterialTheme.typography.bodySmall)
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Outlined.MoreVert, "More")
                }
            }

            /*中部内容 - 文本 and 话题标签*/
            Column(Modifier.padding(vertical = 10.dp)) {
                Text(
                    info.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    info.content,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 10,
                    overflow = TextOverflow.Ellipsis
                )
            }

            /*底部 - 操作按钮*/
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilterChip(
                    selected = true,
                    onClick = { },
                    leadingIcon = { Icon(Icons.Filled.Tag, "TAG") },
                    label = { Text(info.tag) },
                )

                Row {

                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Outlined.Comment,
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Outlined.ThumbUp,
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }

        }
    }

}
