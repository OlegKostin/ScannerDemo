package com.olegkos.scannerdemo.feature_faq.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.FOUR_TIMES_SPACING
import com.olegkos.scannerdemo.core.util.NORMAL_SPACING

@Composable
fun FAQContent(modifier: Modifier) {
  LazyColumn(
    modifier = modifier, contentPadding = PaddingValues(NORMAL_SPACING)
  ) {
    item {
      Question(
        modifier = modifier,
        question = stringResource(R.string.faq_1),
        answer = stringResource(R.string.ans_1)
      )
    }
    item {
      Question(
        modifier = modifier,
        question = stringResource(R.string.faq_2),
        answer = stringResource(R.string.ans_2)
      )
    }
    item {
      Question(
        modifier = modifier,
        question = stringResource(R.string.faq_3),
        answer = stringResource(R.string.ans_3)
      )
    }
  }
}

@Composable
fun Question(modifier: Modifier , question: String, answer: String) {

  val isExpanded = remember {
    mutableStateOf(false)
  }
  Column(
    modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row(
      modifier
        .padding(NORMAL_SPACING)
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.secondary)
        .clickable { isExpanded.value = !isExpanded.value },
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      val painterIcon = if (!isExpanded.value)
        painterResource(R.drawable.ic_dropdown)
      else
        painterResource(R.drawable.ic_collapse)
      Icon(
        painter = painterIcon,
        contentDescription = stringResource(R.string.drop_down_icon),
        tint = MaterialTheme.colorScheme.primary
      )
      Text(modifier = modifier.weight(1f) ,textAlign = TextAlign.Center, text = question, style = MaterialTheme.typography.bodyLarge)
    }
    AnimatedVisibility(
      visible = isExpanded.value,
      enter = expandVertically(
        spring(
          stiffness = Spring.StiffnessLow
        )
      ),
      exit = shrinkVertically ()
    ) {
      Text(
        modifier = modifier
          .padding(horizontal = FOUR_TIMES_SPACING),
        text = answer,
        style = MaterialTheme.typography.titleMedium
      )
    }
  }
}