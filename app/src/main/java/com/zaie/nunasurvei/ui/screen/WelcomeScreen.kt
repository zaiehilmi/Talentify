package com.zaie.nunasurvei.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.component.ZaieButton
import com.zaie.nunasurvei.ui.theme.ZaieColor

@Composable
fun WelcomeScreen() {
  Main()
}

@Composable
private fun Main() {
  Scaffold(
    containerColor = ZaieColor.surfaceFrozen,
    modifier = Modifier
      .fillMaxSize()
  ) { innerPadding ->
    Column(
      verticalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()
        .padding(top = 140.dp, bottom = 40.dp, start = 20.dp, end = 20.dp)
    ) {
      Greeting()
      BottomButton()
    }
  }
}

@Composable
private fun Greeting() {
  Column {
    Text(
      text = "Let's",
      style = typography.displaySmall
    )
    Text(
      text = "Talentify",
      style = typography
        .displayMedium
        .copy(
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.Monospace,
          color = ZaieColor.title
        )
    )
  }
}

@Composable
private fun BottomButton() {
  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    ZaieButton(
      title = "Login",
      isSecondary = true,
      onTap = {}
    )
    ZaieButton(
      title = "Register",
      onTap = {
//        ZaieNavHost().navigate(Destinasi.Register)
      }
    )
  }
}