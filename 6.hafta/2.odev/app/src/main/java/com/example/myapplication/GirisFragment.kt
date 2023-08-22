package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentGirisBinding


class GirisFragment : Fragment() {
    private lateinit var binding: FragmentGirisBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGirisBinding.inflate(inflater,container,false)
        binding.buttonGelisme.setOnClickListener {
            val tasima = 
        }
    return binding.root
    }


}