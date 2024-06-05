package com.cfelo.taller_1.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.cfelo.taller_1.ui.components.task.Task
import com.cfelo.taller_1.model.data.ItemList

@Composable
fun HomeScreen (innerPadding: Dp){
    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(ItemList) { postItem ->
                Task(postItem)
            }
        }
    }

}

