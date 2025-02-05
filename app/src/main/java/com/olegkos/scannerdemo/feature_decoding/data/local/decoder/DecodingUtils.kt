package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.factory.DecoderFactory


const val UNSPECIFIED_TYPE = "UNSPECIFIED_TYPE"
const val UNSPECIFIED_COUNTRY = "UNSPECIFIED_COUNTRY"
const val UNSPECIFIED_YEAR = "UNSPECIFIED_YEAR"
const val UNSPECIFIED_MONTH = "UNSPECIFIED_MONTH"

class DecodingUtils(private val decoderFactory: DecoderFactory) {

  fun isCorrectSerialNumber(serial: String, brands: Brands): Boolean {
    return decoderFactory.createDecoder(brands).isCorrectSerial(serial)
  }

  fun decodeSerial(serial: String, brands: Brands): ProductEntity {
    return decoderFactory.createDecoder(brands).decodeSerial(serial)

  }


}



