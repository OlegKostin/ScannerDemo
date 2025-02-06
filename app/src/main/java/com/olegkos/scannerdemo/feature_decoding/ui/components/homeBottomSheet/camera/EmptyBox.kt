package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmptyBox(modifier: Modifier = Modifier) {
  Box(modifier = modifier.background(color = MaterialTheme.colorScheme.secondaryContainer).fillMaxWidth().fillMaxHeight(0.8f))
}