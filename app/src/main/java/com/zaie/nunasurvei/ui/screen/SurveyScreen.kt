package com.zaie.nunasurvei.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.zaie.nunasurvei.utils.bacaJson

@Composable
fun SurveyScreen() {
  val surveyQuestions = rememberCoroutineScope().run {
    bacaJson(LocalContext.current)
  }

  // Gunakan surveyQuestions untuk memaparkan soalan-soalan survey
  surveyQuestions.forEachIndexed { index, question ->
    QuestionScreen(
      question = question.question,
      onOptionSelected = { selectedOption ->
        // Lakukan sesuatu dengan pilihan yang dipilih
      }
    )
  }
}