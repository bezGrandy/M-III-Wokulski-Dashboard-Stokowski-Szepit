package com.example.wokulskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(transaction: Transaction) {

    val isExpense = transaction.isExpense

    val color = if (isExpense)
        MaterialTheme.colorScheme.error
    else
        MaterialTheme.colorScheme.primary

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = transaction.name,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = if (isExpense) "Wydatek" else "Przychód",
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Text(
                text = if (isExpense)
                    "-%.2f".format(transaction.amount)
                else
                    "+%.2f".format(transaction.amount),
                color = color,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}