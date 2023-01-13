package com.squest.schoolquest.utils

data class Alumnes(
    val Nom: String) {

    companion object{
        fun crearAlumnes(): ArrayList<Alumnes> {
            val alumne = ArrayList<Alumnes>()
            alumne.add(Alumnes(
                "Brian Camps"))
            alumne.add(Alumnes(
                "Victor Lopez"))
            alumne.add(Alumnes(
                "Ian Hernandez"))
            alumne.add(Alumnes(
                "Alex Turull"))
            alumne.add(Alumnes(
                "Pablo Jimenez"))
            alumne.add(Alumnes(
                "Ricard Camí"))

            return alumne
        }
    }
}