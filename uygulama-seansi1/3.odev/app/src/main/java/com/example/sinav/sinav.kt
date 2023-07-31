package com.example.sinav

fun main() {
    print("Sınav notunuzu girin: ")
    val examGrade = readLine()?.toIntOrNull()

    if (examGrade == null) {
        println("Geçersiz giriş. Lütfen geçerli bir sayı girin.")
    } else {
        val message = if (examGrade >= 70) {
            "Geçtiniz"
        } else {
            "Kaldınız"
        }

        println(message)
    }
}
