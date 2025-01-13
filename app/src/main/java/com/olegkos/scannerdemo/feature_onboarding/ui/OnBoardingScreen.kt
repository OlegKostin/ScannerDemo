package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.core.ui.components.NormalButton

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
  Column (modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center)
  {
    NormalButton(
      onClick = {}
    ) {
      Text(text = "onboardingScreen Screen")
    }
  }
}