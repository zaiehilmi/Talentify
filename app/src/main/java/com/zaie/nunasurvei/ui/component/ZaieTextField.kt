package com.zaie.nunasurvei.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.theme.ZaieColor

@Composable
fun ZaieTextField(
  label: String = "Lala Label",
  state: MutableState<TextFieldValue>,
  placeholder: String = "",
  isObscure: Boolean = false
) {
  val visualTransformation = if (isObscure) {
    PasswordVisualTransformation()
  } else {
    VisualTransformation.None
  }

  val outlineColor by remember {
    mutableStateOf(Color(0xff000000))
  }

  Column {
    Text(
      text = label,
      style = typography.labelLarge,
      color = ZaieColor.title
    )
    Spacer(modifier = Modifier.height(5.dp))
    OutlinedTextField(
      value = state.value,
      onValueChange = {
        state.value = it
      },
      visualTransformation = visualTransformation,
      shape = CircleShape,
      singleLine = true,
      placeholder = { Text(text = placeholder) },
      modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth()
    )
  }
}

@Composable
fun SpacingBetweenTextField() {
  Spacer(modifier = Modifier.height(25.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewTextField() {
  Column {
//    ZaieTextField(state = "lala placeholder",)
//    ZaieTextField(state = "lala placeholder")
  }
}