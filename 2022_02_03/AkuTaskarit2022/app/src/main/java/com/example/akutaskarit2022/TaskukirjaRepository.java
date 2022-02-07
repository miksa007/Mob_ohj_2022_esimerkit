package com.example.akutaskarit2022;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskukirjaRepository {
    private TaskukirjaDao mTaskukirjaDao;
    private LiveData<List<Taskukirja>> mAllTaskukirjas;

    TaskukirjaRepository(Application application) {
        Log.d("TaskukirjaRepository", "konstruktori");
        TaskukirjaRoomDatabase db = TaskukirjaRoomDatabase.getDatabase(application);
        mTaskukirjaDao = db.taskukirjaDao();
        mAllTaskukirjas = mTaskukirjaDao.getNumberOrderedTaskukirjas();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Taskukirja>> getAllTaskukirjas() {
        Log.d("TaskukirjaRepository", "getAll tapahtui");
        /*
        int Debug=1;

        if(Debug==1){
            int ind=1;
            for (Taskukirja tasku: mAllTaskukirjas.) {
                Log.d("TaskukirjaRepository", ""+ind+". "+tasku.toString());

            }
        }
        */

        return mAllTaskukirjas;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Taskukirja taskukirja) {
        Log.d("TaskukirjaRepository", "Insert tapahtui");
        TaskukirjaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTaskukirjaDao.insert(taskukirja);
        });
    }

}