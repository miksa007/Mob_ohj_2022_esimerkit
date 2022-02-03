package com.example.akutaskarit2022;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Taskukirja.class}, version = 1, exportSchema = false)

public abstract class TaskukirjaRoomDatabase extends RoomDatabase {

    public abstract TaskukirjaDao taskukirjaDao();

    private static volatile TaskukirjaRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskukirjaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskukirjaRoomDatabase.class) {
                if (INSTANCE == null) {
                    Log.d("TaskukirjaRoomDatabase", "INSTANCE NULL");
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskukirjaRoomDatabase.class, "taskukirja_database")
                            .addCallback(sRoomDatabaseCallback) //Kutsutaan allaolevaa
                            .build();
                }
            }
        }else {
            Log.d("TaskukirjaRoomDatabase", "INSTANCE NULL");
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TaskukirjaDao dao = INSTANCE.taskukirjaDao();
                dao.deleteAll();

                Taskukirja taskukirja = new Taskukirja("1", "Mikki kiipelissä");
                dao.insert(taskukirja);
                //word = new Word("World");
                //dao.insert(word);
            });

        }
    };

}