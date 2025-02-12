package com.olegkos.scannerdemo.feature_decoding.ui.components.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
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
import com.google.mlkit.vision.barcode.common.Barcode
import com.olegkos.scannerdemo.feature_decoding.ui.analyser.BarcodeImageAnalyser
import java.util.concurrent.Executors

@Composable
fun CameraContent(
  modifier: Modifier = Modifier,
  onBarcodeFound: (barcodes: List<Barcode>) -> Unit,
  onBarcodeNotFound: () -> Unit,
  onBarcodeFailed: (exception: Exception) -> Unit,
) {
  val context = LocalContext.current
  val lifeCycleOwner = LocalLifecycleOwner.current
  AndroidView(modifier = modifier.fillMaxSize(), factory = { context ->
    val previewView: PreviewView = PreviewView(context)
    previewView.implementationMode = PreviewView.ImplementationMode.COMPATIBLE
    previewView
  },
    update = { previewView ->
      val cameraProviderFuture = ProcessCameraProvider.getInstance(context = context)
      val cameraExecutor = Executors.newSingleThreadExecutor()
      val barcodeImageAnalyser = BarcodeImageAnalyser(
        onBarcodeFound = { barcodes ->
          onBarcodeFound(barcodes)
        },
        onBarcodeNotFound = {
          onBarcodeNotFound()
        },
        onBarcodeFailed = { exception ->
          onBarcodeFailed(exception)
        }
      )
      cameraProviderFuture.addListener(Runnable {
        // Camera provider is now guaranteed to be available
        val cameraProvider = cameraProviderFuture.get()

        // Set up the preview use case to display camera preview.
        val previewUseCase = Preview.Builder().build()

        val imageAnalysisUseCase = ImageAnalysis.Builder()
          .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
          .build()
        imageAnalysisUseCase.setAnalyzer(
          cameraExecutor,
          barcodeImageAnalyser
        )

        // Choose the camera by requiring a lens facing
        val cameraSelector = CameraSelector.Builder()
          .requireLensFacing(CameraSelector.LENS_FACING_BACK)
          .build()

        cameraProvider.unbindAll()
        // Attach use cases to the camera with the same lifecycle owner
        val camera = cameraProvider.bindToLifecycle(
          lifeCycleOwner, cameraSelector, previewUseCase, imageAnalysisUseCase
        )

        // Connect the preview use case to the previewView
        previewUseCase.surfaceProvider = previewView.surfaceProvider
      }, ContextCompat.getMainExecutor(context))

    })
}