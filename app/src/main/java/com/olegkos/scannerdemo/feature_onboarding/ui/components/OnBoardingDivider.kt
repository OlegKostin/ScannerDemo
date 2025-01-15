package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.core.utils.DIVIDER_HEIGHT
import com.olegkos.scannerdemo.core.utils.NORMAL_SPACING

@Composable
fun OnBoardingDivider(modifier: Modifier = Modifier) {
  HorizontalDivider(
    modifier = modifier
      .fillMaxWidth()
      .height(DIVIDER_HEIGHT)
  )
}