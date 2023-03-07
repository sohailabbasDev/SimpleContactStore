package com.sohail.simplecontactstore.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "names_db")
data class Name(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "number")
    val number : String,

    @ColumnInfo(name = "age")
    val age : String,

    @ColumnInfo(name = "uploaded")
    var uploaded : Boolean = false
)
