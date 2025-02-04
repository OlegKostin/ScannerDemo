package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun OnBoardingSubtitle(modifier: Modifier = Modifier, @StringRes subtitleId: Int) {
  Text(
    modifier = modifier,
    text = stringResource(id = subtitleId),
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.bodyLarge
  )
}