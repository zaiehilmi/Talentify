package com.zaie.nunasurvei.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme
import com.zaie.nunasurvei.ui.theme.inactive
import com.zaie.nunasurvei.ui.theme.primaryButton
import com.zaie.nunasurvei.ui.theme.surfaceFrozen

@Composable
fun ZaieButton(isSecondary: Boolean = false) {
  if (isSecondary)
    OutlinedButton(
      shape = RoundedCornerShape(18),

      border = ButtonDefaults.outlinedButtonBorder,
      modifier = Modifier
        .height(80.dp)
        .width(160.dp),
      onClick = { /*TODO*/ }) {
      Text(
        text = "Login",
        style = typography
          .titleLarge
          .copy(fontWeight = FontWeight.Medium)
      )
    }
    else
  Button(
    shape = RoundedCornerShape(18),
    colors = ButtonColors(
      containerColor = primaryButton ,
      contentColor = surfaceFrozen,
      disabledContentColor = primaryButton,
      disabledContainerColor = inactive
    ),
    modifier = Modifier
      .height(80.dp)
      .width(160.dp),
    onClick = { /*TODO*/ }) {
    Text(
      text = "Login",
      style = typography
        .titleLarge
        .copy(fontWeight = FontWeight.Medium)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
  ZaieButton()
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonFull() {
  NunaSurveiTheme {
    Scaffold {
      Row(
        modifier = Modifier
          .padding(it)
          .padding(20.dp)
      ) {
        ZaieButton()
        ZaieButton(isSecondary = true)
      }
    }

  }

}