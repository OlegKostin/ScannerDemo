package com.olegkos.scannerdemo.feature_decoding.data.util

interface ProductData<CK, CV, K, V> {
  val countryMap: HashMap<CK, CV>
  val monthMap: HashMap<K, V>
  val yearMap: HashMap<K, V>
  fun fillYear()
  fun fillCountry()
  fun fillMonth()


}