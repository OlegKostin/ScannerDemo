package com.olegkos.scannerdemo.feature_decoding.ui.components.dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.CORNER_SHAPE
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING

@Composable
fun DismissButton(modifier: Modifier = Modifier, onDismissClicked:() ->Unit) {
  OutlinedButton(
    modifier = modifier
      .padding(horizontal = DOUBLE_SPACING, vertical = DOUBLE_SPACING)
      .fillMaxWidth()
      .clip(RoundedCornerShape(CORNER_SHAPE)),
    onClick = onDismissClicked
  ) {
    Text(text = stringResource(id = R.string.dismiss))
  }
  }
