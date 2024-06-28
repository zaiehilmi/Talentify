package com.zaie.nunasurvei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.component.ZaieTextField
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
          ) { _ ->
            Column(
              verticalArrangement = Arrangement.SpaceBetween,
              modifier = Modifier
                .padding(vertical = 60.dp, horizontal = 20.dp)
            ) {
              Text(
                text = "Let's do survey!",
                style = typography
                  .displayMedium
                  .copy(fontWeight = FontWeight.Medium)
              )
              Column {
                ZaieTextField(
                  label = "Username",
                  placeholder = "username",
                  state = usernameTF
                )
                ZaieTextField(
                  label = "Password",
                  placeholder = "password",
                  state = usernameTF
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