package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun CameraBox(modifier: Modifier = Modifier) {
  val context = LocalContext.current
  val lifeCycleOwner = LocalLifecycleOwner.current
  AndroidView(modifier = modifier.fillMaxSize(), factory = { context ->
    val previewView: PreviewView = PreviewView(context)
    previewView.implementationMode = PreviewView.ImplementationMode.COMPATIBLE
    previewView
  },
    update = { previewView ->
      val cameraProviderFuture = ProcessCameraProvider.getInstance(context = context)

      cameraProviderFuture.addListener(Runnable {
        // Camera provider is now guaranteed to be available
        val cameraProvider = cameraProviderFuture.get()

        // Set up the preview use case to display camera preview.
        val previewUseCase = Preview.Builder().build()

        val imageAnalysisUseCase = null

        // Choose the camera by requiring a lens facing
        val cameraSelector = CameraSelector.Builder()
          .requireLensFacing(CameraSelector.LENS_FACING_BACK)
          .build()

        // Attach use cases to the camera with the same lifecycle owner
        val camera = cameraProvider.bindToLifecycle(
          lifeCycleOwner, cameraSelector, previewUseCase, imageAnalysisUseCase
        )

        // Connect the preview use case to the previewView
        previewUseCase.surfaceProvider = previewView.surfaceProvider
      }, ContextCompat.getMainExecutor(context))

    })
}