package com.olegkos.scannerdemo.feature_decoding.ui

sealed class HomeUiEvent {
  data object ShowDialog : HomeUiEvent()
  data class ShowSnackBar(val message: String) : HomeUiEvent()
}