package com.olegkos.scannerdemo.feature_decoding.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeAppBar
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeContent
import com.olegkos.scannerdemo.feature_decoding.ui.components.LoadingBox
import com.olegkos.scannerdemo.feature_decoding.ui.components.dialog.BrandAlertDialog
import com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.HomeModalBottomSheet
import com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.QRBox
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onFAQButtonClicked: () -> Unit) {
  val viewModel: HomeViewModel = hiltViewModel()
  val serialBrandState = viewModel.serialBrandFlow.collectAsState(
    initial = listOf()
  )
  val uiState: State<HomeUiState> = viewModel.uiState.collectAsStateWithLifecycle()
  var showBottomSheet by rememberSaveable { mutableStateOf(false) }
  val showDialog = rememberSaveable { mutableStateOf(false) }

  LaunchedEffect(key1 = showDialog) {
    viewModel.uiEvent.collectLatest { homeUiEvent ->
      when (homeUiEvent) {
        HomeUiEvent.ShowDialog -> {
          showDialog.value = true
        }
      }
    }
  }
  if (showDialog.value) {
    BrandAlertDialog(
      brands = viewModel.brands,
      onBrandClicked = { brand ->
        viewModel.updateBrand(brand)
      },
      onDismissRequest = { showDialog.value = false },
    )
  }
  if (uiState.value.isLoading) {
    LoadingBox()
  } else {
  Scaffold(
    topBar = {
      HomeAppBar(
        modifier = modifier,
        title = uiState.value.brand,
        onBrandButtonClicked = {
          viewModel.showDialog()
        },
        onFAQButtonClicked = onFAQButtonClicked,
      )
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = { showBottomSheet = true },
        containerColor = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(end = DOUBLE_SPACING)
      ) {
        QRBox()
      }
    }

  ) { paddingValue ->
    Column(
      modifier = modifier
        .fillMaxSize()
        .padding(paddingValue)
    ) {
      if (showBottomSheet) {
        HomeModalBottomSheet(
          onDismissRequest = { showBottomSheet = false }
        )
      }

        HomeContent(
          modifier = modifier,
          productEntity = uiState.value.productEntity,
          value = uiState.value.serial,
          onValueChange = { serial ->
            viewModel.updateSerial(serial)
          },
        )
      }
    }
  }
}

