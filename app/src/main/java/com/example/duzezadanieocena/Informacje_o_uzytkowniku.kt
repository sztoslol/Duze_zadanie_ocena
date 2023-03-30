package com.example.duzezadanieocena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class Informacje_o_uzytkowniku : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacje_ouzytkowniku)

        // Wczytanie danych uzytkownika
        val User_Data = intent.getStringArrayExtra("userinfo")
        findViewById<TextView>(R.id.Textview_Toolbar_text).text = "${User_Data?.get(1)} ${User_Data?.get(2)}"
        findViewById<TextView>(R.id.TextView_nav_username).text = User_Data?.get(0)

        // Wypełnienie pól informacji o uzytkowniku
        findViewById<TextView>(R.id.Textview_userinfo_nick).text = User_Data?.get(0)
        findViewById<TextView>(R.id.Textview_userinfo_imie).text = User_Data?.get(1)
        findViewById<TextView>(R.id.Textview_userinfo_nazwisko).text = User_Data?.get(2)
        findViewById<TextView>(R.id.Textview_userinfo_klasa).text = User_Data?.get(3)

        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Obsługa chowania się manu nawigacji oraz jego animowanie
        findViewById<Button>(R.id.Button_nav_close).setOnClickListener {
            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left)
            navigationView.startAnimation(animation)
            navigationView.visibility = View.GONE
        }

        // Obsługa pokazywania się manu nawigacji oraz jego animowanie
        findViewById<ImageView>(R.id.button_hamburger_menu).setOnClickListener {
            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            navigationView.startAnimation(animation)
            navigationView.visibility = View.VISIBLE
        }

        // Obsługa przejść pomiędzy activity
        findViewById<Button>(R.id.Button_nav_homepage).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left)
        }

        findViewById<Button>(R.id.Button_nav_marks).setOnClickListener {
            startActivity(Intent(this, tabela_ocen::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left)
        }

        findViewById<Button>(R.id.Button_nav_user_info).setOnClickListener {
            Toast.makeText(this, "Jesteś już na stronie z informacjami o użytkowniku!", Toast.LENGTH_SHORT).show()
        }
    }
}