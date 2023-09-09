package com.example.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasimvvm.R
import com.example.kisileruygulamasimvvm.data.entity.Kisiler
import com.example.kisileruygulamasimvvm.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasimvvm.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() ,SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAnasayfaBinding.inflate(inflater,container,false)
        binding.toolbaranasayfa.title="Kişiler"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbaranasayfa)

        binding.kisiRv.layoutManager=LinearLayoutManager(requireContext())

        val kisilerListesi=ArrayList<Kisiler>()
        val k1= Kisiler(1,"Yunus","05214763")
        val k2 =Kisiler(2,"fahreddin","012541")
        val k3=Kisiler(3,"Mithat","026987452")
        val k4=Kisiler(4,"Ali","01012525425")
        val k5=Kisiler(5,"mustafa","0214254147")
        val k6=Kisiler(6,"cengiz","0214254147")
        val k7=Kisiler(7,"tahir","0214254147")
        val k8=Kisiler(8,"yusuf","0214254147")
        val k9=Kisiler(9,"samet","0214254147")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)
        kisilerListesi.add(k5)
        kisilerListesi.add(k6)
        kisilerListesi.add(k7)
        kisilerListesi.add(k8)
        kisilerListesi.add(k9)
        val kisiAdapter=KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisiRv.adapter=kisiAdapter
        binding.fabEkle.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisikayitgecis)
        }
        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item=menu.findItem(R.id.action_ara)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }
    fun ara(aramaKelimesi:String){
        Log.e("kisi ara",aramaKelimesi)
    }


}