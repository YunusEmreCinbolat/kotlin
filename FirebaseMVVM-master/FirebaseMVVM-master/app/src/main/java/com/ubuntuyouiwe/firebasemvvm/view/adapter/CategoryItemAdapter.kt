package com.ubuntuyouiwe.firebasemvvm.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ubuntuyouiwe.firebasemvvm.databinding.CategoryItemBinding
import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel

class CategoryItemAdapter :
    ListAdapter<ChildCategoryModel, CategoryItemAdapter.CategoryItemViewHolder>(COMPARATOR) {

    private var onClick: (() -> Unit)? = null

    fun listener(data: () -> Unit) {
        onClick = data
    }
    init {
        Log.v("awdwa", "childCategoryModel.categoryTitle")
    }

    inner class CategoryItemViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(childCategoryModel: ChildCategoryModel) {
            binding.textView.text = childCategoryModel.categoryTitle
            binding.textView.setOnClickListener {
                onClick?.let {
                    it()
                }
            }
        }

    }


    object COMPARATOR : DiffUtil.ItemCallback<ChildCategoryModel>() {
        override fun areItemsTheSame(
            oldItem: ChildCategoryModel,
            newItem: ChildCategoryModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ChildCategoryModel,
            newItem: ChildCategoryModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(inflater, parent, false)

        return CategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}