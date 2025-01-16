package com.olegkos.scannerdemo.feature_onboarding.data.local

import android.content.SharedPreferences

interface SharedPreferenceManagement {
  val editor: SharedPreferences.Editor
  fun updateFirstTime(isFirstTime: Boolean)
  fun getIsFirstTime(): Boolean
}