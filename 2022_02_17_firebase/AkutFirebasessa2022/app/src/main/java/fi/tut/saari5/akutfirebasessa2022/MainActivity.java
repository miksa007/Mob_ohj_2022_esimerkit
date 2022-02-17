package fi.tut.saari5.akutfirebasessa2022;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "softa-MainActivity";

    private EditText nro;
    private EditText nimi;
    private List<Aku> kaikkiAkut;
    private ListView mAkuListView;

    private Context context;

    private ArrayAdapter mAkuListAdapter;

    //TODO esittele database ja reference
    private FirebaseFirestore mFirestore;
    private CollectionReference akuReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        //TODO määrittele  database ja reference
        mFirestore=FirebaseFirestore.getInstance();
        akuReference=mFirestore.collection("torstai_2022_akut");


        nro = findViewById(R.id.editTextNumero);
        nimi = findViewById(R.id.editTextNimi);
        mAkuListView = findViewById(R.id.listView);


        kaikkiAkut = new ArrayList<>();
        muutosKysely();

    }
    // TODO toteuta muutoskysely
    // TODO kytkentä Adapter -luokkaan
    public void muutosKysely(){
        mFirestore.collection("torstai_2022_akut").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                kaikkiAkut.clear();
                Log.d(TAG, "nakyman paivitys?");
                if(queryDocumentSnapshots!=null) {
                    for (DocumentSnapshot snapshot : queryDocumentSnapshots) {
                        Aku aku = snapshot.toObject(Aku.class);
                        kaikkiAkut.add(aku);

                    }
                    mAkuListAdapter = new AkuArrayAdapter(context, R.layout.item_aku, kaikkiAkut);
                    mAkuListAdapter.notifyDataSetChanged();
                    mAkuListView.setAdapter(mAkuListAdapter);
                }else {
                    Log.d(TAG, "Querysnapshot on null");
                }
            }
        });
    }



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
                aku.setKirjanNumero(nro.getText().toString());
                aku.setKirjanNimi(nimi.getText().toString());

                //TODO DatabaseReferenceen tuupataan yllä luotu aku
                akuReference = mFirestore.collection("torstai_2022_akut");
                akuReference.add(aku);
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