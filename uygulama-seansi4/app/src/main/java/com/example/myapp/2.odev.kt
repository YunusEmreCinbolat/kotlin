package com.example.myapp
import kotlin.concurrent.thread
fun main(){
    val list = listOf(1, 5, 8, 2, 10, 3, 6, 4, 7, 9)
    val middle = list.size / 2

    var sum1 = 0
    var sum2 = 0

    var thread1 = thread {

        for (i in 0 until middle){
            sum1+=list[i]
        }
    }
    var thread2 = thread {

        for (i in middle until list.size){
            sum2+=list[i]
        }
    }
    thread1.join()
    thread2.join()
    var toplam=sum1+sum2
    println("Toplam = $toplam")
}