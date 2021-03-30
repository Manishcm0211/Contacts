package com.example.contactsroom

import androidx.room.*

@Dao
interface MyDao {

    @Insert
    fun addUser(user: User)

    @Query("Select * from user_table order by Lower(ContactName)")
    fun getUser():List<User>

    @Delete
    fun delete(user: User)

    @Query("update user_table set ContactName=:UpdatedName,ContactNumber=:UpdatedNumber  where ContactName=:OldContactName")
    fun update(UpdatedName:String,UpdatedNumber:String,OldContactName:String)

}