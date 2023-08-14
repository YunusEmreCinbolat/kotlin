package com.example.list
import Item
import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView=itemView.findViewById(R.id.)
        var textView: TextView


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.lis_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView.text = item.text
    }

    override fun getItemCount(): Int {
        return items.size
    }


}