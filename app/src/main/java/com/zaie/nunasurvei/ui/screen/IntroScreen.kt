package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.R
import com.zaie.nunasurvei.screenTransitionSpec
import com.zaie.nunasurvei.ui.component.ZaieButton
import dev.olshevski.navigation.reimagined.AnimatedNavHost
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController

@Composable
fun IntroScreen() {
  val navController = navHost()

  AnimatedNavHost(
    controller = navController,
    transitionSpec = screenTransitionSpec
  ) { destination ->
    if (destination is Destinasi.Survey)
      SurveyScreen()
  }

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
    Column {
      Text(
        text = "Get ready to answer all of the questions",
        style = typography.titleLarge.copy(
          color = Color.Black,
        ),
        textAlign = TextAlign.Center
      )

      Spacer(modifier = Modifier.height(30.dp))

      ZaieButton(
        title = "Continue",
        onTap = {
          navController.navigate(Destinasi.Survey)
          Log.i("Intro", "Pergi menjawab soalan")
        },
        modifier = Modifier.fillMaxWidth()
      )
    }

  }
}

@Composable
private fun navHost(): NavController<Destinasi> {
  val navController = rememberNavController<Destinasi>(
    startDestination = Destinasi.Intro
  )

  NavBackHandler(controller = navController)

  return navController
}