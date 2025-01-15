package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.utils.DOUBLE_SPACING
import com.olegkos.scannerdemo.core.utils.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.utils.NORMAL_SPACING
import com.olegkos.scannerdemo.core.utils.ONBOARDING_IMAGE_SIZE
import com.olegkos.scannerdemo.core.utils.ONBOARDING_IMAGE_SPACING
import com.olegkos.scannerdemo.feature_onboarding.ui.OnBoardingScrollingType
import com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator.GetStartedButton
import com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator.NavigationDotIndicator
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE
import com.olegkos.scannerdemo.ui.theme.ScannerDemoTheme

@Composable
fun OnBoardingContent(
  modifier: Modifier = Modifier,
  @DrawableRes imageResId: Int,
  @StringRes descContent: Int,
  @StringRes headerContent: Int,
  imageSize: Dp = ONBOARDING_IMAGE_SIZE,
  @StringRes subtitleContent: Int,
  selectedPage: Int,
  scrollingType: OnBoardingScrollingType,
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
          GetStartedButton()
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
        Column(modifier = modifier.fillMaxWidth(),
          horizontalAlignment =  Alignment.CenterHorizontally) {
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

@Preview
@Composable
private fun OnBoardingContentPreview() {
  ScannerDemoTheme {
    OnBoardingContent(
      modifier = Modifier.fillMaxSize(),
      imageResId = R.drawable.onboarding_image_one,
      headerContent = R.string.select_a_brand,
      descContent = R.string.onboarding_select_brand_image,
      subtitleContent = R.string.onboarding_message_one,
      selectedPage = 1,
      scrollingType = OnBoardingScrollingType.BOTTOM_NAVIGATION
    )

  }


}