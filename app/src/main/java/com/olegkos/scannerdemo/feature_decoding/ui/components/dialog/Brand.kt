package com.olegkos.scannerdemo.feature_decoding.ui.components.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.core.ui.components.NormalButton
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING
import com.olegkos.scannerdemo.core.util.TRIPLE_SPACING

@Composable
fun Brand(
  modifier: Modifier = Modifier,
  brandName: String, onBrandClicked: () -> Unit
) {
  NormalButton(
    modifier = modifier.padding(TRIPLE_SPACING).padding(bottom = NORMAL_SPACING).fillMaxWidth(),
    onClick = onBrandClicked
  ) {
    Text(text = brandName)
  }
}