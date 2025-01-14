package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_onboarding.ui.components.OnBoardingContent
import com.olegkos.scannerdemo.feature_onboarding.util.FIRST_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.PAGES_COUNT
import com.olegkos.scannerdemo.feature_onboarding.util.SECOND_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE
import com.olegkos.scannerdemo.ui.theme.ScannerDemoTheme


@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
  val pagerState = rememberPagerState(pageCount = {
    PAGES_COUNT
  })
  HorizontalPager(
    state = pagerState,
    modifier = Modifier.fillMaxSize()
  ) { page ->
    when (page) {
      FIRST_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_one,
          headerContent = R.string.select_a_brand,
          descContent = R.string.onboarding_select_brand_image,
          subtitleContent = R.string.onboarding_message_one,
          selectedPage = FIRST_INDEX_PAGE,
        )
      }

      SECOND_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_two,
          descContent = R.string.onboarding_select_brand_image,
          headerContent = R.string.onboarding_insert_serial_number_image,
          subtitleContent = R.string.onboarding_message_two,
          selectedPage = SECOND_INDEX_PAGE,
        )
      }

      THIRD_INDEX_PAGE -> {
        OnBoardingContent(
          imageResId = R.drawable.onboarding_image_three,
          descContent = R.string.onboarding_insert_serial_number_image,

          headerContent = R.string.onboarding_view_details_about_device_image,
          subtitleContent = R.string.onboarding_message_three,
          selectedPage = THIRD_INDEX_PAGE,
        )
      }
    }
  }
}
