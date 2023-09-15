package com.ubuntuyouiwe.firebasemvvm.view.child_category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ubuntuyouiwe.firebasemvvm.R
import com.ubuntuyouiwe.firebasemvvm.databinding.FragmentChildCategoryBinding
import com.ubuntuyouiwe.firebasemvvm.view_model.child_category.ChildCategoryViewModel

class ChildCategoryFragment : Fragment() {
    private var binding: FragmentChildCategoryBinding? = null
    private val viewModel: ChildCategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildCategoryBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_child_category, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.childCategoryState
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}


