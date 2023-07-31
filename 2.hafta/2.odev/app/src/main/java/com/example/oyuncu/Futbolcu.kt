package com.example.oyuncu

class Futbolcu: Oyuncu() {
    var gol_sayisi=0
    var gol_girisimi=0
    override fun oyna() {
        println("Futbolcu oynuyor")
    }
}