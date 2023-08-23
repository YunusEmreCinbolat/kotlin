package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentGelismeBinding


class GelismeFragment : Fragment() {
    private lateinit var binding: FragmentGelismeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentGelismeBinding.inflate(inflater,container,false)
        binding.buttonSonuc.setOnClickListener {
            val tasima=GelismeFragmentDirections.actionGelismeFragmentToSonucFragment()
            Navigation.findNavController(it).navigate(tasima)
        }
        return binding.root
    }

}