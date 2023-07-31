package com.example.myapp

fun main() {
    // Arac nesnesi oluşturma
    val arac = Arac(120, 7.5)
    arac.bilgileriGoster()

    // Otomobil nesnesi oluşturma
    val otomobil = Otomobil(160, 9.2, 500)
    otomobil.bilgileriGoster()
    otomobil.bagajAc()
}