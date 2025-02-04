package com.olegkos.scannerdemo.feature_onboarding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@Composable
fun OnBoardingImage(
  modifier: Modifier = Modifier,
  @DrawableRes imageResId: Int,
  @StringRes contentDesResId: Int,
  size: Dp,
) {
  Image(
    modifier = modifier
      .size(size)
      .padding(NORMAL_SPACING)
    ,
    contentScale = ContentScale.Crop,
    painter = painterResource(id = imageResId),
    contentDescription = stringResource(id = contentDesResId)
  )
}

