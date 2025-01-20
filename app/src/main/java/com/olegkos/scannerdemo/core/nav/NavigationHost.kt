package com.olegkos.scannerdemo.core.nav

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olegkos.scannerdemo.feature_decoding.ui.HomeScreen
import com.olegkos.scannerdemo.feature_faq.FAQScreen
import com.olegkos.scannerdemo.feature_onboarding.ui.OnBoardingScreen


@Composable
fun NavigationHost(modifier: Modifier, windowSizeClass: WindowWidthSizeClass) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Route.OnBoarding,
    modifier = modifier
  ) {
    composable<Route.OnBoarding> {
      OnBoardingScreen(modifier, windowSizeClass = windowSizeClass,
        onHomeNavigation = {
          navController.navigate(Route.Home) {
            popUpTo(Route.OnBoarding) {
              inclusive = true
            }
          }

        })
    }
    composable<Route.FAQ> {
      FAQScreen()
    }
    composable<Route.Home> {
      HomeScreen()
    }
  }

}