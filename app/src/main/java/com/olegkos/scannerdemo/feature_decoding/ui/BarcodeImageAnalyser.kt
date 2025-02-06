package com.olegkos.scannerdemo.feature_decoding.ui

import android.os.Handler
import android.os.Looper
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class BarcodeImageAnalyser(
  val onBarcodeFound: (barcodes: List<Barcode>) -> Unit,
  val onBarcodeNotFound: () -> Unit,
  val onBarcodeFailed: (exception: Exception) -> Unit,
) : ImageAnalysis.Analyzer {

  private val handler = Handler(Looper.getMainLooper())
  private var isProcessing = false

  @OptIn(ExperimentalGetImage::class)
  override fun analyze(imageProxy: ImageProxy) {
    if (isProcessing) {
      imageProxy.close()
      return
    }

    isProcessing = true


    val mediaImage = imageProxy.image
    if (mediaImage != null) {
      val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
      val options = buildBarcodeScannerOptions()
      val scanner = BarcodeScanning.getClient(options)

      val result = scanner.process(image)
        .addOnSuccessListener { barcodes ->
          if (barcodes.isNotEmpty())
            onBarcodeFound(barcodes)
          else
            onBarcodeNotFound()
        }
        .addOnFailureListener { exception ->
          onBarcodeFailed(exception)
        }.addOnCompleteListener {
          imageProxy.close()
          handler.postDelayed({
            isProcessing = false
          }, 700)
        }

    }


  }

  private fun buildBarcodeScannerOptions(): BarcodeScannerOptions {
    return BarcodeScannerOptions.Builder()
      .setBarcodeFormats(
        Barcode.FORMAT_QR_CODE,
      )
      .build()

  }
}