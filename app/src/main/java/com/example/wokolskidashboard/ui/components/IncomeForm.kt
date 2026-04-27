package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(

    onAddIncome: (name: String, amount: Double) -> Unit
) {

    var name by remember { mutableStateOf("") }
    var amountString by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Zysk ze sprzedaży")


        androidx.compose.material3.OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nazwa towaru (np. Parasol)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        androidx.compose.material3.OutlinedTextField(
            value = amountString,
            onValueChange = { amountString = it },
            label = { Text("Kwota (w rublach)") },
            modifier = Modifier.fillMaxWidth()
        )


        errorMessage?.let {
            Text(text = it, color = androidx.compose.ui.graphics.Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val amount = amountString.toDoubleOrNull() ?: 0.0


                if (name.isBlank()) {
                    errorMessage = "Nazwa towaru nie może być pusta!"
                } else if (amount <= 0) {
                    errorMessage = "Kwota musi być większa od zera!"
                } else {
                    errorMessage = null

                    onAddIncome(name, amount)


                    name = ""
                    amountString = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zapisz Zysk")
        }
    }
}