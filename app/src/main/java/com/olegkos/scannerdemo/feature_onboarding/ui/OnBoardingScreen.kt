package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
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

  val uiState: State<OnBoardingState> = viewModel.uiState.collectAsState()


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
  val canClickGetStarted : Boolean = uiState.value.isLoading == false
  if (scrollingType == OnBoardingScrollingType.BOTTOM_NAVIGATION)
    HorizontalPagerLayout(
      modifier = modifier,
      pagerState = pagerState,
      scrollType = scrollingType,
      canBeClickedGetStartedButton =canClickGetStarted,
      onGetStartedButtonClicked = {viewModel.updateFirstTime()},
    )
  else
    VerticalLayout(
      modifier = modifier,
      scrollType = scrollingType,
      canBeClickedGetStarted = canClickGetStarted,
      onGetStartedButtonClicked = { viewModel.updateFirstTime() },
    )

}
