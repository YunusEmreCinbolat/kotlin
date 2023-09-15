package com.ubuntuyouiwe.firebasemvvm.view.category_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubuntuyouiwe.firebasemvvm.R
import com.ubuntuyouiwe.firebasemvvm.databinding.FragmentCategoryDetailsBinding
import com.ubuntuyouiwe.firebasemvvm.view.adapter.CategoryDetailsAdapter
import com.ubuntuyouiwe.firebasemvvm.view_model.category_details.CategoryDetailsViewModel
import kotlinx.coroutines.launch

class CategoryDetailsFragment : Fragment() {
    private var binding: FragmentCategoryDetailsBinding? =null
    private var adapter: CategoryDetailsAdapter = CategoryDetailsAdapter()
    private val viewModel: CategoryDetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = viewModel.categoryDetails
        viewLifecycleOwner.lifecycleScope.launch {
            data.flowWithLifecycle(lifecycle).collect {
                adapter.submitList(it.data)

            }
        }
        binding?.recyclerViewDetails?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.recyclerViewDetails?.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}