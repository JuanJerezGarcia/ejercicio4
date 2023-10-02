package com.jjg.ejercicio4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true,
    name = "P1",
    fontScale = 1.1f,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.NEXUS_6
)

@Composable
fun MyText() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)) {
        Text(text = "Esto es un texto")
        Text(text = "Esto es un texto", color = Color.Blue)
        Text(text = "Esto es un texto", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un texto", fontWeight = FontWeight.Light)
        Text(text = "Esto es un texto", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es un texto", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es un texto", textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es un texto", textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )
        )
        Text(text = "Esto es un texto", fontSize = 20.sp)
        Text(stringResource(R.string.miTextoxml)) //relacionar un string que tenemos en la carpeta de values de recurso
        Text(stringResource(R.string.format_string_res,2), fontSize = 10.em) //pasa el argumento 2 para ponerlo en el texto

        for (item in stringArrayResource(R.array.string_array_res)){
            Text(item)
        }

        //añadir una fuente personalizada
        val besleyFontFamily = FontFamily(
            Font(R.font.besley_regular,FontWeight.Normal)
        )
        Text(text = "Besley Normal", fontFamily = besleyFontFamily, fontWeight = FontWeight.Normal)

        //Crear un estilo y colocarlo en un texto
        val styles= listOf(
            AnnotatedString.Range(SpanStyle(Color.Green, fontSize = 24.sp),0,5),
            AnnotatedString.Range(SpanStyle(Color.Blue, fontSize = 16.sp),5,9),
            AnnotatedString.Range(SpanStyle(Color.Red, fontSize = 12.sp),9,19)
        )
        Text(AnnotatedString("IES Punta del Verde",styles))
    }
}