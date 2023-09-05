package com.example.cocukeglence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocukeglence.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var kategorilerList: ArrayList<Kategoriler>
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
        val kategori1=Kategoriler(1,"MASAL")
        val kategori2=Kategoriler(1,"FIKRA")
        val kategori3=Kategoriler(1,"BİLMECE")
        val kategori4=Kategoriler(1,"TEKERLEME")
        kategorilerList.add(kategori1)
        kategorilerList.add(kategori2)
        kategorilerList.add(kategori3)
        kategorilerList.add(kategori4)
        adapter=KategorilerAdapter(this,kategorilerList)
        binding.kategoriRv.adapter=adapter

    }
}