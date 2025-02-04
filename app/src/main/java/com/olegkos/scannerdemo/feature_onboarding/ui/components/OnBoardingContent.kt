package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.core.util.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING
import com.olegkos.scannerdemo.core.util.ONBOARDING_IMAGE_SIZE
import com.olegkos.scannerdemo.core.util.ONBOARDING_IMAGE_SPACING
import com.olegkos.scannerdemo.feature_onboarding.ui.OnBoardingScrollingType
import com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator.GetStartedButton
import com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator.NavigationDotIndicator
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE

@Composable
fun OnBoardingContent(
  modifier: Modifier = Modifier,
  @DrawableRes imageResId: Int,
  @StringRes descContent: Int,
  @StringRes headerContent: Int,
  canBeClickedGetStartedButton: Boolean = false,
  imageSize: Dp = ONBOARDING_IMAGE_SIZE,
  @StringRes subtitleContent: Int,
  selectedPage: Int,
  scrollingType: OnBoardingScrollingType,
  onGetStartedButtonClicked: () -> Unit
) {
  when (scrollingType) {
    OnBoardingScrollingType.BOTTOM_NAVIGATION -> {
      Column(
        modifier = modifier
          .padding(
            top = ONBOARDING_IMAGE_SPACING,
            start = FOUR_TIMES_SPACING,
            end = FOUR_TIMES_SPACING,
            bottom = FOUR_TIMES_SPACING
          )
          .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        OnBoardingImage(
          imageResId = imageResId,
          contentDesResId = descContent,
          size = imageSize
        )
        OnBoardingHeader(
          modifier = modifier.padding(NORMAL_SPACING),
          headerId = headerContent
        )
        OnBoardingSubtitle(
          modifier = modifier.padding(DOUBLE_SPACING),
          subtitleId = subtitleContent
        )
        Spacer(modifier = Modifier.weight(1f))
        if (selectedPage == THIRD_INDEX_PAGE) {
          GetStartedButton(enabled = canBeClickedGetStartedButton,
            onGetStartedButtonClicked = {
              onGetStartedButtonClicked()
            })
        } else {
          NavigationDotIndicator(
            currentPage = selectedPage
          )
        }
      }
    }

    OnBoardingScrollingType.NO_BOTTOM_NAVIGATION -> {
      Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        OnBoardingImage(
          imageResId = imageResId,
          contentDesResId = descContent,
          size = imageSize
        )
        Column(
          modifier = modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          OnBoardingHeader(
            modifier = modifier.padding(NORMAL_SPACING),
            headerId = headerContent
          )
          OnBoardingSubtitle(
            modifier = modifier.padding(DOUBLE_SPACING),
            subtitleId = subtitleContent
          )
        }
      }
    }
  }
}

