package com.olegkos.scannerdemo.feature_decoding.data.local.factory

import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.DecoderStrategy
import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.LGDecoder
import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.SamsungDecoder
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.Brands


class DecoderFactory : IDecoderFactory {

  override fun createDecoder(brands: Brands): DecoderStrategy {
    return when (brands) {
      Brands.SAMSUNG -> SamsungDecoder()
      Brands.LG -> LGDecoder()
    }
  }
}