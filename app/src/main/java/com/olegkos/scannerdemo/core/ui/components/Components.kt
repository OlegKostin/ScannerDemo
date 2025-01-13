package com.olegkos.scannerdemo.core.ui.components

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NormalButton(
  modifier: Modifier = Modifier,
  enabled: Boolean = true,
  onClick: () -> Unit,
  content: @Composable () -> Unit
) {
  Button(
    modifier = modifier,
    enabled = enabled,
    onClick = onClick
  ) {
    content()
  }
}