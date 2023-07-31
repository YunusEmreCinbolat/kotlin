package com.example.myapp

open class Arac(val hiz: Int, val yakitTuketimi: Double) {
    fun bilgileriGoster() {
        println("Hız: $hiz km/sa")
        println("Yakıt Tüketimi: $yakitTuketimi lt/100km")
    }
}
