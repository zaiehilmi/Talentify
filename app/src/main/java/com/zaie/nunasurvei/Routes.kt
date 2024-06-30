package com.zaie.nunasurvei

import android.os.Parcelable
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.togetherWith
import dev.olshevski.navigation.reimagined.NavAction
import dev.olshevski.navigation.reimagined.NavTransitionSpec
import kotlinx.parcelize.Parcelize

sealed class Destinasi : Parcelable {

  @Parcelize
  data object Welcome : Destinasi()

  @Parcelize
  data object Register : Destinasi()

  @Parcelize
  data object Login : Destinasi()
}

val transitionSpec = NavTransitionSpec<Destinasi> { action, from, to ->
  val arah = if (action == NavAction.Navigate) {
    AnimatedContentTransitionScope.SlideDirection.Left
  } else {
    AnimatedContentTransitionScope.SlideDirection.Right
  }

  slideIntoContainer(arah) togetherWith slideOutOfContainer(arah)
}