package com.olegkos.scannerdemo.feature_decoding.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  val sheetState = rememberBottomSheetScaffoldState()
BottomSheetScaffold(

  scaffoldState = sheetState,
  sheetContent = { HomeBottomSheet() }
) {


}

}