package com.olegkos.scannerdemo.feature_decoding.ui

import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity

data class HomeUiState(
  val isLoading: Boolean,
  val serial: String,
  val brand: String,
  val productEntity: ProductEntity,
)