package com.example.kisileruygulamasimvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasimvvm.data.repo.KisilerDaRepository

class KisiKayitViewModel: ViewModel() {
    val krepo= KisilerDaRepository()

    fun kayit(kisiAd:String,kisiTel:String){
        krepo.kisiKayit(kisiAd,kisiTel)
    }
}