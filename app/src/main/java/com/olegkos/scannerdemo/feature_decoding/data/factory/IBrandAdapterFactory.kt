package com.olegkos.scannerdemo.feature_decoding.data.factory

import com.olegkos.scannerdemo.feature_decoding.data.decoder.DecoderStrategy
import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands

interface IBrandAdapterFactory {
  fun createDecoder(brands: Brands): DecoderStrategy
}