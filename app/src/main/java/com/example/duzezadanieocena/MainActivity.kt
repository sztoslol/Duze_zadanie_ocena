package com.example.duzezadanieocena

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private var isNavOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val User_Data = arrayOf("", "", "", "") // tablica danych uzytkownika

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
            Toast.makeText(this, "Jesteś już na stronie głównej", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.Button_nav_marks).setOnClickListener {
            startActivity(Intent(this, tabela_ocen::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left)
        }

        findViewById<Button>(R.id.Button_nav_user_info).setOnClickListener {
            startActivity(Intent(this, Informacje_o_uzytkowniku::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left)
        }

        findViewById<Button>(R.id.Button_login).setOnClickListener {
            val nick = findViewById<EditText>(R.id.Input_nick).text.toString()
            val imie = findViewById<EditText>(R.id.Input_imie).text.toString()
            val nazwisko = findViewById<Button>(R.id.Input_nazwisko).text.toString()
            val klasa = findViewById<EditText>(R.id.Input_klasa).text.toString()

            if (nick != "" && imie != "" && nazwisko != "" && klasa != ""){
                User_Data[0] = nick
                User_Data[1] = imie
                User_Data[2] = nazwisko
                User_Data[3] = klasa

                findViewById<LinearLayout>(R.id.Login_Form).visibility = View.GONE
            }else{
                Toast.makeText(this, "Wypełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}