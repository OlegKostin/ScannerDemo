package com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.olegkos.scannerdemo.core.utils.DOT_SIZE

@Composable
fun Dot(modifier: Modifier = Modifier, selected: Boolean) {
  val color =
    if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer

  Box(
    modifier = modifier
      .size(DOT_SIZE)
      .clip(CircleShape)
      .background(color = color)
  )
}