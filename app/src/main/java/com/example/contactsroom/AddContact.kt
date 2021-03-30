package com.example.contactsroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        var contactName = findViewById<EditText>(R.id.et0)
        var phoneNumber = findViewById<EditText>(R.id.et1)
        val savenumber = findViewById<Button>(R.id.bt1)

        savenumber.setOnClickListener{
            var new = User(contactName.text.toString(),phoneNumber.text.toString())
            MainActivity.mycontactdatabase!!.myDao().addUser(new)
            Toast.makeText(this, "contact saved", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}