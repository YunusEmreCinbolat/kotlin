package com.example.notesapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.NotesCardDesignBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference

class noteAdapter(private val mContext:Context,private val noteList: List<noteContent>,private val refNotes: DatabaseReference):RecyclerView.Adapter<noteAdapter.noteHolder>() {
    inner class noteHolder(tasarim: NotesCardDesignBinding):RecyclerView.ViewHolder(tasarim.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteHolder {
        val tasarim=NotesCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return noteHolder(tasarim)
    }

    override fun getItemCount(): Int {
       return noteList.size
    }

    override fun onBindViewHolder(holder: noteHolder, position: Int) {
        val note=noteList.get(position)

        holder.itemView.findViewById<TextView>(R.id.textViewnoteTitle).text=note.note_title
        holder.itemView.findViewById<TextView>(R.id.textViewnoteContent).text=note.note_content
        holder.itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            Snackbar.make(it,"Silinsin mi",Snackbar.LENGTH_LONG).setAction("Evet"){
                Log.e("errrr",note.note_id.toString())
                refNotes.child(note.note_id!!).removeValue()
            }.show()
        }
        holder.itemView.findViewById<Button>(R.id.buttonUpdate).setOnClickListener {
            val intent = Intent(mContext, notesUpdate::class.java)
            intent.putExtra("noteId", note.note_id)
            intent.putExtra("noteTitle", note.note_title)
            intent.putExtra("noteContent", note.note_content)
            holder.itemView.context.startActivity(intent)
        }


    }
}