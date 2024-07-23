package com.zaie.nunasurvei.model

import com.zaie.nunasurvei.model.SoalanSurvei.skillMap

object UserInfo {
  var username: String = ""
  var score: Int = 0
  var senaraiBilanganSoalan: MutableList<Int> = MutableList(getTotalQuestionCount()) { 0 }

  private fun getTotalQuestionCount(): Int {
    var totalQuestions = 0
    for (questions in skillMap.values) {
      totalQuestions += questions.size
    }
    return totalQuestions
  }
}