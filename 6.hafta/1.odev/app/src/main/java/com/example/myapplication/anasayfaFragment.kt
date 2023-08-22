package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentAnasayfaBinding


class anasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.buttongiris.setOnClickListener {
            var ad=binding.editTextTextad.text
            val sifre=binding.editTextTextsifre.text
            if(!ad.isEmpty() && !sifre.isEmpty()) {
                val gecis =
                    anasayfaFragmentDirections.actionAnasayfaFragmentToCiktiFragment(ad.toString())
                Navigation.findNavController(it).navigate(gecis)

            }


        }
        return binding.root

    }


}