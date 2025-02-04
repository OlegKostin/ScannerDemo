package com.olegkos.scannerdemo.feature_decoding.data.util

import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity


class DecodingUtils {
  val countryMap: HashMap<Char, String> = hashMapOf()
  val monthMap: HashMap<Char, String> = hashMapOf()
  val yearMap: HashMap<Char, String> = hashMapOf()


  fun isCorrectSerialNumber(serial: String, brands: Brands): Boolean {
    return true
  }

  fun decodeSerial(serial: String, brands: Brands): ProductEntity {
    return ProductEntity("","","")

  }


}



