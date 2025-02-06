package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R

@Composable
fun ShowDeniedOnceContent(modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = stringResource(R.string.x_permission_is_required_for_scanning_qr, R.string.camera),
      style = MaterialTheme.typography.displayMedium)

  }
}