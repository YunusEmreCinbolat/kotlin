package com.example.kisileruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private lateinit var kisiler: ArrayList<kisiler>
    private lateinit var kisiAdapter: KisiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title="Kisi uygulaması"
        setSupportActionBar(binding.toolbar)
        binding.rv.setHasFixedSize(true)

        binding.rv.layoutManager=LinearLayoutManager(this)
        kisiler=ArrayList()
        val kisi1=kisiler("1","yunus","053214")
        val kisi2=kisiler("1","yunus","053214")
        val kisi3=kisiler("1","yunus","053214")
        val kisi4=kisiler("1","yunus","053214")
        kisiler.add(kisi1)
        kisiler.add(kisi2)
        kisiler.add(kisi3)
        kisiler.add(kisi4)
        kisiAdapter= KisiAdapter(applicationContext,kisiler)
        binding.rv.adapter=kisiAdapter
    }
}