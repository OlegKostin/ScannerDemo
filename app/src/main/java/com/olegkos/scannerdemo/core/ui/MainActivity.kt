package com.olegkos.scannerdemo.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import com.olegkos.scannerdemo.ui.theme.ScannerDemoTheme
import com.olegkos.scannerdemo.core.nav.NavigationHost


class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val windowSizeClass = calculateWindowSizeClass(this)
      ScannerScreen(widthSizeClass = windowSizeClass.widthSizeClass)
    }
  }
}

@Composable
fun ScannerScreen(
  modifier: Modifier  = Modifier, widthSizeClass: WindowWidthSizeClass,

  ){
  ScannerDemoTheme {
    NavigationHost(modifier = modifier,
      windowSizeClass = widthSizeClass
      )
  }

}
