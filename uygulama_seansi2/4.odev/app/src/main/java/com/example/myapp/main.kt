package com.example.myapp

import java.util.Scanner

fun main(){
    val girdi=Scanner(System.`in`)
    println("Kac sayi girilecek ")
    var dongu=girdi.nextInt()
    var sayilar =ArrayList<Int>()
    while (dongu>0){
        println("Sayi giriniz: ")
        sayilar.add(girdi.nextInt())
        dongu--
    }
    println("Toplam ${sayilar.sum()}")
}