package com.example.reycycleviewandcardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.reycycleviewandcardview.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonKaydet.setOnClickListener {
            val AdSoyad=binding.editTextAdSoyad.text.toString().trim()
            val yas=binding.editTextYas.text.toString().trim()
            val tanit=binding.editTextTextHakkinda.text.toString().trim()
            if(yas.isEmpty()){
                binding.editTextYas.error="Lutfen boş bırakmayınız"
            }
            if(AdSoyad.isEmpty()){
                binding.editTextAdSoyad.error="Lütfen boş bırakmayınız"
            }
            if(tanit.isEmpty()){
                binding.editTextTextHakkinda.error="Lütfen boş bırakmayınız"
            }
            else{
                var database=FirebaseDatabase.getInstance()
                var databaseReference=database.reference.child("Users")
                var id=databaseReference.push()
                id.child("id").setValue(id.key.toString())
                id.child("AdiSoyadi").setValue(AdSoyad)
                id.child("yasi").setValue(yas)
                id.child("tanit").setValue(tanit)
                Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonGoster.setOnClickListener {
            val yenisayfa= Intent(this,UserListActivity::class.java)
            startActivity(yenisayfa)
            finish()
        }
    }
}