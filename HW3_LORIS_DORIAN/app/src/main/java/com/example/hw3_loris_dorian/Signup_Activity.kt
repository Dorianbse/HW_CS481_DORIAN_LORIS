package com.example.hw3_loris_dorian

import android.R.attr.button
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore



class Signup_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        findViewById<Button>(R.id.ButtonCreateAccount).setOnClickListener {

            val email = findViewById<EditText>(R.id.textEmail).text.toString()
            val password = findViewById<EditText>(R.id.textPassword).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.textConfirmPassword).text.toString()
            val user: MutableMap<String, Any> = HashMap()
            val outputText = findViewById<TextView>(R.id.OutputMessage)

            if (password != confirmPassword) {
                Log.d("STATE", "the two passwords are different, try again")
                outputText.text = "the two passwords are different, try again"
            } else {
                user["email"] = email
                user["password"] = password

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.d("dbfirebase", "save: ${user}")
                        outputText.text = "You successfully created an account into the awesome app"
                    }
                    .addOnFailureListener {
                        Log.d("dbfirebase Failed", "${user}")
                        outputText.text = "Failed User has not been created"
                    }
                db.collection("users")
                    .get()
                    .addOnCompleteListener {

                        val result: StringBuffer = StringBuffer()

                        if (it.isSuccessful) {
                            for (document in it.result!!) {
                                Log.d(
                                    "dbfirebase",
                                    "retrive: ${document.data.getValue("email")} " +
                                            "${document.data.getValue("password")} "
                                )
                            }
                        }
                    }

            }
        }
    }
}