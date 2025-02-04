package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@Composable
fun SerialScanText(modifier: Modifier = Modifier) {
  Text(
    modifier = modifier.padding(start = DOUBLE_SPACING, bottom = NORMAL_SPACING),
    text = stringResource(R.string.scan_serial_with_qr),
    style = MaterialTheme.typography.displaySmall
  )
}