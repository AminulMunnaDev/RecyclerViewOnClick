package com.example.recyclerviewonclicklistener

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var resAdapter: ResAdapter
    private val itemList = ArrayList<ResModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //add data
        addData()


    }

    private fun addData() {
        itemList.add(ResModel(R.drawable.chillox, "ChillOx", "dhanmondi"))
        itemList.add(ResModel(R.drawable.bemejban, "Be Mejban", "jigatola"))
        itemList.add(ResModel(R.drawable.bfc, "BFC", "wari"))
        itemList.add(ResModel(R.drawable.kfc, "KFC", "khilgaon"))
        itemList.add(ResModel(R.drawable.pabulam, "Pabulam", "Dhanmondi"))
        itemList.add(ResModel(R.drawable.takeout, "Takeout", "mohammadpur"))
        itemList.add(ResModel(R.drawable.chillox, "ChillOx", "dhanmondi"))
        itemList.add(ResModel(R.drawable.bemejban, "Be Mejban", "jigatola"))
        itemList.add(ResModel(R.drawable.bfc, "BFC", "wari"))
        itemList.add(ResModel(R.drawable.kfc, "KFC", "khilgaon"))
        itemList.add(ResModel(R.drawable.pabulam, "Pabulam", "Dhanmondi"))
        itemList.add(ResModel(R.drawable.takeout, "Takeout", "mohammadpur"))

        recyclerView = findViewById(R.id.recyclerView)
        resAdapter = ResAdapter(itemList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = resAdapter
        resAdapter.setOnClickListener(object : ResAdapter.OnClickListener {
            override fun onClick(position: Int, model: ResModel) {

                val intent = android.content.Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("resImage", model.resImage)
                intent.putExtra("resName", model.resName)
                intent.putExtra("resAddress", model.resAddress)
                startActivity(intent)
            }

        })
    }
}