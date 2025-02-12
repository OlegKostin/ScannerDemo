package com.olegkos.scannerdemo.feature_faq.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.ui.components.NormalButton
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING
import com.olegkos.scannerdemo.core.util.YOUTUBE

@Composable
fun BottomButtons(modifier: Modifier = Modifier) {
  val uriHandler = LocalUriHandler.current
  Column {
    ContactDeveloperButton(modifier) {
      uriHandler.openUri(YOUTUBE)
    }
    RateAppButton(modifier) {
      uriHandler.openUri(YOUTUBE)
    }
  }

}

@Composable
fun ContactDeveloperButton(modifier: Modifier = Modifier, onButtonPressed: () -> Unit) {
  NormalButton(
    modifier = modifier
      .padding(horizontal = DOUBLE_SPACING, vertical = NORMAL_SPACING)
      .fillMaxWidth(),
    onClick = onButtonPressed
  ) {
    Text(stringResource(R.string.contact_the_developer))
  }
}

@Composable
fun RateAppButton(modifier: Modifier = Modifier, onButtonPressed: () -> Unit) {
  NormalButton(
    modifier = modifier
      .padding(DOUBLE_SPACING)
      .fillMaxWidth(),
    onClick = onButtonPressed
  ) {
    Text(stringResource(R.string.rate_the_app))
  }
}