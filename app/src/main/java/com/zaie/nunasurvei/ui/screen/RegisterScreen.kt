package com.zaie.nunasurvei.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.ui.component.ZaieAppBar
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavController

@Composable
fun RegisterScreen(nav: NavController<Destinasi>) {
  Scaffold(
    topBar = { ZaieAppBar(nav, title = "Register") },
    containerColor = ZaieColor.surfaceFrozen,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .padding(it)
    ) {
      Text(text = "Register")
    }
  }
}