package com.squest.schoolquest.utils

data class Exits(
    val Nom: String, val Completat: Boolean) {

    companion object{
        fun crearExits(): ArrayList<Exits> {
            val exits = ArrayList<Exits>()
            exits.add(Exits(
            "Completa una tasca", true))
            exits.add(Exits(
                "Completa 10 tasques", true))
            exits.add(Exits(
                "Completa 10 tasques opcionals", true))
            exits.add(Exits(
                "Completa 20 tasques", true))
            exits.add(Exits(
                "Completa 20 tasques opcionals", true))
            exits.add(Exits(
                "Completa 30 tasques", true))
            exits.add(Exits(
                "Completa 30 tasques opcionals", false))
            exits.add(Exits(
                "Completa 40 tasques", true))
            exits.add(Exits(
                "Completa 40 tasques opcionals", false))
            exits.add(Exits(
                "Completa 50 tasques", true))
            exits.add(Exits(
                "Completa 50 tasques opcionals", false))
            exits.add(Exits(
                "Completa 100 tasques", false))
            exits.add(Exits(
                "Completa 150 tasques", false))

            return exits
        }
    }
}