package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.TransactionCard

@Composable
fun MainScreen() {

    val transactions = remember { mutableStateListOf<Transaction>() }

    val balance = transactions.sumOf { transaction ->
        if (transaction.isExpense) -transaction.amount else transaction.amount
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Saldo: %.2f Rubli".format(balance),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .statusBarsPadding()
                .padding(16.dp)
        )

        ExpenseForm(
            onAddExpense = { name, amount, category, isNecessary ->
                transactions.add(
                    Transaction("$name ($category)", amount, true)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(transactions) {
                TransactionCard(it)
            }
        }
    }
}