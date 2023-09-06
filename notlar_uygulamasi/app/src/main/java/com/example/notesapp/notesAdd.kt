package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityNotesAddBinding
import com.google.firebase.database.FirebaseDatabase

class notesAdd : AppCompatActivity() {
    private lateinit var binding: ActivityNotesAddBinding
    private val database=FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotesAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarnotesAdd.title="Not ekle"
        setSupportActionBar(binding.toolbarnotesAdd)
        binding.buttonSave.setOnClickListener{
            val baslik= binding.editTextNoteTitle.toString().trim()
            val icerik=binding.editTextnoteContent.text.toString().trim()
            if(!baslik.isEmpty() && !icerik.isEmpty()) {
                val refNote = database.getReference("Notlar")
                val note = noteContent("", baslik, icerik)
                refNote.push().setValue(note)
            }
            else{
                Toast.makeText(this,"Alanlar boş olamaz",Toast.LENGTH_LONG).show()
            }

        }
    }
}