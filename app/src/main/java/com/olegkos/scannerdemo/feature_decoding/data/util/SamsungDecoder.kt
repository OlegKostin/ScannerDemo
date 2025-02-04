package com.olegkos.scannerdemo.feature_decoding.data.util

import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity

const val TV_TYPE = '3'
private const val UNSPECIFIED_TYPE = "UNSPECIFIED_TYPE"
private const val UNSPECIFIED_COUNTRY = "UNSPECIFIED_COUNTRY"
private const val UNSPECIFIED_YEAR = "UNSPECIFIED_YEAR"
private const val UNSPECIFIED_MONTH = "UNSPECIFIED_MONTH"

class SamsungDecoder() : DecoderStrategy, ProductData<Char, Int, Char, String> {

  override val countryMap: HashMap<Char, Int> = hashMapOf()
  override val monthMap: HashMap<Char, String> = hashMapOf()
  override val yearMap: HashMap<Char, String> = hashMapOf()

  init {
    fillCountry()
    fillMonth()
    fillYear()
  }

  override fun isCorrectSerial(serial: String): Boolean {
    return serial.length == 14 || serial.length == 15
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
    yearMap['Y'] = "2005"
    yearMap['A'] = "2006|2021"
    yearMap['L'] = "2006"
    yearMap['P'] = "2007"
    yearMap['Q'] = "2008"
    yearMap['S'] = "2009"
    yearMap['Z'] = "2010"
    yearMap['B'] = "2011|2022"
    yearMap['C'] = "2012|2023"
    yearMap['D'] = "2013"
    yearMap['E'] = "2014"
    yearMap['G'] = "2015"
    yearMap['H'] = "2016"
    yearMap['J'] = "2017"
    yearMap['K'] = "2018"
    yearMap['M'] = "2019"
    yearMap['N'] = "2020"
    yearMap['R'] = "2021"
    yearMap['T'] = "2022"
    yearMap['W'] = "2023"
    yearMap['X'] = "2024"
  }

  override fun fillCountry() {
    countryMap['1'] = R.string.korea
    countryMap['3'] = R.string.korea
    countryMap['4'] = R.string.romania
    countryMap['8'] = R.string.india
    countryMap['C'] = R.string.mexico
    countryMap['H'] = R.string.hungary
    countryMap['L'] = R.string.russia
    countryMap['M'] = R.string.malaysia
    countryMap['N'] = R.string.india
    countryMap['S'] = R.string.slovenia
    countryMap['W'] = R.string.china
  }

  override fun fillMonth() {
    monthMap['1'] = "01"
    monthMap['2'] = "02"
    monthMap['3'] = "03"
    monthMap['4'] = "04"
    monthMap['5'] = "05"
    monthMap['6'] = "06"
    monthMap['7'] = "07"
    monthMap['8'] = "08"
    monthMap['9'] = "09"
    monthMap['A'] = "10"
    monthMap['B'] = "11"
    monthMap['C'] = "12"
  }


  override fun getTypeFromSerial(serial: String): String {
    val typeChar = serial[4]
    return if (typeChar == TV_TYPE)
      "TV"
    else
      UNSPECIFIED_TYPE

  }

  override fun getCountryFromSerial(serial: String): String {
    val countryChar = serial[5]
    return "made in ${countryMap.getOrDefault(countryChar, UNSPECIFIED_COUNTRY)}"
  }


  override fun getDateFromSerial(serial: String): String {
    val yearChar = serial[7]
    val monthString = serial[8]

    val yearValue = yearMap.getOrDefault(yearChar, UNSPECIFIED_YEAR)
    val monthValue = monthMap.getOrDefault(monthString, UNSPECIFIED_MONTH)

    return "made at $monthValue / $yearValue"
  }

}