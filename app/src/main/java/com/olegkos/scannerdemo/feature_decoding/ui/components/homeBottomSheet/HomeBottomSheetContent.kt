package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.mlkit.vision.barcode.common.Barcode
import com.olegkos.scannerdemo.feature_decoding.ui.components.camera.CameraScreen

@Composable
fun HomeBottomSheetContent(
  modifier: Modifier = Modifier, onBarcodeFound: (barcodes: List<Barcode>) -> Unit,
  onBarcodeNotFound: () -> Unit,
  onBarcodeFailed: (exception: Exception) -> Unit,
) {

  Column(modifier = modifier) {
    SerialScanText()

    CameraScreen(
      modifier = modifier,
      onBarcodeFound = onBarcodeFound,
      onBarcodeNotFound = onBarcodeNotFound,
      onBarcodeFailed = onBarcodeFailed
    )

  }
}