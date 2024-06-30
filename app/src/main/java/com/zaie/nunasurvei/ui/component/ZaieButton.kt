package com.zaie.nunasurvei.ui.component

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zaie.nunasurvei.ui.theme.NunaSurveiTheme
import com.zaie.nunasurvei.ui.theme.ZaieColor

data class ZaieButtonOption(
  val modifierz: Modifier,
  val typographyz: TextStyle
)

@Composable
fun ZaieButton(
  title: String = "title",
  isSecondary: Boolean = false,
  onTap: () -> Unit,
) {
  val buttonOption = ZaieButtonOption(
    modifierz = Modifier
      .height(60.dp)
      .width(130.dp),
    typographyz = typography
      .titleMedium
      .copy(fontWeight = FontWeight.SemiBold)
  )

  if (isSecondary)
    OutlinedButton(
      shape = RoundedCornerShape(18),
      border = ButtonDefaults.outlinedButtonBorder,
      modifier = buttonOption.modifierz,
      onClick = onTap
    ) {
      Text(
        text = title,
        style = buttonOption
          .typographyz
          .copy(color = ZaieColor.primaryButton)
      )
    }
  else Button(
    shape = RoundedCornerShape(18),
    colors = ButtonColors(
      containerColor = ZaieColor.primaryButton,
      contentColor = ZaieColor.surfaceFrozen,
      disabledContentColor = ZaieColor.primaryButton,
      disabledContainerColor = ZaieColor.inactive
    ),
    modifier = buttonOption.modifierz,
    onClick = onTap
  ) {
    Text(
      text = title,
      style = buttonOption.typographyz
    )
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
//  ZaieButton()
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
//        ZaieButton()
//        ZaieButton(isSecondary = true)
      }
    }

  }

}