package com.example.schoolquest.utils

data class Correccions(
    val Nom: String, val Corregit: Boolean) {

    companion object{
        fun crearCorreccions(): ArrayList<Correccions> {
            val exits = ArrayList<Correccions>()
            exits.add(Correccions(
            "Brian Camps", false))
            exits.add(Correccions(
                "Aitor Perez", true))
            exits.add(Correccions(
                "Carlos Lopez", true))
            exits.add(Correccions(
                "Victor Giner", true))
            exits.add(Correccions(
                "Andrea Bamo", true))
            exits.add(Correccions(
                "Elisa Casas", true))
            exits.add(Correccions(
                "Noelia Arenas", false))
            exits.add(Correccions(
                "Christian Victoria", true))

            return exits
        }
    }
}