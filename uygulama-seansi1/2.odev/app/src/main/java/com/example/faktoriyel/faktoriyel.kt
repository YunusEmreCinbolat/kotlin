package com.example.faktoriyel

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) {
        1
    } else {
        n.toLong() * factorial(n - 1)
    }
}

fun main() {
    print("Faktöriyelini hesaplamak istediğiniz sayıyı girin: ")
    val userInput = readLine()?.toIntOrNull()

    if (userInput == null || userInput < 0) {
        println("Geçersiz giriş. Lütfen pozitif bir tamsayı girin.")
    } else {
        val result = factorial(userInput)
        println("$userInput! = $result")
    }
}
