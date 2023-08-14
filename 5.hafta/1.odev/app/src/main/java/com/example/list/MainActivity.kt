package com.example.list
import ListItem
import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerViewAdapter? = null
    private var itemList: ArrayList<ListItem>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView =binding.recyclerView
        recyclerView!!.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        itemList = ArrayList()
        itemList!!.add(ListItem(R.mipmap.sym_def_app_icon, "Text 1"))
        (itemList as ArrayList<ListItem>).add(ListItem(R.drawable.alert_dark_frame, "Text 2"))
        (itemList as ArrayList<ListItem>).add(ListItem(R.drawable.btn_dropdown, "Text 3"))
        adapter = RecyclerViewAdapter(this, itemList!!)
        recyclerView!!.setAdapter(adapter)
    }
}