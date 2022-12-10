package com.example.schoolquest.utils

data class Recompenses(
    val Nom: String, val Preu: Int) {

    companion object{
        fun crearRecompenses(): ArrayList<Recompenses> {
            val recompenses = ArrayList<Recompenses>()
            recompenses.add(Recompenses(
                "+5 minuts de descans", 1000))
            recompenses.add(Recompenses(
                "+10 minuts de descans", 2000))
            recompenses.add(Recompenses(
                "Llapis nous", 100))
            recompenses.add(Recompenses(
                "Bolígrafs nous", 200))
            recompenses.add(Recompenses(
                "Rotuladors nous", 300))
            recompenses.add(Recompenses(
                "Estoig nou", 500))
            recompenses.add(Recompenses(
                "Llaminadures petites", 450))

            return recompenses
        }
    }
}