package com.olegkos.scannerdemo.feature_onboarding.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
  private val sharedPreferenceManagement: SharedPreferenceManagement
) : ViewModel() {
  private val _uiEvent: MutableSharedFlow<OnBoardingEvent> =
    MutableSharedFlow()
  val uiEvent: SharedFlow<OnBoardingEvent> = _uiEvent.asSharedFlow()

  fun updateFirstTime() = viewModelScope.launch {
    _uiEvent.emit(OnBoardingEvent.UpdateFirstTime)
  }
}