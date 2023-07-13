package com.example.diffutillexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val myAdapter = RecyclerViewDiffUtil()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = myAdapter

        val data = mutableListOf<DiffUtilItem>()
        val data1 =DiffUtilItem(1, "shiiva")
        val data2 = DiffUtilItem(2, "lkqdwj")
        data.add(data1)
        data.add(data2)

        myAdapter.setData(data.toList())

        val button = findViewById<Button>(R.id.submit)

        button.setOnClickListener {
            val updatedItem = DiffUtilItem(data2.id, "rahuram")
            data[1] = updatedItem
            myAdapter.setData(data.toList())
        }

    }
}