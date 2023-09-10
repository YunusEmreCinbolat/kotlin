package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.Kisiler

class KisilerDaRepository {
    val kisilerListesi: MutableLiveData<List<Kisiler>>
    init {
        kisilerListesi= MutableLiveData()
    }
    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }
    fun kisiKayit(kisiAd:String, kisiTel:String){

    }
    fun kisiGuncelle(kisiId:Int, kisiAd:String, kisiTel:String){
        Log.e("bvcg","${kisiId.toString()+""+kisiAd.toString()+""+kisiTel.toString()}")
    }
    fun kisiAra(aramaKelimesi:String){

    }

    fun kisiSil(kisiId: Int){

    }
    fun tumKisileriAl(){
        val liste=ArrayList<Kisiler>()
        val k1= Kisiler(1,"Yunus","05214763")
        val k2 = Kisiler(2,"fahreddin","012541")
        val k3= Kisiler(3,"Mithat","026987452")
        val k4= Kisiler(4,"Ali","01012525425")
        val k5= Kisiler(5,"mustafa","0214254147")
        val k6= Kisiler(6,"cengiz","0214254147")
        val k7= Kisiler(7,"tahir","0214254147")
        val k8= Kisiler(8,"yusuf","0214254147")
        val k9= Kisiler(9,"samet","0214254147")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        liste.add(k4)
        liste.add(k5)
        liste.add(k6)
        liste.add(k7)
        liste.add(k8)
        liste.add(k9)
        kisilerListesi.value=liste
    }


}