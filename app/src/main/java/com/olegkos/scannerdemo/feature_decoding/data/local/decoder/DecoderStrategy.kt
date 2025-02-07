package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.core.util.UIText
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity

interface DecoderStrategy {
  fun isCorrectSerial(serial: String): Boolean
  fun decodeSerial(serial: String) : ProductEntity

  fun getTypeFromSerial(serial:String): UIText
  fun getCountryFromSerial(serial:String): UIText
  fun getDateFromSerial(serial:String): UIText
}