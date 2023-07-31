package com.example.myapp

fun sesliHarfleriKaldir(girdi: String): String {
    val sesliHarfler = "aeiouAEIOU"
    val sonuc = StringBuilder()

    for (harf in girdi) {
        if (harf !in sesliHarfler) {
            sonuc.append(harf)
        }
    }

    return sonuc.toString()
}

fun main() {
    print("Bir metin girin: ")
    val girdi = readLine() ?: ""

    val sesliHarflerKaldirilmis = sesliHarfleriKaldir(girdi)
    println("Sesli harfleri çıkartılmış metin: $sesliHarflerKaldirilmis")
}
