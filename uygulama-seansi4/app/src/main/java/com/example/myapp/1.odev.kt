package com.example.myapp

import kotlin.concurrent.thread

fun main() {
    val list = listOf(1, 5, 8, 2, 10, 3, 6, 4, 7, 9)

    val findMaxThread = thread {
        val max = list.maxOrNull()
        println("Max value: $max")
        Thread.sleep(100)
    }

    val findMinThread = thread {
        val min = list.minOrNull()
        println("Min value: $min")
        Thread.sleep(100)
    }

    findMaxThread.join()
    findMinThread.join()

    println("Both threads have finished.")
}
