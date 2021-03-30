package com.example.contactsroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room

class ContactDetails : AppCompatActivity() {
    var  mycontactdatabase : MyAppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        mycontactdatabase= Room.databaseBuilder<MyAppDatabase>(applicationContext,MyAppDatabase::class.java,"MyDB").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.myDao().getUser()

        var position = intent.extras?.getInt("position")
        var name : TextView = findViewById(R.id.con_name)
        var number : TextView = findViewById(R.id.con_num)
        var delContact : Button = findViewById(R.id.dl)
        var editt : Button = findViewById(R.id.ed)
        var contact = contacts[position!!]
        name.text = contact.ContactName
        number.text = contact.ContactNumber

        delContact.setOnClickListener {
            val contact=contacts[position!!]
            mycontactdatabase!!.myDao().delete(contact)
            Toast.makeText(this, "contact deleted", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        editt.setOnClickListener{
            val itent = Intent(this,EditContact::class.java)
            Toast.makeText(this, "contact saved", Toast.LENGTH_SHORT).show()
            itent.putExtra("posn",position)
            startActivity(itent)
            finish()
        }
    }

}
