package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.model.SoalanSurvei
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavController

@Composable
fun ResultScreen(nav: NavController<Destinasi>) {
  SoalanSurvei.semuaSoalan.forEach {
    Log.d(
      "Rating",
      "onNext Soalan ${it.soalan} dengan rating ${it.rating}"
    )
  }
  Surface(modifier = Modifier.background(ZaieColor.surfaceFrozen)) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 70.dp, start = 20.dp, end = 20.dp),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Thank you for taking the survey!",
          style = typography.headlineLarge,
          textAlign = TextAlign.Center,
          fontWeight = FontWeight.SemiBold,
          color = ZaieColor.title
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "Your results have been saved.")
      }

      Column(
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(text = "Your score is")
        Spacer(modifier = Modifier.height(18.dp))
        Text(
          text = "${kiraSkor()}",
          style = typography.headlineLarge,
          color = Color.DarkGray,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}

fun kiraSkor(): Int {
  return SoalanSurvei.semuaSoalan.sumOf { it.rating ?: 0 }
}