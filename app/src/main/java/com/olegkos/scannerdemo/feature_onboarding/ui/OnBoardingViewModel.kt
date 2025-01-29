package com.olegkos.scannerdemo.feature_onboarding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManagement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
  private val sharedPreferenceManagement: SharedPreferenceManagement
) : ViewModel() {
  private val _uiEvent: MutableSharedFlow<OnBoardingEvent> =
    MutableSharedFlow()
  val uiEvent: SharedFlow<OnBoardingEvent> = _uiEvent.asSharedFlow()


  private val _uiState: MutableStateFlow<OnBoardingState> =
    MutableStateFlow(OnBoardingState(isLoading = false))
  val uiState: StateFlow<OnBoardingState> = _uiState.asStateFlow()

  private fun setLoading(isLoading: Boolean) {
    _uiState.value = _uiState.value.copy(isLoading = isLoading)
  }

  fun updateFirstTime() {
    setLoading(true)
    sharedPreferenceManagement.updateFirstTime(false)
    viewModelScope.launch {
      _uiEvent.emit(OnBoardingEvent.UpdateFirstTime)
      setLoading(false)
    }
  }
}