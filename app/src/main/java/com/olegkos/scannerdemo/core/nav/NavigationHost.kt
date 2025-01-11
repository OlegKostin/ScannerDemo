package com.olegkos.serialdecoder.core.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olegkos.serialdecoder.decoding.ui.HomeScreen
import com.olegkos.serialdecoder.faq.ui.FAQScreen
import com.olegkos.serialdecoder.onboarding.ui.OnBoardingScreen

@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.OnBoarding
    ){
        composable<Route.OnBoarding> {
            OnBoardingScreen(

            )
        }
        composable<Route.FAQ> {
            FAQScreen(

            )
        }
        composable<Route.Home> {
            HomeScreen(

            )
        }
    }
    
}