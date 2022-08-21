package com.fleichtweis.receitasdavo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receita(
    var titulo: String,
    var tempoPreparo: String,
    var resIdImagem: Int,
    var ingredientes: List<String>
) : Parcelable