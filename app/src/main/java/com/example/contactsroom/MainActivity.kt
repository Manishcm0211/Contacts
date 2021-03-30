package com.example.contactsroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity(), Adapter.OnContactItemClickListener  {
    companion object{
        var  mycontactdatabase : MyAppDatabase?=null
    }
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mycontactdatabase = Room.databaseBuilder<MyAppDatabase>(applicationContext,MyAppDatabase::class.java,"MyDB").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.myDao().getUser()

        var recView : RecyclerView = findViewById(R.id.recycler_view)
        recView.layoutManager = LinearLayoutManager(this)
        adapter  = Adapter(contacts,this)
        recView.adapter = adapter

        var add : Button = findViewById(R.id.add_btn)
        add.setOnClickListener{
            var intent = Intent(this, AddContact::class.java)
            startActivity(intent)
        }

    }

    fun contacts(): List<User> {
        mycontactdatabase = Room.databaseBuilder<MyAppDatabase>(applicationContext,MyAppDatabase::class.java,"MyDB").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.myDao().getUser()
        return contacts
    }

    override fun onContactClick(position: Int) {
        val intent= Intent(this, ContactDetails::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
    }

}