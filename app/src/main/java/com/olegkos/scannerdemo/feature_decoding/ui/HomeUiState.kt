package com.olegkos.scannerdemo.feature_decoding.ui

import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity

data class HomeUiState(
  val isLoading: Boolean,
  val serial: String,
  val brand: String,
  val productEntity: ProductEntity,
)