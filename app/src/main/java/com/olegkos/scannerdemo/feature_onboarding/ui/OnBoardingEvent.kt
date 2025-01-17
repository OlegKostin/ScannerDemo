package com.olegkos.scannerdemo.feature_onboarding.ui

sealed class OnBoardingEvent {
  data object UpdateFirstTime : OnBoardingEvent()
}