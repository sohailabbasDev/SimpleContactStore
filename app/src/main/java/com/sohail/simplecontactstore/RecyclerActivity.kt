package com.sohail.simplecontactstore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sohail.simplecontactstore.database.model.Name
import com.sohail.simplecontactstore.recyler.MyAdapter
import com.sohail.simplecontactstore.view_model.NamesViewModel

class RecyclerActivity : AppCompatActivity() {

    private lateinit var viewModel: NamesViewModel
    private var  list : ArrayList<Name> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val nameRecyclerView = findViewById<RecyclerView>(R.id.nameRecycler)
        nameRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[NamesViewModel::class.java]

        viewModel.getAllNames().observe(this){
            list.addAll(it)
            Log.d("it", "onCreate: ${it[1]}")
            nameRecyclerView.adapter?.notifyDataSetChanged()
        }
        nameRecyclerView.adapter = MyAdapter(list)
    }
}