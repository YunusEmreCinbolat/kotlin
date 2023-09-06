package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivityNotesAddBinding

class notesAdd : AppCompatActivity() {
    private lateinit var binding: ActivityNotesAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotesAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarnotesAdd.title="Not ekle"
        setSupportActionBar(binding.toolbarnotesAdd)
        binding.buttonSave.setOnClickListener{

        }
    }
}