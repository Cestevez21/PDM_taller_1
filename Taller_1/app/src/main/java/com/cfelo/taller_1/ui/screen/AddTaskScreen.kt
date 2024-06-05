package com.cfelo.taller_1.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cfelo.taller_1.ui.components.task.AddTaskComponent

@Composable
fun AddTaskScreen () {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AddTaskComponent()
    }
}

@Preview
@Composable
fun PreviewAddTaskScreen(){
    AddTaskScreen()
}