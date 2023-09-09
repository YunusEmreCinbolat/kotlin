package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
          binding= FragmentKisiDetayBinding.inflate(inflater,container,false)
          binding.toolbarkisiKayit.title="Kişi Detay"

          val bundle:KisiDetayFragmentArgs by navArgs()
          val gelenKisi=bundle.kisi

          binding.edittextkisiAd.setText(gelenKisi.kisiAd)
          binding.edittextkisiTel.setText(gelenKisi.kisiTel)

          binding.buttonKaydet.setOnClickListener {
              val kisiAd=binding.edittextkisiAd.text.toString()
              val kisiTel=binding.edittextkisiTel.text.toString()
              guncelle(gelenKisi.kisiId,kisiAd,kisiTel)
          }
          return binding.root

        }
    fun guncelle(kisiId:Int,kisiAd:String,kisiTel:String){

    }

    }
