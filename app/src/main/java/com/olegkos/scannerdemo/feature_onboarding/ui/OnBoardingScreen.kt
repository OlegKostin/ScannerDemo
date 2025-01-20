package com.olegkos.scannerdemo.feature_onboarding.ui

import android.util.Log
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout.HorizontalPagerLayout
import com.olegkos.scannerdemo.feature_onboarding.ui.components.window_size_layout.VerticalLayout
import com.olegkos.scannerdemo.feature_onboarding.util.PAGES_COUNT
import kotlinx.coroutines.flow.collectLatest


@Composable
fun OnBoardingScreen(
  modifier: Modifier,
  windowSizeClass: WindowWidthSizeClass,
  pagerState: PagerState = rememberPagerState(pageCount = {
    PAGES_COUNT
  }),
  viewModel: OnBoardingViewModel = hiltViewModel(),
  onHomeNavigation: () -> Unit
) {

  LaunchedEffect(key1 = true) {
    viewModel.uiEvent.collectLatest { event ->
      when (event) {
        OnBoardingEvent.UpdateFirstTime -> {
          onHomeNavigation()
        }
      }
    }
  }
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
      scrollType = scrollingType,
      onGetStartedButtonClicked = {viewModel.updateFirstTime()},
    )
  else
    VerticalLayout(
      modifier = modifier,
      scrollType = scrollingType,
      onGetStartedButtonClicked = { viewModel.updateFirstTime() },
    )

}
