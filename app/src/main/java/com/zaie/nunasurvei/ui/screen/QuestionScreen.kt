package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.theme.ZaieColor

@Composable
fun QuestionScreen(
  question: String,
  onOptionSelected: (String) -> Unit
) {

  Surface(modifier = Modifier.background(ZaieColor.surfaceFrozen)) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 70.dp, start = 20.dp, end = 20.dp),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        "Internet Skills",
        style = typography.titleMedium
      )
      Text(
        question,
        style = typography.titleLarge,
        textAlign = TextAlign.Center
      )

      RatingSection()

    }
  }

}

@Composable
private fun RatingSection() {
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
    RatingButtons()
  }
}

@Composable
private fun RatingButtons() {
  val options = listOf("1", "2", "3", "4", "5")

  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    options.forEach { option ->
      Button(onClick = {
        Log.i("Soalan", "Pilihan: $option")
      }) {
        Text(text = option)
      }
    }
  }
}

@Preview
@Composable
private fun PreviewQuestionScreen() {
  QuestionScreen(
    question = "Do you think the ability to effectively use search engines is essential for employees in the manufacturing industry?",
    onOptionSelected = {}
  )
}