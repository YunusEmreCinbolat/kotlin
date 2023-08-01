package com.example.myapp

fun main(){
    var hashSet= hashSetOf<Int>(1,88,7,88,11)
    var dogruMu= containselement(hashSet)
    if(dogruMu==1){
        println("sayi mevcut")
    }
    else{
        println("sayi mevcut degil")
    }

}
fun containselement(liste: HashSet<Int>) : Int{
    var aranan =88
    liste.forEach({ if( it ==aranan ){ return 1 } })
    return 0

}