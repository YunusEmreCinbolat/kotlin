package com.example.firebasauthenticationlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebasauthenticationlesson2.databinding.ActivityMainBinding
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
        var  database=FirebaseDatabase.getInstance()
        val refNesne=database.getReference("nesneler")
       /* val nesne = Nesneler("Havuç",9,"Sebze")
        refNesne.push().setValue(nesne)*/

        //refNesne.child("-NdVHuTCle0MMgpevARc").removeValue()

       /* val updateInfo= HashMap<String,Any>()
        updateInfo["nenneAdi"]="Pasta"
        updateInfo["nesneAdet"]=12
        updateInfo["nesneAlani"]="Tatlı"
        refNesne.child("-NdVITgAzp35TgG_R0HL").updateChildren(updateInfo)
    */
        refNesne.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for ( deger in snapshot.children) {
                    val nesne = deger.getValue(Nesneler::class.java)
                    if(nesne!=null){
                        Log.e("Nesne ad",nesne.nenneAdi.toString())
                        Log.e("Nesne adet",nesne.nesneAdet.toString())
                        Log.e("Kullanım alanı",nesne.nesneAlani.toString())

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}