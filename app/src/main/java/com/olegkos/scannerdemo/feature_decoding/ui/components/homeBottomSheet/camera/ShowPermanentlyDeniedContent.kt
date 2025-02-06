package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.olegkos.scannerdemo.R

@Composable
fun ShowPermanentlyDeniedContent(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .fillMaxSize(),
    contentAlignment = Alignment.Center
  )
  {
    Text(
      text = stringResource(
        R.string.x_permission_is_denied,
        stringResource(R.string.camera)
      ), style = MaterialTheme.typography.displayMedium,
      textAlign = TextAlign.Center
    )
  }
}

