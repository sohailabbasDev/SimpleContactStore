package com.sohail.simplecontactstore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sohail.simplecontactstore.connectivity.ConnectionLiveData
import com.sohail.simplecontactstore.connectivity.ConnectivityObject
import com.sohail.simplecontactstore.database.model.Name
import com.sohail.simplecontactstore.view_model.NamesViewModel

open class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NamesViewModel
    private lateinit var connectionLiveData : ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectionLiveData = ConnectionLiveData(application)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))[NamesViewModel::class.java]

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val numberEditText = findViewById<EditText>(R.id.numberEditText)
        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val seeDataButton = findViewById<Button>(R.id.seeDataButton)

        seeDataButton.setOnClickListener{
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener{
            if (nameEditText.text.isEmpty()){
                Toast.makeText(this,"enter name" ,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (numberEditText.text.isEmpty()){
                Toast.makeText(this,"enter number" ,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (ageEditText.text.isEmpty()){
                Toast.makeText(this,"enter age" ,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val name = Name(name = nameEditText.text.toString(), number = numberEditText.text.toString(), age = ageEditText.text.toString())
            if (ConnectivityObject.isConnected(this)){
                viewModel.addName(name, this)
                Toast.makeText(this,"saved online" ,Toast.LENGTH_SHORT).show()
            }else{
                viewModel.addName(name, this)
                Toast.makeText(this,"saved offline" ,Toast.LENGTH_SHORT).show()
            }
        }
    }
}