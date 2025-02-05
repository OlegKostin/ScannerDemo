package com.olegkos.scannerdemo.feature_onboarding.data.local

interface SharedPreferenceManagement {
  fun updateFirstTime(isFirstTime: Boolean)
  fun getIsFirstTime(): Boolean
}