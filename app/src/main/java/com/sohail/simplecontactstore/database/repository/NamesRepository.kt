package com.sohail.simplecontactstore.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.sohail.simplecontactstore.connectivity.ConnectivityObject
import com.sohail.simplecontactstore.database.dao.NameDao
import com.sohail.simplecontactstore.database.model.Name

class NamesRepository(private val dao: NameDao) {

    private val collection = FirebaseFirestore.getInstance().collection("Names")

    suspend fun insertName(name: Name, context: Context) {
        if (ConnectivityObject.isConnected(context)){
            collection.add(name)
            name.uploaded = true
            dao.insertName(name)
        }else{
            dao.insertName(name)
        }
    }

    fun getAllNames() : LiveData<List<Name>>{
        return dao.getAllNames()
    }
}