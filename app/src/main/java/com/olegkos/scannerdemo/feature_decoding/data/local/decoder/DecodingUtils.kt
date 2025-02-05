package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.factory.BrandAdapterFactory


const val UNSPECIFIED_TYPE = "UNSPECIFIED_TYPE"
const val UNSPECIFIED_COUNTRY = "UNSPECIFIED_COUNTRY"
const val UNSPECIFIED_YEAR = "UNSPECIFIED_YEAR"
const val UNSPECIFIED_MONTH = "UNSPECIFIED_MONTH"

class DecodingUtils(val brandsAdapterFactory: BrandAdapterFactory) {

  fun isCorrectSerialNumber(serial: String, brands: Brands): Boolean {
    return brandsAdapterFactory.createDecoder(brands).isCorrectSerial(serial)
  }

  fun decodeSerial(serial: String, brands: Brands): ProductEntity {
    return brandsAdapterFactory.createDecoder(brands).decodeSerial(serial)

  }


}



