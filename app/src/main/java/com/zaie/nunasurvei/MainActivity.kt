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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.component.ZaieButton
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme
import com.zaie.nunasurvei.ui.theme.surfaceFrozen

class MainActivity : ComponentActivity() {
  private val usernameTF = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      NunaSurveiTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
          containerColor = surfaceFrozen,
          modifier = Modifier
            .fillMaxSize()
        ) { innerPadding ->
          Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
              .padding(innerPadding)
              .fillMaxSize()
              .padding(vertical = 40.dp, horizontal = 20.dp)
          ) {
            Column {
              Text(
                text = "Let's",
                style = typography.displaySmall
              )
              Text(
                text = "Talentify",
                style = typography
                  .displayLarge
                  .copy(fontWeight = FontWeight.Bold)
              )
            }
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
                onTap = {}
              )
            }
          }

        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  NunaSurveiTheme {
    Greeting("Android")
  }
}