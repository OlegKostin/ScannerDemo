package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.olegkos.scannerdemo.core.util.CORNER_SHAPE
import com.olegkos.scannerdemo.core.util.TONAL_ELEVATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeModalBottomSheet(modifier: Modifier = Modifier, onDismissRequest: () -> Unit) {
  ModalBottomSheet(
    onDismissRequest = onDismissRequest,
    shape = RoundedCornerShape(topStart = CORNER_SHAPE, topEnd = CORNER_SHAPE),
    containerColor = Color.Transparent,
    tonalElevation = TONAL_ELEVATION,
    dragHandle = {
      BottomHomeDragHandler()
    }) {
    HomeBottomSheetContent()
  }

}