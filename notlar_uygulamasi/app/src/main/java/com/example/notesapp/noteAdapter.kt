package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.NotesCardDesignBinding

class noteAdapter(private val mContext:Context,private val noteList: List<noteContent>):RecyclerView.Adapter<noteAdapter.noteHolder>() {
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
        holder.itemView.findViewById<TextView>(R.id.editTextnoteContent).text=note.note_content
        holder.itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {

        }
        holder.itemView.findViewById<Button>(R.id.buttonUpdate).setOnClickListener {

        }


    }
}