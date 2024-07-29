package com.zaie.nunasurvei.model

object UserInfo {
  var username: String = "Lala"
  var score: Int = 0
  var senaraiBilanganSoalan: MutableList<Int> = MutableList(getSaizSoalan()) { 0 }

  private fun getSaizSoalan(): Int = SoalanSurvei.semuaSoalan.size
}