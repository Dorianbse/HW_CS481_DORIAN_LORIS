package com.example.hw2_dorian_beasse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lineFragment = LineFragment()
        val barFragment = BarFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, lineFragment)
            commit()
        }
        findViewById<Button>(R.id.button_bar).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, barFragment)
                commit()
            }
        }
        findViewById<Button>(R.id.button_line).setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, lineFragment)
                commit()
            }
        }
    }
}