package com.zaie.nunasurvei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zaie.nunasurvei.ui.screen.WelcomeScreen
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      NunaSurveiTheme {
        // A surface container using the 'background' color from the theme
        WelcomeScreen()
      }
    }
  }
}


