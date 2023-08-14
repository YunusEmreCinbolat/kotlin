package com.example.list


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val itemList = generateDummyData()
        val itemAdapter = ItemAdapter(this, itemList)
        recyclerView.adapter = itemAdapter
    }

    private fun generateDummyData(): List<Item> {
        val itemList = mutableListOf<Item>()
        itemList.add(Item(R.drawable.ic_launcher_foreground, "Text 1"))
        itemList.add(Item(R.drawable.ic_launcher_foreground, "Text 2"))
        itemList.add(Item(R.drawable.ic_launcher_foreground, "Text 3"))
        return itemList
    }
}
