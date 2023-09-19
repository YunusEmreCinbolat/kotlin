package com.example.countrytravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrytravel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryList: ArrayList<Country>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAnasayfa)
        binding.toolbarAnasayfa.title="Anasayfa"
        binding.rv.layoutManager=LinearLayoutManager(this)
        binding.rv.setHasFixedSize(true)
        countryList = ArrayList()

        val pisa = Country("Pisa","Italy",R.drawable.pisa)
        val colosseum = Country("Colloseum","Italy",R.drawable.colosseum)
        val eiffel = Country("Eiffel","France",R.drawable.eiffel)
        val londonBridge = Country("London Bridge","UK",R.drawable.londonbridge)

        countryList.add(pisa)
        countryList.add(colosseum)
        countryList.add(eiffel)
        countryList.add(londonBridge)
        val adapter=CountryAdapter(this,countryList)
        binding.rv.adapter=adapter


    }
}