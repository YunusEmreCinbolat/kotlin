package com.example.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasimvvm.data.entity.CRUDCevap
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.data.entity.KisilerCevap
import com.example.kisileruygulamasimvvm.retrofit.KisilerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaRepository(var kdao:KisilerDao) {
    var kisilerListesi:MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi

    }

    fun kisiKayit(kisi_ad:String, kisi_tel:String){
        kdao.kisiEkle(kisi_ad,kisi_tel).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val success=response.body()!!.success
                val message=response.body()!!.message
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        kdao.kisiGuncelle(kisi_id,kisi_ad,kisi_tel).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                tumKisileriAl()

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            }

        })
    }

    fun kisiAra(aramaKelimesi:String){
        kdao.kisiAra(aramaKelimesi).enqueue(object :Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste=response.body()!!.kisiler
                kisilerListesi.value=liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun kisiSil(kisi_id: Int){
        kdao.kisiSil(kisi_id).enqueue(object :Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val success=response.body()!!.success
                val message=response.body()!!.message
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun tumKisileriAl(){
        kdao.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>) {
                val liste = response.body()!!.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {
            }

        })
    }
}