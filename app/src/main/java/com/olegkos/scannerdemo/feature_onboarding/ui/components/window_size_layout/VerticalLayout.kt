package com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_onboarding.ui.OnBoardingScrollingType
import com.olegkos.scannerdemo.feature_onboarding.ui.components.OnBoardingContent
import com.olegkos.scannerdemo.feature_onboarding.ui.components.OnBoardingDivider
import com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator.GetStartedButton
import com.olegkos.scannerdemo.feature_onboarding.util.FIRST_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.SECOND_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE

@Composable
fun VerticalLayout(modifier: Modifier , scrollType: OnBoardingScrollingType) {
  Column(
    modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {
    OnBoardingContent(
      modifier = modifier,
      imageResId = R.drawable.onboarding_image_one,
      headerContent = R.string.select_a_brand,
      descContent = R.string.onboarding_select_brand_image,
      subtitleContent = R.string.onboarding_message_one,
      selectedPage = FIRST_INDEX_PAGE,
      scrollingType = scrollType,
    )

    OnBoardingDivider()

    OnBoardingContent(
      modifier = modifier,
      imageResId = R.drawable.onboarding_image_two,
      descContent = R.string.onboarding_select_brand_image,
      headerContent = R.string.onboarding_insert_serial_number_image,
      subtitleContent = R.string.onboarding_message_two,
      selectedPage = SECOND_INDEX_PAGE,
      scrollingType = scrollType,
      )

    OnBoardingDivider()

    OnBoardingContent(
      modifier = modifier,
      imageResId = R.drawable.onboarding_image_three,
      descContent = R.string.onboarding_insert_serial_number_image,
      headerContent = R.string.onboarding_view_details_about_device_image,
      subtitleContent = R.string.onboarding_message_three,
      selectedPage = THIRD_INDEX_PAGE,
      scrollingType = scrollType,
    )
    GetStartedButton()
  }
}