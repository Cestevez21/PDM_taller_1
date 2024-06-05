package com.cfelo.taller_1.ui.components.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cfelo.taller_1.R
import com.cfelo.taller_1.model.ItemDataModel

@Composable
fun ShowTaskComponent(item: ItemDataModel) {
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            text = "Tarea",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Row {
            Column (verticalArrangement = Arrangement.spacedBy(25.dp)) {

                Spacer(modifier = Modifier.width(32.dp))
                Text(
                    text = "Titulo: ${item.titulo}", style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text(
                    text = "Categoria: ${item.categoria}",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text(
                    text = "Descripción: ",
                    style = MaterialTheme.typography.titleMedium
                )
                item.descripcion?.let {
                    Text(
                        text = it, style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(modifier = Modifier.width(32.dp))
                Text(
                    text = "Fecha Límite: ${item.fecha}",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.width(32.dp))

            }

        }

        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Icon(
                painter = painterResource(item.icono),
                contentDescription = "TaskIcon"
            )
            if (item.estado){
                Icon(
                    painter = painterResource(R.drawable.baseline_beenhere_24),
                    contentDescription = "TaskIcon"
                )
            }
            else {
                Icon(
                    painter = painterResource(R.drawable.outline_beenhere_24),
                    contentDescription = "TaskIcon"
                )}
        }

    }
}


@Preview
@Composable
fun PreviewShowTaskComponent() {
    ShowTaskComponent( ItemDataModel(
        "Limpiar el patio",
        "01/04/2024",
        true,
        R.drawable.baseline_house_24,
        "azul",
        "Sacar las hojas del patio, cortar las flores",
        "Casa"
    ))
}