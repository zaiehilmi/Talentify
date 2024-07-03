package com.zaie.nunasurvei.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.ui.component.SpacingBetweenTextField
import com.zaie.nunasurvei.ui.component.ZaieButton
import com.zaie.nunasurvei.ui.component.ZaieTextField
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.navigate

/// Login ni attach dengan welcome screen. means dia tak gi screen baru
@Composable
fun LoginScreen(nav: NavController<Destinasi>) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .padding(top = 120.dp, start = 10.dp, end = 10.dp)
      .background(ZaieColor.surfaceFrozen)
  ) {
    Column(
      verticalArrangement = Arrangement.SpaceAround,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)
    ) {
      CredentialTextFields()

      ZaieButton(
        title = "Login",
        modifier = Modifier.fillMaxWidth()
      ) {
        Log.d("Navigate", "Nak pergi buat survey")
        nav.navigate(Destinasi.Intro)
      }
    }
  }
}

@Composable
private fun CredentialTextFields() {
  val usernameTF by remember { mutableStateOf(TextFieldValue("")) }

  Column {
    ZaieTextField(
      label = "Username",
      state = remember { mutableStateOf(usernameTF) }
    )
    SpacingBetweenTextField()
    ZaieTextField(
      isObscure = true,
      label = "Password",
      state = remember { mutableStateOf(usernameTF) }
    )
  }
}