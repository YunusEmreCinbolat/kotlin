package com.example.myapp

fun main() {
    val isimler = arrayListOf("ahmet", "mehmet", "ayşe", "feyza", "emir")

    // Kullanıcıdan güncellenecek indeks numarasını almak
    print("Lütfen güncellenecek ismin indeksini girin (0 ile ${isimler.size - 1} arasında): ")
    val indeks = readLine()?.toIntOrNull()

    if (indeks != null && indeks >= 0 && indeks < isimler.size) {
        // Kullanıcıdan yeni ismi almak
        print("Yeni ismi girin: ")
        val yeniIsim = readLine() ?: ""

        // İsimleri güncellemek
        isimler[indeks] = yeniIsim

        // Güncellenen isimleri ekrana yazdırmak
        println("Güncellenen İsimler:")
        for (isim in isimler) {
            println(isim)
        }
    } else {
        println("Geçersiz indeks numarası girdiniz. Lütfen tekrar deneyin.")
    }
}
