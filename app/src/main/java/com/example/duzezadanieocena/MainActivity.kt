package com.example.duzezadanieocena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.app.ActivityOptionsCompat
import android.transition.TransitionInflater
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Obsługa animacji przejścia do nowego Activity z animacją
        findViewById<Button>(R.id.button).setOnClickListener {
            val slideOutRight = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_right)
            slideOutRight.duration = 750
            window.exitTransition = slideOutRight

            val slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_right)
            val intent = Intent(this, Informacje_o_uzytkowniku::class.java)
            startActivity(intent, options.toBundle())
        }
    }
}