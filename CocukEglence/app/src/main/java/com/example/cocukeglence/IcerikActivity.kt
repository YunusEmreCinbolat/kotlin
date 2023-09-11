package com.example.cocukeglence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cocukeglence.databinding.ActivityIcerikBinding

class IcerikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIcerikBinding
    private lateinit var icerikListe: ArrayList<Icerikler>
    private lateinit var iceriklerAdapter: IceriklerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIcerikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori=intent.getSerializableExtra("kategoriNesne") as kategoriler


        binding.toolbarIcerikler.title = "${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarIcerikler)
        binding.icerikRv.setHasFixedSize(true)
        binding.icerikRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        icerikListe = java.util.ArrayList()
        val k = kategoriler(1, "MASAL")
        val y = IcerikDetay(1, "Keloğlan",)
        val c1 = Icerikler(1, "prens", "prens", "prens", k, y)
        val c2 = Icerikler(2, "masalevi", "masalevi", "masalevi", k, y)
        val c3 = Icerikler(3, "pinokyo", "pinokyo", "pinokyo", k, y)
        val c4 = Icerikler(4, "rapunzel", "rapunzel", "rapunzel", k, y)
        val c5 = Icerikler(5, "uzgunordek", "uzgunordek", "uzgunordek", k, y)
        icerikListe.add(c1)
        icerikListe.add(c2)
        icerikListe.add(c3)
        icerikListe.add(c4)
        icerikListe.add(c5)
        iceriklerAdapter=IceriklerAdapter(this,icerikListe)
        binding.icerikRv.adapter=iceriklerAdapter
    }
}
