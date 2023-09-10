package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasimvvm.ui.viewmodel.KisiDetayViewModel

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel
      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
          binding= DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)

          binding.kisiDetayFragment=this
          binding.kisiDetayToolbarBaslik ="Kişi Detay"


          val bundle:KisiDetayFragmentArgs by navArgs()
          val gelenKisi=bundle.kisi
          binding.kisiNesnesi=gelenKisi



          return binding.root

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayViewModel by viewModels ()
        viewModel=tempViewModel
    }
    fun buttonGuncelle(kisiId:Int, kisiAd:String, kisiTel:String){
        viewModel.guncelle(kisiId,kisiAd,kisiTel)
    }

    }
