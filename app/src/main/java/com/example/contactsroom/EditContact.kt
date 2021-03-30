package com.example.contactsroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.contactsroom.MainActivity.Companion.mycontactdatabase

class EditContact : AppCompatActivity() {
    var  mycontactdatabase : MyAppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        mycontactdatabase= Room.databaseBuilder<MyAppDatabase>(applicationContext,MyAppDatabase::class.java,"MyDB").allowMainThreadQueries().build()
        var contacts= mycontactdatabase!!.myDao().getUser()

        var position = intent.extras?.getInt("posn")
        val Name: TextView = findViewById(R.id.con_name)
        val Numb: TextView = findViewById(R.id.con_num)
        var eName: EditText = findViewById(R.id.et0)
        var eNumb: EditText = findViewById(R.id.et1)
        var contact=contacts[position!!]
        var existingname=contact.ContactName
        Name.text = contact.ContactName
        Numb.text = contact.ContactNumber
        eName.setText(Name.text)
        eNumb.setText(Numb.text)

        val save_edit: Button = findViewById(R.id.sv)
        save_edit.setOnClickListener {
            var changedName = eName.text.toString()
            var changedNum = eNumb.text.toString()
            mycontactdatabase!!.myDao().update(changedName,changedNum,existingname)
            Toast.makeText(this, "contact updated", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}