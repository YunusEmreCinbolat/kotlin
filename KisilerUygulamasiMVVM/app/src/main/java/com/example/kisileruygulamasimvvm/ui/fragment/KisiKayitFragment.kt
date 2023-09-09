package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiKayitBinding


class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentKisiKayitBinding.inflate(inflater,container,false)
        binding.toolbarkisiKayit.title="Kisi kayıt"
        binding.buttonKaydet.setOnClickListener {
            val kisiAd=binding.edittextkisiAd.text.toString()
            val kisiTel=binding.edittextkisiTel.text.toString()
            kayit(kisiAd,kisiTel)
        }
        return binding.root
    }
    fun kayit(kisiAd:String, kisiTel:String){

    }


}