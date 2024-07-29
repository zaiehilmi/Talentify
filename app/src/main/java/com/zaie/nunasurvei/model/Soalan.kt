package com.zaie.nunasurvei.model

data class Soalan(
  val namaKemahiran: NamaKemahiran,
  val soalan: String,
  val rating: Int = 0
)
