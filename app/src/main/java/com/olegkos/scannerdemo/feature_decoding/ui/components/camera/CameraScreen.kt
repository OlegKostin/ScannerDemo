package com.olegkos.scannerdemo.feature_decoding.ui.components.camera

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.mlkit.vision.barcode.common.Barcode

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
  modifier: Modifier = Modifier, onBarcodeFound: (barcodes: List<Barcode>) -> Unit,
  onBarcodeNotFound: () -> Unit,
  onBarcodeFailed: (exception: Exception) -> Unit,
) {
  val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
  val lifecycleOwner = LocalLifecycleOwner.current
  DisposableEffect(lifecycleOwner) {

    val observer = LifecycleEventObserver { _, event ->
      if (event == Lifecycle.Event.ON_START) {
        cameraPermissionState.launchPermissionRequest()
      }
    }

    // Add the observer to the lifecycle
    lifecycleOwner.lifecycle.addObserver(observer)

    // When the effect leaves the Composition, remove the observer
    onDispose {
      lifecycleOwner.lifecycle.removeObserver(observer)
    }
  }



  when {
    cameraPermissionState.status.isGranted -> {
      CameraContent(
        modifier = modifier,
        onBarcodeFound = onBarcodeFound,
        onBarcodeNotFound = onBarcodeNotFound,
        onBarcodeFailed = onBarcodeFailed
      )
    }

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




















