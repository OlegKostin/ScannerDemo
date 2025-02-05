package com.olegkos.scannerdemo.feature_decoding.ui

sealed class HomeUiEvent {
  data object ShowDialog : HomeUiEvent()
}