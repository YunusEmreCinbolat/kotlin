package com.example.random

import kotlin.random.Random
import java.util.Scanner
fun main() {
    val girdi=Scanner(System.`in`)
    println("KAC KEZ GIRILECEK")
    val maxTries = girdi.nextInt() // Belirli bir sayıda tahmin hakkı

    val randomNumber = Random.nextInt(1, 101) // 1 ile 100 arasında rasgele sayı seç

    println("1 ile 100 arasında bir sayı seçildi. $maxTries tahmin hakkınız var.")

    var remainingTries = maxTries

    while (remainingTries > 0) {
        print("Tahmininizi yapın: ")
        val userGuess = readLine()?.toIntOrNull()

        if (userGuess == null) {
            println("Geçersiz giriş. Lütfen bir tamsayı girin.")
            continue
        }

        if (userGuess == randomNumber) {
            println("Tebrikler, doğru tahmin ettiniz! Seçilen sayı: $randomNumber")
            break
        } else if (userGuess < randomNumber) {
            println("Daha büyük bir sayı girin. Kalan tahmin hakkınız: ${remainingTries - 1}")
        } else {
            println("Daha küçük bir sayı girin. Kalan tahmin hakkınız: ${remainingTries - 1}")
        }

        remainingTries--
    }

    if (remainingTries == 0) {
        println("Tahmin hakkınız bitti. Seçilen sayı: $randomNumber")
    }
}
