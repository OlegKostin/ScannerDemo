package com.olegkos.scannerdemo.feature_decoding.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.olegkos.scannerdemo.R
import com.olegkos.scannerdemo.core.util.DOUBLE_SPACING
import com.olegkos.scannerdemo.feature_decoding.data.entity.ProductEntity

@Composable
fun HomeContent(
  modifier: Modifier = Modifier,
  value: String,
  productEntity: ProductEntity,
  onValueChange: (string: String) -> Unit
) {

  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactored_type,
      stringResId = R.string.manufactored_type_image,
      title = stringResource(R.string.type_with_value, productEntity.type)
    )
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactor_location,
      stringResId = R.string.manufactored_location_image,
      title = stringResource(R.string.made_in, productEntity.country)
    )
    ManufactureItem(
      modifier = modifier,
      drawableResId = R.drawable.ic_manufactored_date,
      stringResId = R.string.manufactored_date_image,
      title = productEntity.date
    )

    SerialTextField(
      modifier = modifier,
      value = value,
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
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    ManufactureImage(
      modifier = modifier.weight(0.4f),
      drawableResId = drawableResId,
      contentDescriptionStringResId = stringResId,
    )
    ManufactureTitle(
      modifier = modifier.weight(0.6f),
      title = title
    )
  }
}

@Composable
fun ManufactureImage(
  modifier: Modifier = Modifier,
  @DrawableRes drawableResId: Int,
  @StringRes contentDescriptionStringResId: Int
) {
  Image(
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
  Text(
    modifier = modifier, text = title, style = MaterialTheme.typography.displayMedium,
    textAlign = TextAlign.Center
  )
}

@Composable
fun SerialTextField(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (string: String) -> Unit
) {
  OutlinedTextField(
    modifier = modifier
      .padding(DOUBLE_SPACING)
      .fillMaxWidth(),
    value = value,
    label = { Text(text = stringResource(R.string.insert_serial_number)) },
    onValueChange = onValueChange,
  )

}