package com.ubuntuyouiwe.firebasemvvm.view.child_category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubuntuyouiwe.firebasemvvm.R
import com.ubuntuyouiwe.firebasemvvm.databinding.FragmentChildCategoryBinding
import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel
import com.ubuntuyouiwe.firebasemvvm.view.adapter.CategoryItemAdapter
import com.ubuntuyouiwe.firebasemvvm.view_model.child_category.ChildCategoryViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ChildCategoryFragment : Fragment() {
    private var binding: FragmentChildCategoryBinding? = null
    private val viewModel: ChildCategoryViewModel by viewModels()
    private val adapter: CategoryItemAdapter = CategoryItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildCategoryBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = viewModel.childCategoryState
        viewLifecycleOwner.lifecycleScope.launch {
            data.flowWithLifecycle(lifecycle).collect {
                adapter.submitList(it.data)

            }
        }
        binding?.recylerview?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.recylerview?.adapter = adapter

        adapter.listener {
            findNavController().navigate(R.id.action_childCategoryFragment_to_categoryDetailsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}


