package com.example.akutaskarit2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskukirjaActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.roomtesti3112022.REPLY";

    private EditText mEditNumeroView;
    private EditText mEditNimiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_taskukirja);

        mEditNumeroView = findViewById(R.id.edit_numero);
        mEditNimiView = findViewById(R.id.edit_nimi);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNumeroView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditNumeroView.getText().toString() +";"+mEditNimiView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }
}