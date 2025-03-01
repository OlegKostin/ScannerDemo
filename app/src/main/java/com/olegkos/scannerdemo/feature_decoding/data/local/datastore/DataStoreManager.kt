package com.olegkos.scannerdemo.feature_decoding.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.Brands
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DataStoreManager @Inject constructor(private val dataStore: DataStore<Preferences>) :
  DataStoreManagement {
  override suspend fun updateSerial(serial: String) {
    dataStore.edit { preferences ->
      preferences[serialKey] = serial
    }
  }

  override fun getSerial(): Flow<String> {
    val serialFlow: Flow<String> = dataStore.data.map { preference ->
      preference[serialKey] ?: ""
    }
    return serialFlow
  }

  override suspend fun updateBrand(brand: String) {
    dataStore.edit { preferences ->
      preferences[brandKey] = brand
    }

  }

  override fun getBrand(): Flow<String> {
    val brandFlow: Flow<String> = dataStore.data.map { preference ->
      preference[brandKey] ?: Brands.SAMSUNG.name
    }
    return brandFlow
  }

  companion object Key {
    const val SERIAL_KEY = "serial"
    const val BRAND_KEY = "brand"
    val serialKey = stringPreferencesKey(SERIAL_KEY)
    val brandKey = stringPreferencesKey(BRAND_KEY)
  }
}