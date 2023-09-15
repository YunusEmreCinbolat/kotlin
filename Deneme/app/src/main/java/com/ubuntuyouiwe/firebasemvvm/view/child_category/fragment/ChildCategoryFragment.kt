package com.ubuntuyouiwe.firebasemvvm.view.child_category.fragment
import androidx.lifecycle.observe
import com.ubuntuyouiwe.firebasemvvm.view_model.child_category.ChildCategoryViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubuntuyouiwe.firebasemvvm.databinding.FragmentChildCategoryBinding
import com.ubuntuyouiwe.firebasemvvm.view.child_category.adapter.ChildCategoryAdapter
import androidx.lifecycle.observe
import androidx.lifecycle.lifecycleScope

class ChildCategoryFragment : Fragment() {
    private var binding: FragmentChildCategoryBinding? = null
    private val viewModel: ChildCategoryViewModel by viewModels()
    private lateinit var adapter: ChildCategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildCategoryBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ChildCategoryAdapter(emptyList()) // Boş bir adapter oluşturun
        // RecyclerView'i ayarlayın
        binding?.rv?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = this@ChildCategoryFragment.adapter
        }
        // ViewModel'den verileri alın ve RecyclerView'e ayarlayın
        viewModel.childCategoryState.observe(viewLifecycleOwner) { state ->
            if (state.isSuccess) {
                // Handle success case,z e.g., update the UI with the data
                adapter.setData(state.data)
            } else if (state.isError) {
                // Handle error case, e.g., display an error message
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


