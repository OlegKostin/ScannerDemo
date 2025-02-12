package com.olegkos.scannerdemo.core.di

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.olegkos.scannerdemo.feature_decoding.data.local.datastore.DataStoreManagement
import com.olegkos.scannerdemo.feature_decoding.data.local.datastore.DataStoreManager
import com.olegkos.scannerdemo.feature_decoding.data.local.factory.DecoderFactory
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManagement
import com.olegkos.scannerdemo.feature_onboarding.data.local.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalAppModule {
  private const val SERIAL_DECODER_DATA_STORE_NAME = "serialDecoderDataStore"

  private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = SERIAL_DECODER_DATA_STORE_NAME)

  @Provides
  @Singleton
  fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
    return context.getSharedPreferences(
      SharedPreferenceManager.SHARED_PREFERENCE_NAME,
      Context.MODE_PRIVATE
    )
  }

  @Provides
  @Singleton
  fun provideSharedPreferenceManagement(sharedPreferences: SharedPreferences): SharedPreferenceManagement {
    return SharedPreferenceManager(sharedPreferences)
  }

  @Provides
  @Singleton
  fun provideDataStoreManagement(dataStore: DataStore<Preferences>): DataStoreManagement {
    return DataStoreManager(dataStore)
  }

  @Provides
  @Singleton
  fun provideDataStorePreference(@ApplicationContext context: Context): DataStore<Preferences> {
    return context.dataStore
  }

  @Provides
  @Singleton
  fun provideDecoderFactory(): DecoderFactory {
    return DecoderFactory()
  }


}