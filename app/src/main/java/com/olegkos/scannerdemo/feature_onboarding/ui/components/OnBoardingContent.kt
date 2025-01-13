package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OnBoardingContent(
  modifier: Modifier = Modifier.fillMaxWidth(),
  text :String
) {
Text(text = "page is $text")
}