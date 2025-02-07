package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.UIText
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.util.ProductData

class LGDecoder() : DecoderStrategy, ProductData<String, Int, String, String> {

  override val countryMap: HashMap<String, Int> = hashMapOf()
  override val monthMap: HashMap<String, String> = hashMapOf()
  override val yearMap: HashMap<String, String> = hashMapOf()

  init {
    fillCountry()
    fillMonth()
    fillYear()
  }

  override fun isCorrectSerial(serial: String): Boolean {
    return serial.length == 12
  }

  override fun decodeSerial(serial: String): ProductEntity {
    val type = getTypeFromSerial(serial)
    val country = getCountryFromSerial(serial)
    val date = getDateFromSerial(serial)
    return ProductEntity(
      type = type,
      country = country,
      date = date
    )
  }

  override fun fillYear() {
    yearMap.putAll((0..9).associate { it.toString() to "${2000 + it}|${2010 + it}|${2020 + it}" })
  }

  override fun fillCountry() {
    countryMap.putAll(
      mapOf(
        "RM" to R.string.mexico, "MX" to R.string.mexico,
        "MA" to R.string.poland, "WR" to R.string.poland,
        "IN" to R.string.indonesia, "RN" to R.string.korea,
        "KC" to R.string.korea, "RA" to R.string.russia,
        "ND" to R.string.china
      )
    )
  }

  override fun fillMonth() {
    monthMap.putAll((1..12).associate {
      it.toString().padStart(2, '0') to it.toString().padStart(2, '0')
    })
  }


  override fun getTypeFromSerial(serial: String): UIText {
    return UIText.StringResource(R.string.tv)

  }

  override fun getCountryFromSerial(serial: String): UIText {
    val countryCode = serial.substring(3, 5)
    return if (countryMap.containsKey(countryCode))
      UIText.StringResource(resId = countryMap[countryCode]!!)
    else UIText.StringResource(resId = R.string.unspecified_country)
  }

  override fun getDateFromSerial(serial: String): UIText {
    val yearChar = serial[0].toString()
    val monthString = serial.substring(1, 3)

    val yearValue = yearMap.getOrDefault(yearChar, UIText.StringResource(R.string.unspecified_year))
    val monthValue = monthMap.getOrDefault(monthString, UIText.StringResource(R.string.unspecified_month))

    return UIText.DynamicString(text = "$monthValue / $yearValue")
  }

}