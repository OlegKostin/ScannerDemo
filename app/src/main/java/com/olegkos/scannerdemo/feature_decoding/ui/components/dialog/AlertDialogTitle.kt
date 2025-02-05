package com.olegkos.scannerdemo.feature_decoding.ui.components.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun AlertDialogTitle(modifier: Modifier = Modifier, title: String) {
  Box(
    modifier = Modifier
      .fillMaxWidth(),
    contentAlignment = Alignment.Center
  ) {
    Text(
      modifier = modifier,
      text = title,
      style = MaterialTheme.typography.displayMedium
    )
  }
}