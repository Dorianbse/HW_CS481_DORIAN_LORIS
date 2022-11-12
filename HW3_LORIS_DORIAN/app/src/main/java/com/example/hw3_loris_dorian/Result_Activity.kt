package com.example.hw3_loris_dorian

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Result_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val text = findViewById<TextView>(R.id.Result)
        val res = intent.extras
        val bool = intent.getStringExtra("result").toString()
        Log.d("BOOL", bool)
        if (bool== "true") {
            text.text = "Hello CS481"
        }
        else {
            text.text = "Either your id or password is incorrect"
        }

    }
}