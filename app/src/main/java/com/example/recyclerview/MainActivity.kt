package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nameList = ArrayList<String>()
        nameList.add("Основа 0")
        nameList.add("Основа 1")
        nameList.add("Основа 2")
        nameList.add("Основа 3")
        nameList.add("Основа 4")
        nameList.add("Основа 5")

        binding.bitn1.setOnClickListener {
            val a = binding.input1.text.toString()
            nameList.add(a)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
        binding.listView.adapter = adapter
        binding.listView.setBackgroundColor(resources.getColor(R.color.green))

        binding.listView.setOnItemClickListener{
            parent, view, position,id ->
            Toast.makeText(this, "Pressed item : ${nameList.get(position)}", Toast.LENGTH_SHORT).show()
        }
    }
}