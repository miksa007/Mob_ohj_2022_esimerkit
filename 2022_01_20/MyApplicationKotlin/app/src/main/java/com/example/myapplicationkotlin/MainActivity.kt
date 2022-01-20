package com.example.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nappula: Button = findViewById(R.id.button)

        nappula.setOnClickListener{ painettu() }
    }

    private fun painettu(){

        Log.i("Miksan softa", "Nappula funktioon tultiin")

        val tervehdys: TextView = findViewById(R.id.viestiTextView)
        val nimikentta: EditText = findViewById(R.id.editTextNimi)

        val nimi = nimikentta.text
        val viesti = "Terve $nimi! Mitä kuuluu?"
        tervehdys.text=viesti.toString()
    }
}