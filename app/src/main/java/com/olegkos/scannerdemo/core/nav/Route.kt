package com.olegkos.scannerdemo.core.nav

import kotlinx.serialization.Serializable

sealed  interface Route {
    @Serializable
    data object OnBoarding : Route
    @Serializable
    data object Home : Route
    @Serializable
    data object FAQ : Route
}
