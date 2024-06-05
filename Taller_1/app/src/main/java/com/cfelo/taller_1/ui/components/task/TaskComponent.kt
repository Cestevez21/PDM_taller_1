package com.cfelo.taller_1.ui.components.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cfelo.taller_1.R
import com.cfelo.taller_1.model.ItemDataModel


@Composable
fun Task(item: ItemDataModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .padding(top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Button(modifier = Modifier
                .background(color = Color.Transparent),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = { /*TODO*/ }) {
                Card{
                    Column (Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .padding(start = 16.dp)
                        .background(color = Color.Transparent)){
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(72.dp)
                                .padding(start = 16.dp)
                                .background(color = Color.Transparent),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Miniatura
                            Box(
                                modifier = Modifier
                                    .background(color = Color.Transparent, shape = CircleShape)
                                    .size(40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(item.icono),
                                    contentDescription = "TaskIcon"
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .background(color = Color.Transparent, shape = CircleShape)
                                    .size(40.dp),
                                contentAlignment = Alignment.Center
                            ) {

                            }
                            Column(
                                modifier = Modifier
                                    .width(120.dp)
                                    .background(color = Color.Transparent)
                            ) {

                                // Encabezado
                                Text(
                                    text = item.titulo,
                                    style = MaterialTheme.typography.labelMedium
                                )
                                // Subtítulo
                                Text(
                                    text = item.fecha,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                            Spacer(modifier = Modifier.width(32.dp))
                            if (item.estado) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_beenhere_24),
                                    contentDescription = "TaskIcon"
                                )
                            } else {
                                Icon(
                                    painter = painterResource(R.drawable.outline_beenhere_24),
                                    contentDescription = "TaskIcon"
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewTask() {
    Task(
        ItemDataModel(
            "Limpiar el patio",
            "01/04/2024",
            true,
            R.drawable.baseline_house_24,
            "azul",
            "Sacar las hojas del patio, cortar las flores",
            "Casa"
        )
    )
}