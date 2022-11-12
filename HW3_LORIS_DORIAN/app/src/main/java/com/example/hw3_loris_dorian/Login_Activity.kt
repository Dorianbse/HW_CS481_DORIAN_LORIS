package com.example.hw3_loris_dorian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        findViewById<Button>(R.id.Connect).setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            val email = findViewById<EditText>(R.id.textEmail).text.toString()
            val password = findViewById<EditText>(R.id.textPassword).text.toString()
            val user: MutableMap<String, Any> = HashMap()
            val outputText = findViewById<TextView>(R.id.OutputMessage)

            user["email"] = email
            user["password"] = password

            db.collection("users")
                .get()
                .addOnCompleteListener {

                    val result: StringBuffer = StringBuffer()
                    var isok = "false"
                    if (it.isSuccessful) {
                        Log.d("RESULT", result.toString())
                        for (document in it.result!!) {
                            Log.d(
                                "dbfirebase",
                                "retrive: ${document.data.getValue("email")} " +
                                        "${document.data.getValue("password")} "
                            )
                            if (email == document.data.getValue("email")) {
                               if (password == document.data.getValue("password")) {
                                   isok = "true"

                               }
                                }
                            }
                        if (isok == "true") {
                            val intent = Intent(this, Result_Activity::class.java)
                            intent.putExtra("result", "true")
                            startActivity(intent)
                        }
                        else {
                            val intent = Intent(this, Result_Activity::class.java)
                            intent.putExtra("result", "false")
                            startActivity(intent)
                        }
                        }
                    else {
                        val intent = Intent(this, Result_Activity::class.java)
                        intent.putExtra("result", "false")
                        startActivity(intent)
                    }
                }
        }
    }
}