package com.example.kisileruygulamasi

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
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
        binding.add.setOnClickListener {
            showAlert()
        }
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
    private fun showAlert(){
        val design= LayoutInflater.from(this).inflate(R.layout.alert_design,null)
        val editTextName=design.findViewById(R.id.name_et) as EditText
        val  editTextphone=design.findViewById(R.id.phone_et) as EditText


        val alertDialog= AlertDialog.Builder(this)
        alertDialog.setTitle("Kişi ekle")
        alertDialog.setView(design)
        alertDialog.setPositiveButton("Ekle"){dialogInterface,i ->
            val name = editTextName.text.toString().trim()
            val phone=editTextphone.text.toString().trim()
            Toast.makeText(this,"$name - $phone ", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("İptal"){ dialogInterface, i ->}
        alertDialog.create().show()
    }

}