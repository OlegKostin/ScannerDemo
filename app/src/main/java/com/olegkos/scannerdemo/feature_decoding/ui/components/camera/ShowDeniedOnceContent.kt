package com.olegkos.scannerdemo.feature_decoding.ui.components.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ShowDeniedOnceContent(
  modifier: Modifier = Modifier,
  permissionState: PermissionState
) {
  Column(
    modifier = modifier
      .background(MaterialTheme.colorScheme.surface)
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      modifier = Modifier
        .padding(NORMAL_SPACING)
        .fillMaxHeight(0.2f),
      text = stringResource(R.string.permission_is_required_for_scanning_qr),
      style = MaterialTheme.typography.displayLarge
    )
    PermissionRequestButton(
      modifier = modifier,
      permissionState = permissionState
    )
  }
}