package com.elvis.androidfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputName: EditText = findViewById(R.id.inputName)
        val inputEmail: EditText = findViewById(R.id.inputEmail)
        val inputAge: EditText = findViewById(R.id.inputAge)
        val buttonSave: Button = findViewById(R.id.buttonSave)

        // Connecting to the database.
        val database = Firebase.database

        val refUsers = database.getReference("Users")

        //refUsers.setValue("Elvis")

        buttonSave.setOnClickListener {
            val name = inputName.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val age = inputAge.text.toString().trim().toIntOrNull()

            if (name.isNotEmpty() && email.isNotEmpty() && age != null) {
                //Save the data
                val users = User(name, email, age)
                refUsers.push().setValue(users)
            }
        }


    }


}
data class User (val name: String = "", val email: String = "", val age: Int = 0)