package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun BottomHomeDragHandler(modifier: Modifier = Modifier) {

  Box(
    modifier = Modifier
      .fillMaxWidth(0.2f)
      .height(8.dp)
      .clip(RoundedCornerShape(50))
      .background(MaterialTheme.colorScheme.primary)

  ) {

  }

}