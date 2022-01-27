package com.example.myapplicationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final String TAG = "Miksan softa";
    public static final String EXTRA_MESSAGE = "viesti";
    private EditText nimikentta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate(): Sovellus käynnistyy");
        nimikentta=findViewById(R.id.editTextNimi);
        TextView hello=findViewById(R.id.viestiTextView);

        Button nappula=findViewById(R.id.button);

        nappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "nappulaa painettu");
                String nimi=nimikentta.getText().toString();
                Log.i(TAG, "nappulaa painettu, nimi = "+nimi);
                String viesti="Hello "+ nimi+ "! Mitä kuuluu?";
                hello.setText(viesti);
            }
        });

        Button viestinappula=findViewById(R.id.viestibutton);
        viestinappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heitaViesti(view);
            }
        });
    }
    public void heitaViesti(View view){
        Intent intent = new Intent(this, ViestiActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        String nimi=nimikentta.getText().toString();
        String message ="Hello "+ nimi+ "! Mitä kuuluu?";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Onstart(): Sovellus ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop(): Sovellus");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume(): Sovellus");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart(): Sovellus");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause(): Sovellus");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy(): Sovellus");
    }
}