package com.olegkos.scannerdemo.feature_faq.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.BACK_BUTTON_SIZE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopFAQBar(modifier: Modifier, onBackButtonPressed: () -> Unit) {
  TopAppBar(
    modifier = modifier,
    title = { FAQTitle(modifier = modifier) },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.secondary, // Задаем цвет фона
      // titleContentColor = MaterialTheme.colorScheme.primary // Цвет текста
    ),
    navigationIcon = {
      BackButtonIcon(
        modifier = modifier,
        onBackButtonPressed = onBackButtonPressed
      )
    },
  )
}

@Composable
fun FAQTitle(modifier: Modifier) {
  Text(
    modifier = modifier,
    style = MaterialTheme.typography.displayMedium,
    text = stringResource(id = R.string.frequently_asked_questions)
  )
}

@Composable
fun BackButtonIcon(modifier: Modifier, onBackButtonPressed: () -> Unit) {
  IconButton(modifier = modifier, onClick = onBackButtonPressed) {
    Icon(
      modifier = modifier.size(BACK_BUTTON_SIZE),
      painter = painterResource(id = R.drawable.ic_back),
      contentDescription =
      stringResource(R.string.back_button),
      tint = MaterialTheme.colorScheme.primary
    )

  }
}

