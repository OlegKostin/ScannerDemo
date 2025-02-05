package com.olegkos.scannerdemo.feature_decoding.data.factory

import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.DecoderStrategy
import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.LGDecoder
import com.olegkos.scannerdemo.feature_decoding.data.local.decoder.SamsungDecoder
import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands


class DecoderFactory : IDecoderFactory {

  override fun createDecoder(brands: Brands): DecoderStrategy {
    return when (brands) {
      Brands.SAMSUNG -> SamsungDecoder()
      Brands.LG -> LGDecoder()
    }
  }
}