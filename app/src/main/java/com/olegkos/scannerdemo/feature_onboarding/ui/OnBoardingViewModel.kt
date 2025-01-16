package com.olegkos.scannerdemo.feature_onboarding.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
  private val sharedPreferenceManagement: SharedPreferenceManagement
): ViewModel() {

  fun getSharedPref(context: Context){
//todo context.getSharedPreferences("shared_preference_name",)

  }
}