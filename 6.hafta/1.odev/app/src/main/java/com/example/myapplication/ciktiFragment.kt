package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentCiktiBinding


class ciktiFragment : Fragment() {

    private lateinit var binding: FragmentCiktiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCiktiBinding.inflate(inflater,container,false)
        val bundle:ciktiFragmentArgs by navArgs()
        val ad=bundle.Ad
        binding.textViewAd.text=ad
        return binding.root
    }




}