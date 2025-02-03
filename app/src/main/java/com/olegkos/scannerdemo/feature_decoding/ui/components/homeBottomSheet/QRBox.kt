package com.olegkos.scannerdemo.feature_decoding.ui.components.homeBottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.utils.BOTTOM_SHEET_PEEK_HEIGHT
import com.olegkos.scannerdemo.core.utils.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.utils.TRIPLE_SPACING

@Composable
fun QRBox(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .size(BOTTOM_SHEET_PEEK_HEIGHT)
      .clip(RoundedCornerShape(topStart = TRIPLE_SPACING, topEnd = TRIPLE_SPACING))
      .background(MaterialTheme.colorScheme.secondary), contentAlignment = Alignment.Center
  ) {
    Icon(
      painter = painterResource(id = R.drawable.ic_qr_code),
      contentDescription = stringResource(
        id = R.string.bottom_sheet_puller
      ), tint = Color.Unspecified
    )
  }

}
