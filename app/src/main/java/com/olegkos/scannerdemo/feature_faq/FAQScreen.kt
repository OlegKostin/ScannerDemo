package com.olegkos.scannerdemo.feature_faq

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.feature_faq.ui.components.BottomButtons
import com.olegkos.scannerdemo.feature_faq.ui.components.FAQContent
import com.olegkos.scannerdemo.feature_faq.ui.components.TopFAQBar

@Composable
fun FAQScreen(modifier: Modifier = Modifier) {
  Scaffold(
    topBar = { TopFAQBar() },
    bottomBar = { BottomButtons() }
  ) { paddingValue ->
    Column(
      modifier = modifier
        .fillMaxSize()
        .padding(paddingValue)
    ) {
      FAQContent()
    }
  }
}