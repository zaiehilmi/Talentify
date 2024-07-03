package com.zaie.nunasurvei.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.R
import com.zaie.nunasurvei.ui.theme.ZaieColor

@Composable
fun IntroScreen() {
  Column(
    verticalArrangement = Arrangement.SpaceAround,
    modifier = Modifier
      .fillMaxSize()
      .padding(20.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.forms_illustration),
      contentScale = ContentScale.Fit,
      contentDescription = "My Image Description",
    )
    Text(
      text = "Get Ready to answer all of the questions",
      style = typography.displaySmall.copy(color = ZaieColor.title),
      textAlign = TextAlign.Center
    )

  }
}

@Composable
private fun navHostController() {

}