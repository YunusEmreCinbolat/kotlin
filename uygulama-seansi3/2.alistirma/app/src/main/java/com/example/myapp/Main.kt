package com.example.myapp

fun main() {
    val myList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val filteredList = filterOddNumbers(myList)
    println("Tek Sayılar: $filteredList")
}

fun filterOddNumbers(list: List<Int>): List<Int> {
    var sayilar=ArrayList<Int>()
    for ( sayi in list){
        if(sayi%2 !=0) {
            sayilar.add(sayi)
        }
    }
    return sayilar
}
