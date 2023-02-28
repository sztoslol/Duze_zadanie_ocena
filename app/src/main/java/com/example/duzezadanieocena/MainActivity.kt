package com.example.duzezadanieocena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide() // ukrycie defaultowego topbara

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, Informacje_o_uzytkowniku::class.java)
            startActivity(intent)
        }
    }
}