package com.olegkos.scannerdemo.feature_onboarding.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager
  @Inject constructor(private val sharedPreferences: SharedPreferences) : SharedPreferenceManagement {
  override val editor: SharedPreferences.Editor
    get() = sharedPreferences.edit()

  override fun updateFirstTime(isFirstTime: Boolean) {
    editor.putBoolean(KEY_IS_FIRST_TIME, isFirstTime)
    editor.apply()
  }

  override fun getIsFirstTime(): Boolean {
    return sharedPreferences.getBoolean(KEY_IS_FIRST_TIME, true)
  }

  companion object{

    const val KEY_IS_FIRST_TIME = "is_first_time"
    const val SHARED_PREFERENCE_NAME = "shared_preference_name"
  }
}