package com.sohail.simplecontactstore.view_model

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sohail.simplecontactstore.database.NameDatabase
import com.sohail.simplecontactstore.database.model.Name
import com.sohail.simplecontactstore.database.repository.NamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NamesViewModel (application: Application) : AndroidViewModel(application){
    private val repository : NamesRepository

    init {
        val dao = NameDatabase.getDatabase(application).getNameDao()
        repository = NamesRepository(dao)
    }

    fun addName(name: Name, context : Context) = viewModelScope.launch (Dispatchers.IO) {
        repository.insertName(name, context)
    }

    fun getAllNames(): LiveData<List<Name>> {
        return repository.getAllNames()
    }
}