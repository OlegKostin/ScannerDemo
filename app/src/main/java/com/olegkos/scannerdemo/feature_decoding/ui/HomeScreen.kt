package com.olegkos.scannerdemo.feature_decoding.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.olegkos.scannerdemo.core.utils.DOUBLE_SPACING
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeAppBar
import com.olegkos.scannerdemo.feature_decoding.ui.components.HomeContent
import com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.HomeBottomSheetContent
import com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet.QRBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
  val sheetState = rememberModalBottomSheetState()
  var showBottomSheet by remember { mutableStateOf(false) }
  Scaffold(
    topBar = {
      HomeAppBar()
    },
    floatingActionButton = {
      FloatingActionButton(
        onClick = {
          showBottomSheet = true
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
        ModalBottomSheet(
          onDismissRequest = {
            showBottomSheet = false
          },
          sheetState = sheetState,
          shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
          containerColor = MaterialTheme.colorScheme.surface,
          tonalElevation = 16.dp,
          dragHandle = {
            HomeBottomSheetContent()
          }
        ) {

        }
      }
      HomeContent(
        value = "",
        onValueChange = {},
      )
    }
  }
}

