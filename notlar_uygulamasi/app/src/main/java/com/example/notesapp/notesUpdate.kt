package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityNotesUpdateBinding
import com.google.firebase.database.FirebaseDatabase

class notesUpdate : AppCompatActivity() {
    private var database=FirebaseDatabase.getInstance()
    private lateinit var binding: ActivityNotesUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNotesUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarnotesUpdates.title="Not güncelle"
        setSupportActionBar(binding.toolbarnotesUpdates)
        val noteId = intent.getStringExtra("noteId")
        val noteTitle = intent.getStringExtra("noteTitle")
        val noteContent = intent.getStringExtra("noteContent")
        binding.editTextUpdateNoteTitle.setText(noteTitle)
        binding.editTextUpdatenoteContent.setText(noteContent)
        binding.buttonUpdate.setOnClickListener {
            val baslik=binding.editTextUpdateNoteTitle.text.toString().trim()
            val icerik=binding.editTextUpdatenoteContent.text.toString().trim()
            val bilgiler=HashMap<String,Any>()
            bilgiler.put("note_title",baslik)
            bilgiler.put("note_content",icerik)
            val refNote=database.getReference("Notlar")
            refNote.child(noteId.toString()).updateChildren(bilgiler)
            Toast.makeText(this,"Bilgi güncellendi",Toast.LENGTH_LONG).show()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}