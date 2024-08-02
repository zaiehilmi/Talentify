package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.model.SoalanSurvei
import com.zaie.nunasurvei.screenTransitionSpec
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.AnimatedNavHost
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController

@Composable
fun QuestionScreen(
  nav: NavController<Destinasi>,
) {
  var indeksDipilih by remember { mutableStateOf<Int?>(null) }
  var soalannya by remember { mutableStateOf(SoalanSurvei.semuaSoalan[SoalanSurvei.indeksKedudukan]) }
  val navController = navHost()

  AnimatedNavHost(
    controller = navController,
    transitionSpec = screenTransitionSpec
  ) { destination ->
    if (destination is Destinasi.Result)
      ResultScreen(nav)
  }

  LaunchedEffect(SoalanSurvei.indeksKedudukan) {
    indeksDipilih = null
  }

  Surface(modifier = Modifier.background(ZaieColor.surfaceFrozen)) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 70.dp, start = 20.dp, end = 20.dp),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        soalannya.namaKemahiran.displayName,
        style = typography.titleMedium
      )
      Text(
        soalannya.soalan,
        style = typography.titleLarge,
        textAlign = TextAlign.Center
      )

      Column {
        RatingSection(indeksDipilih) { i ->
          indeksDipilih = i
        }

        Spacer(modifier = Modifier.height(10.dp))
        Navigation(onPrevious = {
          if (SoalanSurvei.indeksKedudukan > 0) {
            soalannya = SoalanSurvei.semuaSoalan[SoalanSurvei.indeksKedudukan]
            SoalanSurvei.indeksKedudukan--

            Log.i(
              "Rating",
              "Soalan ${SoalanSurvei.indeksKedudukan} dengan rating ${SoalanSurvei.semuaSoalan[SoalanSurvei.indeksKedudukan].rating}"
            )

            SoalanSurvei.semuaSoalan.forEach {
              Log.i(
                "Rating",
                "onPrev Soalan ${it.namaKemahiran.displayName} dengan rating ${it.rating}"
              )
            }
          } else {
            Log.d(
              "Navigasi",
              "Indeks sudah di ${SoalanSurvei.indeksKedudukan}. tak boleh ke skrin sebelumnya"
            )
          }
        },
          onNext = {
            val dahPilihRating = indeksDipilih != null

            if (SoalanSurvei.indeksKedudukan < SoalanSurvei.semuaSoalan.size) {
              if (dahPilihRating) {
                soalannya = SoalanSurvei.semuaSoalan[SoalanSurvei.indeksKedudukan]
                soalannya.rating = indeksDipilih!!.plus(1)

                SoalanSurvei.indeksKedudukan++

                Log.i(
                  "Rating",
                  "Soalan ${SoalanSurvei.indeksKedudukan} :: ${SoalanSurvei.semuaSoalan[SoalanSurvei.indeksKedudukan].rating}"
                )

                ++SoalanSurvei.indeksKedudukan
              }
            } else {
              Log.i("Navigasi", "Pergi ke result")
              Log.i("Rating", "${kiraSkor()}")
              nav.navigate(Destinasi.Result)
            }
          })
      }

    }
  }

}

@Composable
private fun RatingSection(indeksDipilih: Int?, onIndexChange: (Int?) -> Unit) {
  Column(
    verticalArrangement = Arrangement.Center,
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(text = "Strongly Disagree")
      Text(text = "Strongly Agree")
    }
    Spacer(modifier = Modifier.height(8.dp))
    RatingButtons(indeksDipilih, onIndexChange)
  }
}

@Composable
private fun RatingButtons(indeksDipilih: Int?, onIndexChange: (Int?) -> Unit) {
  val options = listOf(1, 2, 3, 4, 5)

  val chipColors = listOf(
    Color(0xFFE91E63), // Pink
    Color(0xFF9C27B0), // Purple
    Color(0xFF2196F3), // Blue
    Color(0xFF4CAF50), // Green
    Color(0xFFFFC107)  // Amber
  )

  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    options.forEachIndexed { index, option ->
      val isSelected = index == indeksDipilih
      val animatedSelected by animateDpAsState(
        targetValue = if (isSelected) 16.dp else 0.dp,
        label = "selectedAnimation"
      )

      ElevatedFilterChip(
        selected = isSelected,
        onClick = {
          Log.d("Rating", "RatingButtons: tekan $option")
          onIndexChange(if (isSelected) null else index)
        },
        label = {
          Text(
            text = "$option",
            color = if (isSelected) Color.Black else chipColors[index]
          )
        },
        leadingIcon = ratingButtonLeadingIcon(isSelected, animatedSelected)
      )
    }
  }
}

@Composable
private fun Navigation(onPrevious: () -> Unit, onNext: () -> Unit) {
  Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    TextButton(
      onClick = onPrevious
    ) {
      Text(text = "Previous")
    }


    TextButton(
      onClick = onNext
    ) {
      Text(text = "Next")
    }
  }
}

@Composable
private fun navHost(): NavController<Destinasi> {
  val navController = rememberNavController<Destinasi>(
    startDestination = Destinasi.Question
  )

  NavBackHandler(controller = navController)

  return navController
}

@Composable
private fun ratingButtonLeadingIcon(
  isSelected: Boolean,
  animatedSelected: Dp
): @Composable (() -> Unit)? = if (isSelected) {
  {
    Icon(
      imageVector = Icons.Filled.Done,
      contentDescription = "Done icon",
      modifier = Modifier.size(animatedSelected)
    )
  }
} else {
  null
}
