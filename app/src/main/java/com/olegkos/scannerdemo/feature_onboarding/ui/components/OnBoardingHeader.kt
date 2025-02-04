package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun OnBoardingHeader(modifier: Modifier = Modifier, @StringRes headerId: Int) {
  Text(
    modifier = modifier,
    textAlign = TextAlign.Center,
    text = stringResource(id = headerId),
    style = MaterialTheme.typography.displayLarge
  )
}