package com.sohail.simplecontactstore.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sohail.simplecontactstore.database.model.Name

@Dao
interface NameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(name: Name)

    @Query("SELECT * FROM names_db ORDER BY id ASC")
    fun getAllNames() : LiveData<List<Name>>
}