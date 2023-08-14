package com.example.list
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    private val textView: TextView = itemView.findViewById(R.id.textView)

    fun bind(item: Item) {
        imageView.setImageResource(item.imageResource)
        textView.text = item.text
    }
}
