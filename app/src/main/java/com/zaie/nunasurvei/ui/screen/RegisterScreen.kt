package com.zaie.nunasurvei.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen() {
  Scaffold(modifier = Modifier.fillMaxSize()) {
    Text(text = "Register", modifier = Modifier.padding(it))

  }

}