package com.olegkos.scannerdemo.feature_decoding.ui

import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeAppBar
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  val sheetState = rememberBottomSheetScaffoldState()
  BottomSheetScaffold(
    topBar = {
      HomeAppBar()
    },
    scaffoldState = sheetState,
    sheetContent = { HomeBottomSheet() }
  ) {


  }

}