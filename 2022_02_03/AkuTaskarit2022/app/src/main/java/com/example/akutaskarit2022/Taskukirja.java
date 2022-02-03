package com.example.akutaskarit2022;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import android.util.Log;

@Entity(tableName = "taskukirja_table")

public class Taskukirja {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "number")
    private String mNumber;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    public Taskukirja(@NonNull String number, @NonNull String name ) {
        Log.d("Taskukirja", "uusi olio: "+number+" "+ name);
        this.mNumber = number;
        this.mName = name;
    }

    @NonNull
    public String getNumber() {
        return mNumber;
    }

    public String getName() {
        return this.mName;
    }
}

