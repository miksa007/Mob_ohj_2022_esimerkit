package com.example.ajoneuvolaskuriosa2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var auto = false
    private var mopo = false
    private var bussi = false

    private var autolkm = 0
    private var mopolkm = 0
    private var bussilkm = 0

    private var textView_auto: TextView? = null
    private var textView_mopo: TextView? = null
    lateinit var textView_bussi: TextView

    var softwareState: String? = null

    val TAG = "Miksan softa"

    // Log tag name.
    private val SOFTA_STATE_BUSSIT = "SOFTA_STATE_BUSSIT"

    // Bundle state key.
    private val SOFTA_BUSSIT = "SOFTA_BUSSIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //recover
        softwareState=savedInstanceState?.getString(SOFTA_STATE_BUSSIT)
        setContentView(R.layout.activity_main)

        textView_auto = findViewById(R.id.textView_auto)
        textView_mopo = findViewById(R.id.textView_mopo)
        textView_bussi = findViewById(R.id.textView_bussi)

        val buttonLisaa: Button = findViewById(R.id.button_lisaa)
        buttonLisaa.setOnClickListener { buttonPressed() }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView_bussi.text = savedInstanceState?.getString(SOFTA_BUSSIT)
    }
    // invoked when the activity may be temporarily destroyed, save the instance state here
    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString(SOFTA_STATE_BUSSIT, softwareState)
            putString(SOFTA_BUSSIT, textView_bussi.text.toString())
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
    }


    fun buttonPressed(){
        if (auto) {
            autolkm++
            val auto_teksti= textView_auto
            //null check
            if (auto_teksti != null) {
                auto_teksti.setText("Autoja: $autolkm")
            }
        } else if (mopo) {
            mopolkm++
            //https://kotlinlang.org/docs/null-safety.html#safe-calls
            textView_mopo?.setText("Mopoja: $mopolkm")
        } else if (bussi) {
            bussilkm++
            //lateinit maarittely
            textView_bussi.setText("Busseja: $bussilkm")
        }
    }
    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.radioButton_auto -> if (checked) {
                auto = true
                mopo = false
                bussi = false
            }
            R.id.radioButton_mopo -> if (checked) {
                auto = false
                mopo = true
                bussi = false
            }
            R.id.radioButton_bussi -> if (checked) {
                auto = false
                mopo = false
                bussi = true
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Onstart(): Sovellus ")
    }
}