package com.example.main

fun main() {
    print("Bir ay ismi girin: ")
    val month = readLine()?.trim()?.toLowerCase()

    if (month == null || month.isEmpty()) {
        println("Geçersiz giriş. Lütfen bir ay ismi girin.")
    } else {
        val season = getSeason(month)
        if (season != null) {
            println("$month ayı $season mevsimine aittir.")
        } else {
            println("Geçersiz ay ismi. Lütfen geçerli bir ay ismi girin.")
        }
    }
}

fun getSeason(month: String): String? {
    return when (month) {
        "ocak", "şubat", "aralık" -> "Kış"
        "mart", "nisan", "mayıs" -> "İlkbahar"
        "haziran", "temmuz", "ağustos" -> "Yaz"
        "eylül", "ekim", "kasım" -> "Sonbahar"
        else -> null
    }
}
