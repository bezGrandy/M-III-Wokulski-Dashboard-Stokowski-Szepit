package com.example.wokolskidashboard.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseForm(
    onAddExpense: (String, Double, String, Boolean) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Wydatki Osobiste") }
    var isNecessary by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Dodaj Wydatek", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Cel wydatku") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Kwota") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}