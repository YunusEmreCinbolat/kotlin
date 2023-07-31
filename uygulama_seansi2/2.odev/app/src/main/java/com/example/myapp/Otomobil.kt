package com.example.myapp

class Otomobil(hiz: Int, yakitTuketimi: Double, val bagajHacmi: Int) : Arac(hiz, yakitTuketimi) {
    fun bagajAc() {
        println("Bagaj açıldı.")
    }
}
