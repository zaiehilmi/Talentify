package com.zaie.nunasurvei.model

data class ModelSoalan(
  val namaKemahiran: NamaKemahiran,
  val soalan: String,
  var rating: Int? = null
)
