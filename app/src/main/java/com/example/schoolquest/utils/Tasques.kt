package com.example.schoolquest.utils

data class Tasques(
    val Nom: String, val Desc: String, val Venc: String, val XP: String, val SP: String, val progress: Int) {

    companion object{
        fun crearTasca(): ArrayList<Tasques> {
            val tasques = ArrayList<Tasques>()
            tasques.add(Tasques(
                "Misio principal de mates", "Combat aquestes multiplicacions", "Data limit: 03/10", "150 XP", "25 SP", 56))
            tasques.add(Tasques(
                "Misio secundaria", "Multiplicacions opcionals", "Data limit: 03/10", "50 XP", "15 SP", 25))
            tasques.add(Tasques(
                "Misio de Castellà", "¿Te atreves a descubrir el sujeto?", "Data limit: 13/10", "150XP", "25 SP", 28))
            tasques.add(Tasques(
                "Misio d'angles", "The adventure starts!", "Data limit: 15/10", "170XP", "25 SP", 12))

            return tasques
        }
    }
}