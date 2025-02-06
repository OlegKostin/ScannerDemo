package com.olegkos.scannerdemo.feature_decoding.ui.components.camera

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(modifier: Modifier = Modifier) {
  val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
  LaunchedEffect(key1 = true) {
    cameraPermissionState.launchPermissionRequest()
  }
  when {
    cameraPermissionState.status.isGranted -> {
      CameraContent() }
    cameraPermissionState.status.shouldShowRationale -> {
      ShowDeniedOnceContent(
        permissionState = cameraPermissionState
      )
    }
    else -> {
      ShowPermanentlyDeniedContent()
    }
  }
}




















