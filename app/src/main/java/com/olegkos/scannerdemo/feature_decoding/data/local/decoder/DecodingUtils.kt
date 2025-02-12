package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.feature_decoding.data.local.entity.Brands
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.local.factory.DecoderFactory


class DecodingUtils(private val decoderFactory: DecoderFactory) {

  fun isCorrectSerialNumber(serial: String, brands: Brands): Boolean {
    return decoderFactory.createDecoder(brands).isCorrectSerial(serial)
  }

  fun decodeSerial(serial: String, brands: Brands): ProductEntity {
    return decoderFactory.createDecoder(brands).decodeSerial(serial)

  }


}



