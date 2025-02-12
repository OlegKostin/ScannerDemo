package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.mlkit.vision.barcode.common.Barcode
import com.olegkos.scannerdemo.core.util.CORNER_SHAPE
import com.olegkos.scannerdemo.core.util.TONAL_ELEVATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeModalBottomSheet(
  modifier: Modifier = Modifier, sheetState: SheetState, onDismissRequest: () -> Unit,
  onBarcodeFound: (barcodes: List<Barcode>) -> Unit,
  onBarcodeNotFound: () -> Unit,
  onBarcodeFailed: (exception: Exception) -> Unit,
) {
  ModalBottomSheet(

    onDismissRequest = onDismissRequest,
    sheetState = sheetState,
    shape = RoundedCornerShape(topStart = CORNER_SHAPE, topEnd = CORNER_SHAPE),
    containerColor = Color.Transparent,
    tonalElevation = TONAL_ELEVATION,
    dragHandle = {
      BottomHomeDragHandler()
    }) {
    HomeBottomSheetContent(
      modifier = modifier,
      onBarcodeFound = onBarcodeFound,
      onBarcodeNotFound = onBarcodeNotFound,
      onBarcodeFailed = onBarcodeFailed
    )
  }

}