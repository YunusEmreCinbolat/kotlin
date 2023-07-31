package com.example.thread

class Birincithread: Runnable {
    override fun run() {
        for(i in 100..600){
            println("Birinci thread calisti $i")
            Thread.sleep(500)
        }
    }
}