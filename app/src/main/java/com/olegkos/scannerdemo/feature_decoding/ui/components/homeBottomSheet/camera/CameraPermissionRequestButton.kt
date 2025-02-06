package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionRequestButton(
  modifier: Modifier = Modifier,
  permissionState: PermissionState
) {
  Button(
    modifier = modifier
      .padding(NORMAL_SPACING)
      .fillMaxWidth(),
    onClick = {
      permissionState.launchPermissionRequest()
    }) {
    Text(
      stringResource(
        id = R.string.request_x_permission
      )
    )

  }
}