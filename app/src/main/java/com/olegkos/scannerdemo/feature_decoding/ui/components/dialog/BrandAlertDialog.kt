package com.olegkos.scannerdemo.feature_decoding.ui.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.CORNER_SHAPE
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.feature_decoding.data.entity.Brands

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrandAlertDialog(
  modifier: Modifier = Modifier, brands: Array<Brands>,
  onBrandClicked: () -> Unit,
  onDismissRequest: () -> Unit
) {
  BasicAlertDialog(
    modifier = modifier,
    onDismissRequest = onDismissRequest
  ) {  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(DOUBLE_SPACING),
    shape = RoundedCornerShape(CORNER_SHAPE),
  ) {
    AlertDialogTitle(title = stringResource(id = R.string.select_a_brand))
    Column {
      LazyColumn {
        items(brands.size) {
          Brand(
            brandName = brands[it].name,
            onBrandClicked = {
              onBrandClicked()
              onDismissRequest()
            }
          )
        }
      }
      DismissButton(
        onDismissClicked = onDismissRequest
      )
    }
  }
  }
}

