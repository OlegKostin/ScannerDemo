package com.olegkos.scannerdemo.feature_decoding.data.local.decoder

import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.UIText
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.util.ProductData

const val TV_TYPE = '3'

class SamsungDecoder : DecoderStrategy, ProductData<Char, Int, Char, String> {

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
    monthMap.putAll(
      mapOf(
        '1' to "01", '2' to "02", '3' to "03",
        '4' to "04", '5' to "05", '6' to "06",
        '7' to "07", '8' to "08", '9' to "09",
        'A' to "10", 'B' to "11", 'C' to "12"
      )
    )
  }


  override fun getTypeFromSerial(serial: String): UIText {
    val typeChar = serial[4]
    return if (typeChar == TV_TYPE)
      UIText.StringResource(resId = R.string.tv)
    else
      UIText.StringResource(R.string.unspecified_type)

  }

  override fun getCountryFromSerial(serial: String): UIText {
    val countryChar = serial[5]
    return if (countryMap.containsKey(countryChar))
      UIText.StringResource(resId = countryMap[countryChar]!!)
    else UIText.StringResource(resId = R.string.unspecified_country)
  }


  override fun getDateFromSerial(serial: String): UIText {
    val yearChar = serial[7]
    val monthString = serial[8]


    var yearValue = "..."
    var monthValue = "..."
    if (yearMap.containsKey(yearChar)) yearValue = yearMap[yearChar]!!
    if (monthMap.containsKey(monthString)) monthValue = monthMap[monthString]!!

    return UIText.DynamicString("$monthValue /$yearValue")
  }

}