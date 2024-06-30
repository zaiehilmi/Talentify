package com.zaie.nunasurvei.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.pop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZaieAppBar(
  nav: NavController<Destinasi>,
  enableBackButton: Boolean = true,
  title: String
) {
  TopAppBar(
    colors = TopAppBarColors(
      containerColor = ZaieColor.surfaceFrozen,
      titleContentColor = ZaieColor.title,
      actionIconContentColor = ZaieColor.title,
      navigationIconContentColor = Color.Black,
      scrolledContainerColor = ZaieColor.surfaceFrozen
    ),
    title = {
      Text(
        text = title,
        style = typography
          .titleLarge
          .copy(fontWeight = FontWeight.SemiBold)
      )
    },
    navigationIcon = {
      if (enableBackButton)
        IconButton(onClick = {
          nav.pop()
        }) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back"
          )
        }
    }
  )
}