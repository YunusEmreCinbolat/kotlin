package com.example.kisileruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kisilerArrayList: ArrayList<kisiler>
    private lateinit var kisiAdapter: KisiAdapter
    private val database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = "Kisi uygulaması"
        setSupportActionBar(binding.toolbar)
        binding.rv.setHasFixedSize(true)

        binding.rv.layoutManager = LinearLayoutManager(this)
        getDataFromFirebase()
    }

    private fun getDataFromFirebase() {
        val refUser = database.getReference("kisiler")
        refUser.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                kisilerArrayList = ArrayList()
                for (data in snapshot.children) {
                    val user = data.getValue(kisiler::class.java) // Kisi sınıfının doğru kullanımı
                    if (user != null) {
                        kisilerArrayList.add(user)
                    }
                }
                kisiAdapter = KisiAdapter(applicationContext, kisilerArrayList)
                binding.rv.adapter = kisiAdapter
                kisiAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Hata işleme stratejisi belirtmek gerekiyor
            }
        })
    }
}
