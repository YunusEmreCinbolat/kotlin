package com.ubuntuyouiwe.firebasemvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ubuntuyouiwe.firebasemvvm.databinding.DetailsItemBinding
import com.ubuntuyouiwe.firebasemvvm.model.CategoryDetailsModel
import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel

class CategoryDetailsAdapter:
    ListAdapter<CategoryDetailsModel, CategoryDetailsAdapter.CategoryDetailsViewHolder>(COMPARATOR) {
    class CategoryDetailsViewHolder(val binding: DetailsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryDetailsModel: CategoryDetailsModel) {
            binding.name.text = categoryDetailsModel.name
        }

    }

    object COMPARATOR : DiffUtil.ItemCallback<CategoryDetailsModel>() {
        override fun areItemsTheSame(
            oldItem: CategoryDetailsModel,
            newItem: CategoryDetailsModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CategoryDetailsModel,
            newItem: CategoryDetailsModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DetailsItemBinding.inflate(inflater, parent, false)
        return CategoryDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryDetailsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }
}