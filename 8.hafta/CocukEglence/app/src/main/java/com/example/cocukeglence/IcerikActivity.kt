package com.example.cocukeglence
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cocukeglence.Icerikler
import com.example.cocukeglence.IceriklerAdapter
import com.example.cocukeglence.databinding.ActivityIcerikBinding
import com.example.cocukeglence.kategoriler
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage

class IcerikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIcerikBinding
    private lateinit var icerikListe: ArrayList<Icerikler>
    private lateinit var iceriklerAdapter: IceriklerAdapter
    private lateinit var storageRef: StorageReference // Firebase Storage referansı

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIcerikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as kategoriler

        binding.toolbarIcerikler.title = "${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarIcerikler)
        binding.icerikRv.setHasFixedSize(true)
        binding.icerikRv.layoutManager =
            StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        icerikListe = ArrayList()
        iceriklerAdapter = IceriklerAdapter(this, icerikListe)
        binding.icerikRv.adapter = iceriklerAdapter

        // Firebase Storage referansını alın
        val storage = Firebase.storage
        storageRef = storage.reference.child("resimler")
        val k = kategoriler(1, "MASAL")
        val y = IcerikDetay(1, "Keloğlan",)
        // Firebase Storage'dan resimleri çekmek için bir işlev çağırın
        fetchImagesFromStorage(k,y)
    }

    private fun fetchImagesFromStorage(k:kategoriler,y:IcerikDetay) {
        // Storage referansındaki resimleri listele
        storageRef.listAll()
            .addOnSuccessListener { listResult ->
                listResult.items.forEach { item ->
                    // Her bir resim için indirme URL'sini alın
                    item.downloadUrl.addOnSuccessListener { uri ->
                        // İndirilen URL'yi kullanarak resmi icerikListe'ye ekleyin
                        val icerik = Icerikler(
                            icerik_id = 1,
                            icerik_ad = "Resim",
                            icerik_isim = "Resim",
                            icerik_resim = uri.toString(),
                            kategoriler = k,
                            IcerikDetay = y
                        )

                        icerikListe.add(icerik)
                        iceriklerAdapter.notifyDataSetChanged()
                    }
                }
            }
            .addOnFailureListener { exception ->
                // Hata işleme
                exception.printStackTrace()
            }
    }
}
