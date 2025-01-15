package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout.HorizontalPagerLayout
import com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout.VerticalLayout
import com.olegkos.scannerdemo.feature_onboarding.util.PAGES_COUNT


@Composable
fun OnBoardingScreen(
  modifier: Modifier ,
  windowSizeClass: WindowWidthSizeClass,
  pagerState: PagerState = rememberPagerState(pageCount = {
    PAGES_COUNT
  })
) {
  val scrollingType = when (windowSizeClass) {
    WindowWidthSizeClass.Compact -> {
      OnBoardingScrollingType.BOTTOM_NAVIGATION
    }

    WindowWidthSizeClass.Medium -> {
      OnBoardingScrollingType.NO_BOTTOM_NAVIGATION
    }

    WindowWidthSizeClass.Expanded -> {
      OnBoardingScrollingType.NO_BOTTOM_NAVIGATION
    }

    else -> {
      OnBoardingScrollingType.BOTTOM_NAVIGATION
    }
  }
  if (scrollingType == OnBoardingScrollingType.BOTTOM_NAVIGATION)
    HorizontalPagerLayout(
      modifier = modifier,
      pagerState = pagerState,
      scrollType = scrollingType

    )
  else
    VerticalLayout(
      modifier = modifier,
      scrollType = scrollingType
    )

}
