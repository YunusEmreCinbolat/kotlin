package com.example.thread

fun main(){
    var birincithread=Thread(Birincithread())
    var ikincithread=Thread(Ikincithread())
    birincithread.start()
    ikincithread.start()
    for (i in 100..900){
        println("Main thread calisti ")
        Thread.sleep(600)
    }
}