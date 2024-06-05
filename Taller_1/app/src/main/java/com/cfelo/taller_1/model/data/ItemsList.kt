package com.cfelo.taller_1.model.data

import com.cfelo.taller_1.R
import com.cfelo.taller_1.model.ItemDataModel

val ItemList = listOf<ItemDataModel>(
    ItemDataModel(
        "Limpiar el patio",
        "01/04/2024",
        true,
        R.drawable.baseline_house_24,
        "azul",
        "Sacar las hojas del patio, cortar las flores",
        "Casa"
    ),
    ItemDataModel(
        "Arreglar el cuarto",
        "02/04/2024",
        true,
        R.drawable.baseline_house_24,
        "morado",
        "01/01/2024",
        "Casa"
    ),
    ItemDataModel(
        "Trabajar en la app",
        "20/05/2024",
        false,
        R.drawable.sharp_code_24,
        "azul",
        "avanzar en el proeyecto en PDM",
        "Universidad"
    ),
    ItemDataModel(
        "Ir al super",
        "06/05/2024",
        false,
        R.drawable.baseline_add_shopping_cart_24,
        "verde",
        "hacer la compra de la semana",
        "Casa"
    )
)
