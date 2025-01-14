package com.olegkos.scannerdemo.feature_onboarding.ui.components.dotIndicator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.olegkos.scannerdemo.core.utils.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.utils.TRIPLE_SPACING
import com.olegkos.scannerdemo.feature_onboarding.util.FIRST_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.SECOND_INDEX_PAGE
import com.olegkos.scannerdemo.feature_onboarding.util.THIRD_INDEX_PAGE

@Composable
fun NavigationDotIndicator(modifier: Modifier = Modifier, currentPage: Int) {

  Row(
    modifier = modifier.padding(bottom = FOUR_TIMES_SPACING),
    horizontalArrangement = Arrangement.spacedBy(TRIPLE_SPACING)
  ) {
    Dot(selected = currentPage == FIRST_INDEX_PAGE)
    Dot(selected = currentPage == SECOND_INDEX_PAGE)
    Dot(selected = currentPage == THIRD_INDEX_PAGE)
  }
}