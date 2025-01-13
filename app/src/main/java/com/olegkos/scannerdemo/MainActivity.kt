package com.olegkos.scannerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.olegkos.scannerdemo.ui.theme.ScannerDemoTheme
import com.olegkos.serialdecoder.core.nav.NavigationHost

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ScannerScreen()
    }
  }
}

@Composable
fun ScannerScreen(modifier: Modifier = Modifier) {
  ScannerDemoTheme {
    NavigationHost(modifier = modifier)
  }

}
