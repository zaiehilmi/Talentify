package com.zaie.nunasurvei

import android.os.Parcelable
import androidx.compose.runtime.Composable
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.rememberNavController
import kotlinx.parcelize.Parcelize

sealed class Destinasi : Parcelable {

  @Parcelize
  data object Welcome : Destinasi()

  @Parcelize
  data object Register : Destinasi()
}

@Composable
fun ZaieNavHost() {
  val navController = rememberNavController<Destinasi>(
    startDestination = Destinasi.Welcome
  )

  NavBackHandler(controller = navController)

  NavHost(navController) { destination ->
    when (destination) {
      is Destinasi.Welcome -> MainActivity()
      is Destinasi.Register -> RegisterActivity()
    }
  }
}