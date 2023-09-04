package com.example.firebasauthenticationlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebasauthenticationlesson.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database=FirebaseDatabase.getInstance()

        val refKisiler=database.getReference("kisiler")



        /*kayıt
        val kisi= Kisiler("ali",5)
        refKisiler.push().setValue(kisi)
         */
        /*silme
        refKisiler.child("-NdUnNvNFK0ztwB2WqA7").removeValue()
        */
        /* güncelleme
        val updateInfo=HashMap<String,Any>()
        updateInfo["kisiAd"]="Mehmet"
        updateInfo["kisiYas"]=65
        refKisiler.child("-NdUn3USMRGiiqB-onzu").updateChildren(updateInfo)
        */
        /* veri okuma
        refKisiler.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (p in snapshot.children){
                    val kisi=p.getValue(Kisiler::class.java)
                    if(kisi!=null){
                        val key=p.key
                        Log.e("----------", "deneme")
                        Log.e("Kisi key",key.toString())
                        Log.e("Kisi ad",kisi.kisiAd.toString())
                        Log.e("Kisi yas",kisi.kisiYas.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
               // hata olduğunda çalışır
            }

        })*/

        /*1.sorgu olusturma
        val sorgu =refKisiler.orderByChild("kisiAd").equalTo("fahreddin")
        sorgu.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (p in snapshot.children){
                    val kisi=p.getValue(Kisiler::class.java)
                    if(kisi!=null){
                        val key=p.key
                        Log.e("----------", "deneme")
                        Log.e("Kisi key",key.toString())
                        Log.e("Kisi ad",kisi.kisiAd.toString())
                        Log.e("Kisi yas",kisi.kisiYas.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // hata olduğunda çalışır
            }

        })*/
        /*2.sorgu olusturma
     val sorgu =refKisiler.limitToFirst(3)
     sorgu.addValueEventListener(object :ValueEventListener{
         override fun onDataChange(snapshot: DataSnapshot) {

             for (p in snapshot.children){
                 val kisi=p.getValue(Kisiler::class.java)
                 if(kisi!=null){
                     val key=p.key
                     Log.e("----------", "deneme")
                     Log.e("Kisi key",key.toString())
                     Log.e("Kisi ad",kisi.kisiAd.toString())
                     Log.e("Kisi yas",kisi.kisiYas.toString())
                 }
             }
         }

         override fun onCancelled(error: DatabaseError) {
             // hata olduğunda çalışır
         }

     })*/
        /*3.sorgu olusturma
        val sorgu =refKisiler.limitToLast(3)
        sorgu.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (p in snapshot.children){
                    val kisi=p.getValue(Kisiler::class.java)
                    if(kisi!=null){
                        val key=p.key
                        Log.e("----------", "deneme")
                        Log.e("Kisi key",key.toString())
                        Log.e("Kisi ad",kisi.kisiAd.toString())
                        Log.e("Kisi yas",kisi.kisiYas.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // hata olduğunda çalışır
            }

        })*/
        //4.sorgu olusturma
        val sorgu =refKisiler.orderByChild("kisiYas").startAt(17.0).endAt(100.0)
        sorgu.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (p in snapshot.children){
                    val kisi=p.getValue(Kisiler::class.java)
                    if(kisi!=null){
                        val key=p.key
                        Log.e("----------", "deneme")
                        Log.e("Kisi key",key.toString())
                        Log.e("Kisi ad",kisi.kisiAd.toString())
                        Log.e("Kisi yas",kisi.kisiYas.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // hata olduğunda çalışır
            }

        })
    }
}