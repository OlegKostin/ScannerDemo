package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.olegkos.scannerdemo.core.utils.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.utils.ONBOARDING_IMAGE_SIZE
import com.olegkos.scannerdemo.core.utils.ONBOARDING_IMAGE_SPACING

@Composable
fun OnBoardingContent(
  modifier: Modifier = Modifier.fillMaxWidth(),
  @DrawableRes imageResId: Int,
  @StringRes descContent: Int,
  @StringRes headerContent: Int,
  imageSize: Dp = ONBOARDING_IMAGE_SIZE,
  @StringRes subtitleContent: Int,
) {
  Column(
    modifier = Modifier
      .padding(top = ONBOARDING_IMAGE_SPACING)
      .padding(FOUR_TIMES_SPACING)
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    OnBoardingImage(
      imageResId = imageResId,
      contentDesResId = descContent,
      size = imageSize
    )
    OnBoardingHeader(headerId = headerContent)
    OnBoardingSubTitle(
      subtitleId = subtitleContent
    )
    DotsIndicator()
  }
}