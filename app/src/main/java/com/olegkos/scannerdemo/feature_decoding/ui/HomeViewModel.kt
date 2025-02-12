package com.olegkos.scannerdemo.feature_decoding.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.UIText
import com.olegkos.scannerdemo.feature_decoding.data.local.datastore.DataStoreManagement
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.Brands
import com.olegkos.scannerdemo.feature_decoding.data.local.entity.ProductEntity
import com.olegkos.scannerdemo.feature_decoding.data.local.factory.DecoderFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val BRAND_INDEX: Int = 1
private const val SERIAL_INDEX: Int = 0

@HiltViewModel
class HomeViewModel
@Inject constructor(
  private val dataStoreManager: DataStoreManagement,
  private val decoderFactory: DecoderFactory
) : ViewModel() {

  val brands: Array<Brands> = Brands.entries.toTypedArray()
  private val _uiState: MutableStateFlow<HomeUiState> =
    MutableStateFlow(
      HomeUiState(
        isLoading = true,
        serial = "",
        brand = brands[0].name,
        productEntity = getProductEntityBySerialAndBrand(
          "", brands[0].name
        )
      )
    )
  var uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

  private val _uiEvent: MutableSharedFlow<HomeUiEvent> = MutableSharedFlow()
  val uiEvent: SharedFlow<HomeUiEvent> = _uiEvent.asSharedFlow()

  private val serialFlow: Flow<String> = dataStoreManager.getSerial()
  private val brandFlow: Flow<String> = dataStoreManager.getBrand()

  val serialBrandFlow = serialFlow.combine(brandFlow) { serial, brand ->
    listOf(serial, brand)
  }.onStart {
    _uiState.value = _uiState.value.copy(isLoading = false)
  }.onEach { serialBrandList ->
    val serial = serialBrandList[SERIAL_INDEX]
    val brand = serialBrandList[BRAND_INDEX]
    _uiState.value = _uiState.value.copy(
      serial = serial,
      brand = brand,
      productEntity = getProductEntityBySerialAndBrand(serial, brand)
    )
  }

  private fun getProductEntityBySerialAndBrand(serial: String, brand: String): ProductEntity {
    val decoder = decoderFactory.createDecoder(Brands.valueOf(brand))

    if (!decoder.isCorrectSerial(serial))
      return ProductEntity(
        UIText.StringResource(R.string.unspecified_type),
        UIText.StringResource(R.string.unspecified_country),

        UIText.StringResource(R.string.unspecified_date)
      )
    val productEntity = decoder.decodeSerial(serial)
    return productEntity
  }

  fun updateSerial(serial: String) = viewModelScope.launch(Dispatchers.IO) {
    Log.d("TAG", "$serial")
    dataStoreManager.updateSerial(serial)
  }

  fun updateBrand(brand: String) = viewModelScope.launch(Dispatchers.IO) {
    dataStoreManager.updateBrand(brand)
  }

  fun showDialog() = viewModelScope.launch {
    _uiEvent.emit(HomeUiEvent.ShowDialog)
  }

  fun showSnackBar(localizedMessage: String) = viewModelScope.launch {
    _uiEvent.emit(HomeUiEvent.ShowSnackBar(localizedMessage))
  }
}