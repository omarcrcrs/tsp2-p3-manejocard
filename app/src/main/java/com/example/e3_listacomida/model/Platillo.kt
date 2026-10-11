package com.example.e3_listacomida.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val nombreResId: Int,
    val precio: Double,
    val descuento: Int,
    @DrawableRes val imagenResId: Int
)