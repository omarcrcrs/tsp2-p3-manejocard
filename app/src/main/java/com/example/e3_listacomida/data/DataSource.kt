package com.example.e3_listacomida.data

import com.example.e3_listacomida.R
import com.example.e3_listacomida.model.Platillo

class DataSource() {

    fun loadPlatillos(): List<Platillo> {
        return listOf(
            Platillo(R.string.desayuno, 85.0, 15, R.drawable.desayuno),
            Platillo(R.string.postre, 65.0, 10, R.drawable.postre),
            Platillo(R.string.pozole, 100.0, 30, R.drawable.pozole),
            Platillo(R.string.pizza, 180.0, 20, R.drawable.pizza),
            Platillo(R.string.tacos, 75.0, 25, R.drawable.tacos),
            Platillo(R.string.hamburger, 120.0, 15, R.drawable.hamburger)
        )
    }
}