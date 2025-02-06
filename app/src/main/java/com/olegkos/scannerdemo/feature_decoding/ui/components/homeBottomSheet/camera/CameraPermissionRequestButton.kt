package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@Composable
fun PermissionRequestButton(
  modifier: Modifier = Modifier,

) {
  Button(
    modifier = modifier
      .padding(NORMAL_SPACING)
      .fillMaxWidth(),
    onClick = {

    }) {
    Text(
      stringResource(
        id = R.string.request_x_permission,
        stringResource(id = R.string.camera)
      )
    )
  }
}