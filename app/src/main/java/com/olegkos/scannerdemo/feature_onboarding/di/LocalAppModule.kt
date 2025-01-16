package com.olegkos.scannerdemo.feature_onboarding.di

import android.content.Context
import android.content.SharedPreferences
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
}