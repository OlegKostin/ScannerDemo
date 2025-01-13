package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.ui.components.NormalButton
import com.olegkos.scannerdemo.feature_onboarding.ui.components.OnBoardingContent
import com.olegkos.scannerdemo.feature_onboarding.util.FIRST_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.SECOND_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE


@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
  val pagerState = rememberPagerState(pageCount = {
    3
  })
  HorizontalPager(
    state = pagerState,
    modifier = Modifier.fillMaxSize()
  ) { page ->
    when (page) {
      FIRST_INDEX_PAGE -> {
        OnBoardingContent(text = "1")

      }

      SECOND_INDEX_PAGE -> {
        OnBoardingContent(text = "2")

      }

      THIRD_INDEX_PAGE -> {
        OnBoardingContent(text = "3")

      }


    }

  }
}