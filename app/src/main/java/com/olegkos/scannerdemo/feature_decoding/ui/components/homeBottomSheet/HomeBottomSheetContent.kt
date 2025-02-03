package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeBottomSheetContent(modifier: Modifier = Modifier) {

  Column {
    SerialScanText()
    CameraBox()
  }
}