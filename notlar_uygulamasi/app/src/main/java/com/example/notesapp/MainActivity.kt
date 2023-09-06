package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteList: ArrayList<noteContent>
    private var database=FirebaseDatabase.getInstance()
    private lateinit var noteAdapter: noteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarHomepage.title="Notlarım"
        setSupportActionBar(binding.toolbarHomepage)
        binding.notesRv.setHasFixedSize(true)
        binding.notesRv.layoutManager=LinearLayoutManager(this)
        AllNotesShow()
        binding.fabnoteAdd.setOnClickListener {
            val intent=Intent(this,notesAdd::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun AllNotesShow(){
        val refNote=database.getReference("Notlar")
        refNote.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                noteList=ArrayList()
                for(note in snapshot.children){
                    val notes=note.getValue(noteContent::class.java)
                    if(notes!=null){
                        noteList.add(notes)
                    }
                }
                noteAdapter= noteAdapter(applicationContext,noteList)
                binding.notesRv.adapter=noteAdapter
                noteAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}