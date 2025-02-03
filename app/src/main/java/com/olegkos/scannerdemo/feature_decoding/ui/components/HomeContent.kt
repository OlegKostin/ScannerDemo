package com.olegkos.scannerdemo.feature_decoding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.olegkos.scannerdemo.R

@Composable
fun HomeContent(
  modifier: Modifier = Modifier,
  value: String,
  label: String,
  onValueChange: (string: String) -> Unit
) {

  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.SpaceAround
  ) {
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactored_type,
      stringResId = R.string.manufactored_type_image,
      title = "Type"/*TODO*/
    )
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactor_location,
      stringResId = R.string.manufactored_location_image,
      title = "Location"/*TODO*/
    )
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactored_date,
      stringResId = R.string.manufactored_date_image,
      title = "Date"/*TODO*/
    )

    SerialTextField(
      modifier = modifier,
      value = value,
      label = label,
      onValueChange = onValueChange
    )
  }
}

@Composable
fun ManufactureItem(
  modifier: Modifier = Modifier,
  @DrawableRes drawableResId: Int,
  @StringRes stringResId: Int,
  title: String
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    ManufactureIcon(
      modifier = modifier,
      drawableResId = drawableResId,
      contentDescriptionStringResId = stringResId,
    )
    ManufactureTitle(
      modifier = modifier,
      title = title
    )
  }
}

@Composable
fun ManufactureIcon(
  modifier: Modifier = Modifier,
  @DrawableRes drawableResId: Int,
  @StringRes contentDescriptionStringResId: Int
) {
  Icon(
    modifier = modifier,
    painter = painterResource(id = drawableResId),
    contentDescription = stringResource(id = contentDescriptionStringResId)
  )
}

@Composable
fun ManufactureTitle(
  modifier: Modifier = Modifier,
  title: String
) {
  Text(modifier = modifier, text = title, style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun SerialTextField(
  modifier: Modifier = Modifier,
  value: String,
  label: String,
  onValueChange: (string: String) -> Unit
) {
  TextField(
    value = value, label = { Text(text = label) }, onValueChange = onValueChange,
  )

}