package com.olegkos.scannerdemo.feature_decoding.data.util

import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity

private const val UNSPECIFIED_TYPE = "UNSPECIFIED_TYPE"
private const val UNSPECIFIED_COUNTRY = "UNSPECIFIED_COUNTRY"
private const val UNSPECIFIED_YEAR = "UNSPECIFIED_YEAR"
private const val UNSPECIFIED_MONTH = "UNSPECIFIED_MONTH"

class LGDecoder() : DecoderStrategy, ProductData<String, Int,String, String> {

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
    yearMap["9"] = "2009|2019|2029"
    yearMap["8"] = "2008|2018|2028"
    yearMap["7"] = "2007|2017|2027"
    yearMap["6"] = "2006|2016|2026"
    yearMap["5"] = "2005|2015|2025"
    yearMap["4"] = "2004|2014|2024"
    yearMap["3"] = "2003|2013|2023"
    yearMap["2"] = "2002|2012|2022"
    yearMap["1"] = "2001|2011|2021"
    yearMap["0"] = "2000|2010|2020"
  }

  override fun fillCountry() {
    countryMap["RM"] = R.string.mexico
    countryMap["MX"] = R.string.mexico
    countryMap["MA"] = R.string.poland
    countryMap["WR"] = R.string.poland
    countryMap["IN"] = R.string.indonesia
    countryMap["RN"] = R.string.korea
    countryMap["KC"] = R.string.korea
    countryMap["RA"] = R.string.russia
    countryMap["ND"] = R.string.china
  }

  override fun fillMonth() {
    monthMap["01"] = "01"
    monthMap["02"] = "02"
    monthMap["03"] = "03"
    monthMap["04"] = "04"
    monthMap["05"] = "05"
    monthMap["06"] = "06"
    monthMap["07"] = "07"
    monthMap["08"] = "08"
    monthMap["09"] = "09"
    monthMap["10"] = "10"
    monthMap["11"] = "11"
    monthMap["12"] = "12"
  }


  override fun getTypeFromSerial(serial: String): String {
    val typeChar = serial[4]
    return if (typeChar == TV_TYPE)
      "TV"
    else
      UNSPECIFIED_TYPE
  }

  override fun getCountryFromSerial(serial: String): String {
    val countryCode = serial.substring(3, 5)
    return "made in " + countryMap.getOrDefault(countryCode, UNSPECIFIED_COUNTRY)
  }

  override fun getDateFromSerial(serial: String): String {
    val yearChar = serial[0].toString()
    val monthString = serial.substring(1, 3)

    val yearValue = yearMap.getOrDefault(yearChar, UNSPECIFIED_YEAR)
    val monthValue = monthMap.getOrDefault(monthString, UNSPECIFIED_MONTH)

    return "made at $monthValue / $yearValue"
  }

}