package com.example.cocukeglence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocukeglence.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kategorilerList: ArrayList<kategoriler>
    private lateinit var adapter: KategorilerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarKategori.title="Kategoriler"
        setSupportActionBar(binding.toolbarKategori)
        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager=LinearLayoutManager(this)
        kategorilerList= ArrayList()
        val database = FirebaseDatabase.getInstance()
        val kategoriRef = database.getReference("Kategoriler")
        kategoriRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children) {
                    val kategori = data.getValue(kategoriler::class.java)
                    if (kategori != null) {

                        kategorilerList.add(kategori)
                    }
                }
                adapter=KategorilerAdapter(applicationContext,kategorilerList)
                binding.kategoriRv.adapter=adapter
                adapter.notifyDataSetChanged() // Adapter'a veri değişikliği olduğunu bildirin
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Veritabanı Hatası:", databaseError.message)
            }
        })



    }
}