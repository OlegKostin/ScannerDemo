package com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_onboarding.ui.OnBoardingScrollingType
import com.olegkos.scannerdemo.feature_onboarding.ui.components.OnBoardingContent
import com.olegkos.scannerdemo.feature_onboarding.util.FIRST_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.SECOND_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE

@Composable
fun HorizontalPagerLayout(
  modifier: Modifier,
  pagerState: PagerState,
  scrollType: OnBoardingScrollingType,
  canBeClickedGetStartedButton: Boolean,
  onGetStartedButtonClicked: () -> Unit,
) {
  HorizontalPager(
    state = pagerState,
    modifier = modifier,
  ) { page ->
    when (page) {
      FIRST_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_one,
          headerContent = R.string.select_a_brand,
          descContent = R.string.onboarding_select_brand_image,
          subtitleContent = R.string.onboarding_message_one,
          selectedPage = FIRST_INDEX_PAGE,
          scrollingType = scrollType,
          onGetStartedButtonClicked = onGetStartedButtonClicked,
        )
      }

      SECOND_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_two,
          descContent = R.string.onboarding_select_brand_image,
          headerContent = R.string.onboarding_insert_serial_number_image,
          subtitleContent = R.string.onboarding_message_two,
          selectedPage = SECOND_INDEX_PAGE,
          scrollingType = scrollType,
          onGetStartedButtonClicked = onGetStartedButtonClicked,
        )
      }

      THIRD_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_three,
          descContent = R.string.onboarding_insert_serial_number_image,
          headerContent = R.string.onboarding_view_details_about_device_image,
          subtitleContent = R.string.onboarding_message_three,
          canBeClickedGetStartedButton = canBeClickedGetStartedButton,
          selectedPage = THIRD_INDEX_PAGE,
          scrollingType = scrollType,
          onGetStartedButtonClicked = onGetStartedButtonClicked,
        )
      }
    }
  }

}