package com.example.recyclerviewonclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewonclicklistener.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()


    }

    private fun getData() {

        val resImage = intent.getIntExtra("resImage", 0)
        val resName = intent.getStringExtra("resName")
        val resAddress = intent.getStringExtra("resAddress")
        binding.getImage.setImageResource(resImage)
        binding.getName.text = resName
        binding.getAddress.text = resAddress

    }
}