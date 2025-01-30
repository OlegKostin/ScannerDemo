package com.olegkos.scannerdemo.feature_faq.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.ui.components.NormalButton
import com.olegkos.scannerdemo.core.utils.DOUBLE_SPACING
import com.olegkos.scannerdemo.core.utils.NORMAL_SPACING

@Composable
fun BottomButtons(modifier: Modifier = Modifier) {
  Column {
    ContactDeveloperButton(modifier)
    RateAppButton(modifier)
  }

}

@Composable
fun ContactDeveloperButton(modifier: Modifier = Modifier) {
  NormalButton(modifier = modifier
    .padding(horizontal = DOUBLE_SPACING, vertical = NORMAL_SPACING)
    .fillMaxWidth(),
    onClick = { TODO() }
  ) {
    Text(stringResource(R.string.contact_the_developer))
  }
}

@Composable
fun RateAppButton(modifier: Modifier = Modifier) {
  NormalButton(modifier = modifier
    .padding( DOUBLE_SPACING)
    .fillMaxWidth(),
    onClick = { TODO() }
  ) {
    Text(stringResource(R.string.rate_the_app))
  }
}