package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=this.getSharedPreferences("com.example.sharedpreferences",Context.MODE_PRIVATE)
    }
    fun buttonDelete(view: View){
        val yas=sharedPreferences.getInt("yas",-1)
        if(yas!=-1){
            sharedPreferences.edit().remove("yas").apply()
            binding.gosteryas.text="Result "
        }

    }

    fun buttonkaydet(view: View){
        val yas=binding.yastext.toString().toIntOrNull()

        if(yas!=null){

            sharedPreferences.edit().putInt("age",yas).apply()
            binding.gosteryas.text="result ${yas.toString()}"
        }


    }
}