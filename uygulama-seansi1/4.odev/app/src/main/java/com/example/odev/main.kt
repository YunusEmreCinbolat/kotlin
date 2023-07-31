package com.example.odev

fun main() {
    print("Bir harf girin: ")
    val input = readLine()?.trim()?.toLowerCase()

    if (input == null || input.isEmpty() || input.length > 1 || !input[0].isLetter()) {
        println("Geçersiz giriş. Lütfen tek bir harf girin.")
    } else {
        val letter = input[0]
        val result = if (isVowel(letter)) {
            "Sesli harf"
        } else {
            "Sessiz harf"
        }
        println("$letter harfi $result.")
    }
}

fun isVowel(letter: Char): Boolean {
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    return letter.toLowerCase() in vowels
}
