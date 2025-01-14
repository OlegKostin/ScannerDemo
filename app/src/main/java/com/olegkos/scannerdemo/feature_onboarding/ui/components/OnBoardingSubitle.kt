package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.olegkos.scannerdemo.core.utils.FOUR_TIMES_SPACING

@Composable
fun OnBoardingSubTitle(modifier: Modifier = Modifier, @StringRes subtitleId: Int) {
  Text(
    modifier = modifier.padding(horizontal = FOUR_TIMES_SPACING),
    text = stringResource(id = subtitleId),
    textAlign = TextAlign.Center,
    style = MaterialTheme.typography.titleSmall
  )
}