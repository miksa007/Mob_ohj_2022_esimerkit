package com.example.akutaskarit2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TaskukirjaViewModel mTaskukirjaViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TaskukirjaListAdapter adapter = new TaskukirjaListAdapter(new TaskukirjaListAdapter.TaskukirjaDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTaskukirjaViewModel = new ViewModelProvider(this).get(TaskukirjaViewModel.class);
        mTaskukirjaViewModel.getAllTaskukirjas().observe(this, taskukirjas -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(taskukirjas);
        });

        //Lisaa nappula

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewTaskukirjaActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });

        Button buttonUusi=findViewById(R.id.buttonUusi);
        buttonUusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewTaskukirjaActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        Button buttonPoistaKaikki=findViewById(R.id.buttonPoistaKaikki);
        buttonPoistaKaikki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTaskukirjaViewModel.deleteAll();
            }
        });

        Button buttonPoistaYksi = findViewById(R.id.buttonpoistaAlkio);
        buttonPoistaYksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Taskukirja temp= adapter.getTaskukirja();
                if(temp!=null){
                    mTaskukirjaViewModel.deleteTaskukirja(temp);
                }else{
                    Log.d("miksan softa", "Ei poistettavaa taskukirjaa valittuna");
                }
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String word = data.getStringExtra(NewTaskukirjaActivity.EXTRA_REPLY);

            String[] splited = word.split(";");
            String nro=splited[0];
            String nimi=splited[1];
            Taskukirja taskukirja=new Taskukirja(nro,nimi);
            mTaskukirjaViewModel.insert(taskukirja);
        } /*else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }*/
    }
}