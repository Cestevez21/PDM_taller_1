package com.cfelo.taller_1.model.data

enum class Category {
    Casa,
    Trabajo,
    Ocio,
    Universidad
}
fun getCategoryList(): List<Category> {
    val recurrenceList = mutableListOf<Category>()
    recurrenceList.add(Category.Casa)
    recurrenceList.add(Category.Trabajo)
    recurrenceList.add(Category.Ocio)
    recurrenceList.add(Category.Universidad)

    return recurrenceList
}