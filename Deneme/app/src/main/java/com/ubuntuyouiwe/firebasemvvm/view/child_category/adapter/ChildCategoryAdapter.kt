package com.ubuntuyouiwe.firebasemvvm.view.child_category.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubuntuyouiwe.firebasemvvm.R
import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel


class ChildCategoryAdapter(private val dataList: List<ChildCategoryModel>) :
    RecyclerView.Adapter<ChildCategoryAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ChildCategoryModel) {

            itemView.findViewById<TextView>(R.id.textViewCategory).text=item.categoryTitle

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    fun setData(newDataList: List<ChildCategoryModel>) {
        var dataList = newDataList
        notifyDataSetChanged()
    }
}