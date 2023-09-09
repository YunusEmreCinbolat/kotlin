package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.toolbaranasayfa.title="Kişiler"
        binding.fabEkle.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisikayitgecis)
        }
        return binding.root
    }


}