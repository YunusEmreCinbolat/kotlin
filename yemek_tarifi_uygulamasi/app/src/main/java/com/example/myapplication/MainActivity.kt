package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var yemekArraylist:ArrayList<Yemekler>
    private lateinit var adapter: YemekAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView=binding.rc
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        var f1=Yemekler("ADANA KEBAP","adana_kebabi")
        var f2=Yemekler("KARNI YARIK","karniyarik")
        var f3=Yemekler("MUHLAMA","muhlama")
        yemekArraylist=ArrayList<Yemekler>()
        yemekArraylist.add(f1)
        yemekArraylist.add(f2)
        yemekArraylist.add(f3)
        adapter=YemekAdapter(this,yemekArraylist)
        binding.rc.adapter=adapter

    }
}