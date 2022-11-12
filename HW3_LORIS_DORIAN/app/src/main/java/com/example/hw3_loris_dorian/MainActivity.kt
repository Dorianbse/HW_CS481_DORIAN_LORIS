package com.example.hw3_loris_dorian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButtonLogin = findViewById<Button>(R.id.ButtonLogin)
        clickButtonLogin.setOnClickListener {
            val intent = Intent(this, Login_Activity::class.java)
            startActivity(intent)
        }

        val clickButtonSignUp = findViewById<Button>(R.id.ButtonSignup)
        clickButtonSignUp.setOnClickListener {
            val intent = Intent(this, Signup_Activity::class.java)
            startActivity(intent)
        }
    }
}