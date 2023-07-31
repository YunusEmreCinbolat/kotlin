package com.example.hackerrank

import java.util.Scanner

fun main(){
    val girdi=Scanner(System.`in`)
    var sayilar=ArrayList<Double>()
    var i:Int=1
    while (true){
        println("Dizinin $i. elemanını giriniz ")
        sayilar.add(girdi.nextDouble())
        println("Eleman eklemeyi sonlandiracakmisiniz 1-> Evet 2-> Hayır")
        i++
        if(girdi.nextInt()==1)
            break
    }
    println("Dizinin elemanlari ${sayilar.toString()}")
    println("Dizinin elemanlari toplami ${sayilar.sum()}")
}