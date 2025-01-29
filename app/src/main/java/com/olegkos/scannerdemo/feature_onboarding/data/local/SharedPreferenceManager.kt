package com.olegkos.scannerdemo.feature_onboarding.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager
  @Inject constructor(private val sharedPreferences: SharedPreferences) : SharedPreferenceManagement {


  override fun updateFirstTime(isFirstTime: Boolean) {
    sharedPreferences.edit().putBoolean(KEY_IS_FIRST_TIME, isFirstTime).apply()
  }

  override fun getIsFirstTime(): Boolean {
    return sharedPreferences.getBoolean(KEY_IS_FIRST_TIME, true)
  }

  companion object{

    const val KEY_IS_FIRST_TIME = "is_first_time"
    const val SHARED_PREFERENCE_NAME = "shared_preference_name"
  }
}