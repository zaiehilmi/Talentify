package com.zaie.nunasurvei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.component.ZaieButton
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.rememberNavController

class MainActivity : ComponentActivity() {
  private val usernameTF = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      NunaSurveiTheme {
        // A surface container using the 'background' color from the theme
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

@Composable
fun NavHostScreen() {

}
