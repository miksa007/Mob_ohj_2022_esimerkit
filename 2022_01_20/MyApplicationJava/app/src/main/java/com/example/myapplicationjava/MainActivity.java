package com.example.myapplicationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nimikentta=findViewById(R.id.editTextNimi);
        TextView hello=findViewById(R.id.viestiTextView);

        Button nappula=findViewById(R.id.button);

        nappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nimi=nimikentta.getText().toString();
                String viesti="Hello "+ nimi+ "! Mitä kuuluu?";
                hello.setText(viesti);
            }
        });
    }
}