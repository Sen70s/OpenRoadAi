package com.tuojie.openroadai.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.tuojie.openroadai.viewmodel.MainActivityViewModel

val LocalMainActivityViewModel = compositionLocalOf<MainActivityViewModel> { error("MainActivity View Model Not Found") }