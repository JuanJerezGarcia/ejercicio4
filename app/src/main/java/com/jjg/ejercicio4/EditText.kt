package com.jjg.ejercicio4

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var name by rememberSaveable { mutableStateOf("hola mundo") }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        TextField(value = name, onValueChange = { name = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField() {
    var name by rememberSaveable { mutableStateOf("hola mundo") }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "nombre") }
        )
    }
}

@Preview(
    showBackground = true,
    name = "P1",
    fontScale = 1.1f,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.NEXUS_6,
    backgroundColor = 10000000
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelAndPlaceHolderExample() {
    var address by remember { mutableStateOf("") }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        OutlinedTextField(
            value = address,
            onValueChange = {
                address = if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = { Text("Dirección") },
            placeholder = { Text("Donde vives") }
        )
    }
}