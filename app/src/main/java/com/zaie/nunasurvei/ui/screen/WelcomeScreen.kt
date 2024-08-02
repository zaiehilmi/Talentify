package com.zaie.nunasurvei.ui.screen

import android.util.Log
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
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.popupTransitionSpec
import com.zaie.nunasurvei.screenTransitionSpec
import com.zaie.nunasurvei.ui.component.ZaieButton
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.AnimatedNavHost
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController


// MARK: Main
@Composable
fun WelcomeScreen() {
  val navController = navHost()

  AnimatedNavHost(
    controller = navController,
    transitionSpec = screenTransitionSpec
  ) { destinasi ->
    when (destinasi) {
      is Destinasi.Welcome -> Main(navController)
      is Destinasi.Register -> RegisterScreen(navController)
      is Destinasi.Intro -> IntroScreen(navController)
      is Destinasi.Question -> QuestionScreen(navController)
      is Destinasi.Result -> ResultScreen(navController)
      else -> {}
    }
  }
}

@Composable
private fun Main(nav: NavController<Destinasi>) {
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
        .padding(
          top = 140.dp,
          bottom = 40.dp,
          start = 20.dp,
          end = 20.dp
        )
    ) {
      Greeting()
      BottomButton(nav = nav)
    }
  }
}

// MARK: Component
@Composable
private fun Greeting() {
  Column {
    Text(
      text = "Let's",
      style = typography.displaySmall
    )
    Text(
      text = "talentify",
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
private fun BottomButton(nav: NavController<Destinasi>) {
  val navController = navHost()

  AnimatedNavHost(
    controller = navController,
    transitionSpec = popupTransitionSpec
  ) { destinasi ->
    if (destinasi is Destinasi.Login)
      LoginScreen(nav)
  }

  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxWidth()
  ) {
    ZaieButton(
      title = "Login",
      isSecondary = true,
      onTap = {
        navController.navigate(Destinasi.Login)
      }
    )
    ZaieButton(
      title = "Register",
      onTap = {
        Log.d("Main", "Pergi ke Register")
        nav.navigate(Destinasi.Register)
      }
    )
  }
}

@Composable
private fun navHost(): NavController<Destinasi> {
  val navController = rememberNavController<Destinasi>(
    startDestination = Destinasi.Welcome
  )

  NavBackHandler(controller = navController)

  return navController
}