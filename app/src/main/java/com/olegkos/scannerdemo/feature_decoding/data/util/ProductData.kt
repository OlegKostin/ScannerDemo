package com.olegkos.scannerdemo.feature_decoding.data.util

interface ProductData<K,V> {
  val countryMap: HashMap<K, V>
  val monthMap: HashMap<K, V>
  val yearMap: HashMap<K, V>
  fun fillYear()
  fun fillCountry()
  fun fillMonth()



}