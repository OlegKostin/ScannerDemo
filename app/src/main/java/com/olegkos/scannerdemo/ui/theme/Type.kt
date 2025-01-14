package com.olegkos.scannerdemo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.olegkos.scannerdemo.R

val Oswald = FontFamily(
  Font(R.font.oswald_regular, FontWeight.Normal),
  Font(R.font.oswald_bold, FontWeight.Bold)
)
// Set of Material typography styles to start with
// Set of Material typography styles to start with
val Typography = Typography(
  displayLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontFamily = Oswald,
    fontSize = 32.sp
  ),
  displayMedium = TextStyle(
    fontWeight = FontWeight.Normal,
    fontFamily = Oswald,
    fontSize = 32.sp
  ),
  headlineLarge = TextStyle(
    fontFamily = Oswald, fontSize = 20.sp,
    fontWeight = FontWeight.Normal
  ),
  bodyLarge = TextStyle(
    fontFamily = Oswald,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  labelLarge = TextStyle(
    fontFamily = Oswald,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  titleMedium = TextStyle(
    fontFamily = Oswald,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
  ),
  /* Other default text styles to override
  labelSmall = TextStyle(
      fontFamily = FontFamily.Default,
      fontWeight = FontWeight.Normal,
      fontSize = 12.sp,
      lineHeight = 16.sp
  )
  */
)