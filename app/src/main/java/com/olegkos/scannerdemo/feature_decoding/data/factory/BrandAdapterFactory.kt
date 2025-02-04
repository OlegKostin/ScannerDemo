package com.olegkos.scannerdemo.feature_decoding.data.factory

import com.olegkos.scannerdemo.feature_decoding.data.decoder.DecoderStrategy
import com.olegkos.scannerdemo.feature_decoding.data.decoder.LGDecoder
import com.olegkos.scannerdemo.feature_decoding.data.decoder.SamsungDecoder
import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands


class BrandAdapterFactory : IBrandAdapterFactory {

  override fun createDecoder(brands: Brands): DecoderStrategy {
    return when (brands) {
      Brands.SAMSUNG -> SamsungDecoder()
      Brands.LG -> LGDecoder()
    }
  }
}