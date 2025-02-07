package com.olegkos.scannerdemo.feature_decoding.data.local.factory

import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.DecoderStrategy
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.Brands

interface IDecoderFactory {
  fun createDecoder(brands: Brands): DecoderStrategy
}