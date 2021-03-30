package com.example.contactsroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey
    var ContactName : String,
    @ColumnInfo(name = "ContactNumber")
    var ContactNumber : String
)