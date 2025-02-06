package com.olegkos.scannerdemo.feature_decoding.ui

import android.content.Context
import android.util.Log
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.launch
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onFAQButtonClicked: () -> Unit) {
  val viewModel: HomeViewModel = hiltViewModel()
  val serialBrandState = viewModel.serialBrandFlow.collectAsState(
    initial = listOf()
  )
  val uiState: State<HomeUiState> = viewModel.uiState.collectAsStateWithLifecycle()
  var showBottomSheet by rememberSaveable { mutableStateOf(false) }

  val cameraBottomSheetState = rememberModalBottomSheetState()
  val coroutineScope = rememberCoroutineScope()

  val showDialog = rememberSaveable { mutableStateOf(false) }
  val context = LocalContext.current
  LaunchedEffect(cameraBottomSheetState.isVisible) {
    if (!cameraBottomSheetState.isVisible) {
      stopCamera(context)
    }
  }
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
          onClick = {
            showBottomSheet = true
            coroutineScope.launch { cameraBottomSheetState.show() }
          },
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
            modifier = modifier,
            sheetState = cameraBottomSheetState,
            onDismissRequest = { showBottomSheet = false },
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

fun stopCamera(context: Context) {
  val cameraProvider = ProcessCameraProvider.getInstance(context).get()
  cameraProvider.unbindAll()
}