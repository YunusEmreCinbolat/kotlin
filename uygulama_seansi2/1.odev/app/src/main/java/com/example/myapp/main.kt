package com.example.myapp

fun main() {
    // Dikdörtgen nesnesi oluşturma
    val dikdortgen = Dikdortgen(5.0, 8.0)

    // Alanı ve çevreyi hesaplama
    val alan = dikdortgen.alanHesapla()
    val cevre = dikdortgen.cevreHesapla()

    println("Dikdörtgenin Alanı: $alan")
    println("Dikdörtgenin Çevresi: $cevre")
}