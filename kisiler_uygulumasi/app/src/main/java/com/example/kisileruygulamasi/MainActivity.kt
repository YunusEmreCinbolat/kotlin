package com.example.kisileruygulamasi

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity(), OnQueryTextListener {
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
    private fun Arama(aramaKelime:String) {
        val refUser = database.getReference("kisiler")
        refUser.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                kisilerArrayList = ArrayList()
                for (data in snapshot.children) {
                    val user = data.getValue(kisiler::class.java) // Kisi sınıfının doğru kullanımı
                    if (user != null) {
                        if(user.kisi_ad!!.contains(aramaKelime)) {
                            user.kisi_id=data.key
                            kisilerArrayList.add(user)
                        }
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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        val item=menu?.findItem(R.id.action_ara)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
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
            val kisi= kisiler("",name,phone)
            val refUser = database.getReference("kisiler")
            refUser.push().setValue(kisi)

            Toast.makeText(this,"$name - $phone ", Toast.LENGTH_LONG).show()
        }
        alertDialog.setNegativeButton("İptal"){ dialogInterface, i ->}
        alertDialog.create().show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
       Log.e("Gönderilen arama",query.toString())
        Arama(query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("Harf girdikçe",newText.toString())
        Arama(newText.toString())
        return true
    }


}
