package fi.tut.saari5.akutfirebasessa2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "softa-MainActivity";

    private EditText nro;
    private EditText nimi;
    private ListView mAkuListView;

    //TODO esittele database ja reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nro = findViewById(R.id.editTextNumero);
        nimi = findViewById(R.id.editTextNimi);
        mAkuListView = findViewById(R.id.listView);

        //TODO määrittele  database ja reference



    }
    // TODO toteuta muutoskysely
    // TODO kytkentä Adapter -luokkaan

    /**
     * Metodi hoitaa kaikki OnClic - tapahtumat kayttoliittymassa
     *
     * @param view
     */
    public void onClick(View view) {
        Aku aku=null;

        switch (view.getId()) {
            case R.id.add:
                Log.d(TAG,"Add new tuli");
                        // save the new Aku to the database
                aku = new Aku();
                //aku.setKirjanNumero(nro.getText().toString());
                //aku.setKirjanNimi(nimi.getText().toString());

                //TODO DatabaseReferenceen tuupataan yllä luotu aku

                tyhjenna();



                Log.d(TAG, "data: "+aku);
                break;
            case R.id.delete:
                Log.d(TAG, "delete tuli");

                break;
        }
    }

    /**
     * Tyhjentaa tekstikentat
     */
    public void tyhjenna() {
        Log.d(TAG,"tyhjenna()");
                //tyhjennys
        nro.setText("");
        nimi.setText("");
    }
}