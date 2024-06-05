package com.cfelo.taller_1.ui.components.task

import android.icu.text.DateFormatSymbols
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cfelo.taller_1.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskComponent() {
    var titulo: MutableState<String> = remember { mutableStateOf("") }
    var descripcion: MutableState<String> = remember { mutableStateOf("") }
    var fecha: MutableState<String> = remember { mutableStateOf("") }
    var isExpandedCategory by remember { mutableStateOf(false) }
    var categoria by remember { mutableStateOf("") }
    var isExpandedIcon by remember { mutableStateOf(false) }
    var icono by remember { mutableStateOf(R.drawable.baseline_add_task_24.toString()) }
    var iconoText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        Text(
            text = "Agregar nueva tarea",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Row {
            Column {
                Text(
                    text = "Titulo:", style = MaterialTheme.typography.titleMedium
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = titulo.value,
                    onValueChange = { titulo.value = it },
                    placeholder = { Text(text = "Lavar los platos") },
                )
            }

        }
        Row {
            Column {
                Text(
                    text = "Descripción:", style = MaterialTheme.typography.titleMedium
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    value = descripcion.value,
                    onValueChange = { descripcion.value = it },
                    placeholder = { Text(text = "Lavar todos los cubiertos, vasos y más") },
                )
            }

        }
        Row {
            Column {
                EndDateTextField { fecha.value = it }
            }
        }
        Row {
            Column {
                Text(
                    text = "Icono:", style = MaterialTheme.typography.titleMedium
                )
                ExposedDropdownMenuBox(expanded = isExpandedIcon, onExpandedChange = { newValue ->
                    isExpandedIcon = newValue
                }) {
                    TextField(
                        value = iconoText,
                        onValueChange = { iconoText = it },
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedIcon)
                        },
                        placeholder = {
                            Text(text = "Selecciona un ícono")
                        },
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(expanded = isExpandedIcon, onDismissRequest = {
                        isExpandedIcon = false
                    }) {
                        DropdownMenuItem(text = {
                            Text(text = "Casa")
                        }, onClick = {
                            iconoText = "Casa"
                            icono = R.drawable.baseline_house_24.toString()
                            isExpandedIcon = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Compras")
                        }, onClick = {
                            iconoText = "Compras"
                            icono = R.drawable.baseline_add_shopping_cart_24.toString()
                            isExpandedIcon = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Estudio")
                        }, onClick = {
                            iconoText = "Estudio"
                            icono = R.drawable.baseline_menu_book_24.toString()
                            isExpandedIcon = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Trabajo")
                        }, onClick = {
                            iconoText = "Trabajo"
                            icono = R.drawable.sharp_code_24.toString()
                            isExpandedIcon = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Otro")
                        }, onClick = {
                            iconoText = "Otro"
                            icono = R.drawable.baseline_description_24.toString()
                            isExpandedIcon = false
                        })
                    }
                }
            }
        }
        Row {
            Column {
                Text(
                    text = "Categoría:", style = MaterialTheme.typography.titleMedium
                )
                ExposedDropdownMenuBox(
                    expanded = isExpandedCategory,
                    onExpandedChange = { newValue ->
                        isExpandedCategory = newValue
                    }) {
                    TextField(
                        value = categoria,
                        onValueChange = { categoria = it },
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedCategory)
                        },
                        placeholder = {
                            Text(text = "Selecciona una categoria")
                        },
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(expanded = isExpandedCategory, onDismissRequest = {
                        isExpandedCategory = false
                    }) {
                        DropdownMenuItem(text = {
                            Text(text = "Universidad")
                        }, onClick = {
                            categoria = "Universidad"
                            isExpandedCategory = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Casa")
                        }, onClick = {
                            categoria = "Casa"
                            isExpandedCategory = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Trabajo")
                        }, onClick = {
                            categoria = "Trabajo"
                            isExpandedCategory = false
                        })
                        DropdownMenuItem(text = {
                            Text(text = "Other")
                        }, onClick = {
                            categoria = "Other"
                            isExpandedCategory = false
                        })
                    }
                }
            }

        }
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Añadir tarea")
                }


        }
    }
}


@Composable
fun EndDateTextField(endDate: (String) -> Unit) {
    Text(
        text = "Fecha Límite", style = MaterialTheme.typography.bodyLarge
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed: Boolean by interactionSource.collectIsPressedAsState()

    val currentDate = Date().toFormattedString()
    var selectedDate by rememberSaveable { mutableStateOf(currentDate) }

    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val DatePickerDialog = android.app.DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val newDate = Calendar.getInstance()
            newDate.set(year, month, dayOfMonth)
            selectedDate = "$dayOfMonth/$month/$year"
            endDate(selectedDate)
        }, year, month, day
    )

    TextField(
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        value = selectedDate,
        onValueChange = { selectedDate = it },
        trailingIcon = { Icons.Default.DateRange },
        interactionSource = interactionSource
    )

    if (isPressed) {
        DatePickerDialog.show()
    }
}

fun Int.toMonthName(): String {
    return DateFormatSymbols().months[this]
}

fun Date.toFormattedString(): String {
    val simpleDateFormat = SimpleDateFormat("dd/LL/yyyy", Locale.getDefault())
    return simpleDateFormat.format(this)
}

@Preview
@Composable
fun PreviewAddTask() {
    AddTaskComponent()
}