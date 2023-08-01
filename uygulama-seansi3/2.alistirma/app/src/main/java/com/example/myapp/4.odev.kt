package com.example.myapp

fun  main(){
    var sayilar= listOf<Int>(1,8,7,7,4,4)
    hashfunction(sayilar)
}
fun hashfunction(list:List<Int>){
    var kontrolHash=HashSet<Int>()
    var hashList=HashSet<Int>()
    for (sayi in list){
        if(!kontrolHash.add(sayi)){
            hashList.add(sayi)
        }
    }
    println("${hashList.toString()}")
}