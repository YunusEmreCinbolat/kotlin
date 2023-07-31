package com.example.thread

class Ikincithread: Runnable {
    override fun run() {
        for(i in 100..200){
            println("ikinci thread calisti $i")
            Thread.sleep(300)
        }
    }
}