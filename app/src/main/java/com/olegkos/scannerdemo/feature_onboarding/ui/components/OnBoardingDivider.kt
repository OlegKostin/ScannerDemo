package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.core.util.DIVIDER_HEIGHT

@Composable
fun OnBoardingDivider(modifier: Modifier = Modifier) {
  HorizontalDivider(
    modifier = modifier
      .fillMaxWidth()
      .height(DIVIDER_HEIGHT)
  )
}