package com.olegkos.serialdecoder.core.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.OnBoarding
    ){
        composable<Route.OnBoarding> {

        }
        composable<Route.FAQ> {

        }
        composable<Route.Home> {

        }
    }
    
}