package com.olegkos.scannerdemo.feature_decoding.data.decoder

import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity

interface DecoderStrategy {
  fun isCorrectSerial(serial: String): Boolean
  fun decodeSerial(serial: String) : ProductEntity

  fun getTypeFromSerial(serial:String): String
  fun getCountryFromSerial(serial:String): String
  fun getDateFromSerial(serial:String): String
}