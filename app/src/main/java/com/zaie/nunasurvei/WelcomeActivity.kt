package com.zaie.nunasurvei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme
import com.zaie.nunasurvei.ui.theme.inactive
import com.zaie.nunasurvei.ui.theme.primaryButton
import com.zaie.nunasurvei.ui.theme.surfaceFrozen

class WelcomeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    setContent {
      NunaSurveiTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
              .padding(innerPadding)
              .fillMaxSize()
          ) {
            Text(text = "Let's do survey", style = typography.displayLarge)

            Row {
              Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
              }
              Button(onClick = { /*TODO*/ }) {
                Text(text = "Register")
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
  NunaSurveiTheme {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
      Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .padding(innerPadding)
          .fillMaxSize()
          .padding(horizontal = 20.dp, vertical = 30.dp)
      ) {
        Text(text = "Let's do survey",
          style = typography
            .displayLarge
            .copy(fontWeight = FontWeight.Bold))

        Row(horizontalArrangement = Arrangement.SpaceBetween,
          modifier = Modifier.fillMaxWidth()) {
          Button(
            shape = ButtonDefaults.outlinedShape,
            colors = ButtonColors(
              containerColor = primaryButton,
              contentColor = surfaceFrozen,
              disabledContentColor = primaryButton,
              disabledContainerColor = inactive
            ),
            modifier = Modifier
              .height(80.dp)
              .width(160.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Login", style = typography.titleLarge)
          }
          Button(onClick = { /*TODO*/ },  modifier = Modifier
            .height(80.dp)
            .width(160.dp),) {
            Text(text = "Register")
          }
        }
      }
    }
  }
}