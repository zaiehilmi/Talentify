package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.model.NamaKemahiran
import com.zaie.nunasurvei.model.Soalan
import com.zaie.nunasurvei.ui.theme.ZaieColor

@Composable
fun QuestionScreen(
  soalan: Soalan,
  onOptionSelected: (String) -> Unit
) {
  var indeksDipilih by remember { mutableStateOf<Int?>(null) }

  Surface(modifier = Modifier.background(ZaieColor.surfaceFrozen)) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 70.dp, start = 20.dp, end = 20.dp),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        soalan.namaKemahiran.displayName,
        style = typography.titleMedium
      )
      Text(
        soalan.soalan,
        style = typography.titleLarge,
        textAlign = TextAlign.Center
      )

      RatingSection(indeksDipilih) { i ->
        indeksDipilih = i
      }

    }
  }

}

@Composable
private fun RatingSection(indeksDipilih: Int?, onIndexChange: (Int?) -> Unit) {
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
    RatingButtons(indeksDipilih, onIndexChange)
    Spacer(modifier = Modifier.height(10.dp))
    Navigation(indeksDipilih)
  }
}

@Composable
private fun RatingButtons(indeksDipilih: Int?, onIndexChange: (Int?) -> Unit) {
  val options = listOf(1, 2, 3, 4, 5)

  val chipColors = listOf(
    Color(0xFFE91E63), // Pink
    Color(0xFF9C27B0), // Purple
    Color(0xFF2196F3), // Blue
    Color(0xFF4CAF50), // Green
    Color(0xFFFFC107)  // Amber
  )

  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround
  ) {
    options.forEachIndexed { index, option ->
      val isSelected = index == indeksDipilih
      val animatedSelected by animateDpAsState(
        targetValue = if (isSelected) 16.dp else 0.dp,
        label = "selectedAnimation"
      )

      ElevatedFilterChip(
        selected = isSelected,
        onClick = {
          Log.d("Rating", "RatingButtons: tekan $option")
          onIndexChange(if (isSelected) null else index)
        },
        label = {
          Text(
            text = "$option",
            color = if (isSelected) Color.Black else chipColors[index]
          )
        },
        leadingIcon = ratingButtonLeadingIcon(isSelected, animatedSelected)
      )
    }
  }
}

@Composable
private fun Navigation(indeksDipilih: Int?) {
  val nilaiDipilih = indeksDipilih?.plus(1)

  Row(
    Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    TextButton(
      onClick = {
      }
    ) {
      Text(text = "Previous")
    }
    TextButton(
      onClick = {
        Log.d("Rating", "nilai $nilaiDipilih get last index")
      }
    ) {
      Text(text = "Next")
    }
  }
}

@Composable
private fun ratingButtonLeadingIcon(
  isSelected: Boolean,
  animatedSelected: Dp
): @Composable (() -> Unit)? = if (isSelected) {
  {
    Icon(
      imageVector = Icons.Filled.Done,
      contentDescription = "Done icon",
      modifier = Modifier.size(animatedSelected)
    )
  }
} else {
  null
}

@Preview
@Composable
private fun PreviewQuestionScreen() {
  QuestionScreen(
    soalan = Soalan(NamaKemahiran.AI_SKILLS, "Lala"),
    onOptionSelected = {}
  )
}