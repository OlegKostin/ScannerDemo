package com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.ui.components.NormalButton
import com.olegkos.scannerdemo.core.utils.CORNER_SHAPE
import com.olegkos.scannerdemo.core.utils.NORMAL_SPACING

@Composable
fun GetStartedButton(modifier: Modifier = Modifier) {
  NormalButton(modifier = modifier
    .clip(RoundedCornerShape(CORNER_SHAPE))
    .fillMaxWidth()
    .padding(NORMAL_SPACING),
    onClick = {

    }
  ) {
    Text(text = stringResource(R.string.get_started))
  }


}