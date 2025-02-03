package com.olegkos.scannerdemo.feature_decoding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(modifier: Modifier = Modifier) {
  TopAppBar(modifier = modifier,
    navigationIcon = { AppBarIcon() },
    title = { AppBarTitle(title = "Samsung"/*TODO*/) },
    actions = {
      AddMenuActions(
        modifier = modifier,
        onBrandClick =  {},
        onFAQClick = {}
      )}
    )
}

@Composable
fun AppBarIcon(modifier: Modifier = Modifier) {
  Icon(
    modifier = modifier, painter = painterResource(id = R.drawable.ic_scanner),
    contentDescription = stringResource(R.string.app_icon),
    tint = MaterialTheme.colorScheme.primary
  )
}

@Composable
fun AppBarTitle(modifier: Modifier = Modifier, title: String) {
  Text(text = title, style = MaterialTheme.typography.displayMedium)

}

@Composable
fun AddMenuActions(
  modifier : Modifier,
  onBrandClick: () -> Unit,
  onFAQClick: () -> Unit
) {

    AddMenuItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_apple,
      stringResId = R.string.change_manufactor,
      onClick = onBrandClick
    )
    AddMenuItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_info,
      stringResId = R.string.faq_btn_home_app,
      onClick = onFAQClick
    )
  }

@Composable
fun AddMenuItem(
  modifier: Modifier = Modifier,
  @DrawableRes drawableResId: Int,
  @StringRes stringResId: Int,
  onClick: () -> Unit
) {
  IconButton(
    modifier = modifier,
    onClick = onClick
  ) {
    Icon(
      modifier = modifier,
      painter = painterResource(id = drawableResId),
      contentDescription = stringResource(id = stringResId)
    )
  }
}