package com.olegkos.scannerdemo.core.ui

import androidx.lifecycle.ViewModel
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(sharedPreferenceManager: SharedPreferenceManagement) :
  ViewModel() {

  val firstTimeOrNot = sharedPreferenceManager.getIsFirstTime()
}