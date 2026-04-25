package com.example.wokolskidashboard.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.wokolskidashboard.model.Transaction

@Composable
fun MainScreen() {

    val transactions = remember { mutableStateListOf<Transaction>() }

}