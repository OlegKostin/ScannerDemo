package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera.EmptyBox

@Composable
fun HomeBottomSheetContent(modifier: Modifier = Modifier) {

  Column (modifier = modifier) {
    SerialScanText()
    EmptyBox()
  }
}