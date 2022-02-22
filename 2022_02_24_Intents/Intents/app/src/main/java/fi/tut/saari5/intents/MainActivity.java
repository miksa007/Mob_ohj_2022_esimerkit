package fi.tut.saari5.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String TAG="softa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Alkoi");
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"nappulaaYksiPainettu()");
                nappulaaYksiPainettu();
            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"nappulaaKaksiPainettu()");
                nappulaaKaksiPainettu();
            }
        });

        Button button3=findViewById(R.id.button1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"nappulaaKolmePainettu()");
                nappulaaKolmePainettu();
            }
        });
    }



    public void nappulaaYksiPainettu(){

    }

    public void nappulaaKaksiPainettu(){

    }

    public void nappulaaKolmePainettu(){

    }

}