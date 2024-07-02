package com.zaie.nunasurvei.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.Destinasi
import com.zaie.nunasurvei.ui.component.ZaieAppBar
import com.zaie.nunasurvei.ui.component.ZaieButton
import com.zaie.nunasurvei.ui.component.ZaieTextField
import com.zaie.nunasurvei.ui.theme.ZaieColor
import dev.olshevski.navigation.reimagined.NavController
import dev.olshevski.navigation.reimagined.pop

@Composable
fun RegisterScreen(nav: NavController<Destinasi>) {
  Scaffold(
    topBar = { ZaieAppBar(nav, title = "Register") },
    containerColor = ZaieColor.surfaceFrozen,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Column(
      horizontalAlignment = Alignment.End,
      modifier = Modifier
        .padding(it)
        .padding(horizontal = 20.dp, vertical = 40.dp)
    ) {
      Body(nav)
    }
  }
}

@Composable
private fun Body(nav: NavController<Destinasi>) {
  // tak jadi
  val nicknameTF by remember { mutableStateOf(TextFieldValue("")) }
  val usernameTF by remember { mutableStateOf(TextFieldValue("")) }

  val context = LocalContext.current

  ZaieTextField(
    label = "Nickname",
    placeholder = "Enter your nickname",
    state = remember { mutableStateOf(nicknameTF) }
  )
  Spacer(modifier = Modifier.height(25.dp))
  ZaieTextField(
    label = "Username",
    placeholder = "Enter your Username",
    state = remember { mutableStateOf(usernameTF) }
  )
  Spacer(modifier = Modifier.height(25.dp))
  ZaieTextField(
    label = "Password",
    placeholder = "Enter your password",
    state = remember { mutableStateOf(usernameTF) },
    isObscure = true
  )
  Spacer(modifier = Modifier.height(100.dp))
  ZaieButton(
    modifier = Modifier.fillMaxWidth(),
    title = "Register",
    onTap = {
      nav.pop()
      Toast
        .makeText(
          context,
          "You have successfully registered!",
          Toast.LENGTH_SHORT
        ).show()
    })
}