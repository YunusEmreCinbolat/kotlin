package com.example.myapp

fun main(){
    var liste= listOf<Int>(1,7,8,9,77,54)
    reverse(liste)

}
fun reverse(liste:List<Int>){
    var bosliste= mutableListOf<Int>()
    var index =liste.size-1
    while(index>-1){
        bosliste.add(liste.get(index))
        index--
    }
    println("${bosliste.toString()}")

}