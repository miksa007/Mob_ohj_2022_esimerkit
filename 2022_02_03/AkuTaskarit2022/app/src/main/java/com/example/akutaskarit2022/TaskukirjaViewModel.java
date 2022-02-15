package com.example.akutaskarit2022;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskukirjaViewModel extends AndroidViewModel {

    private TaskukirjaRepository mRepository;

    private final LiveData<List<Taskukirja>> mAlltaskukirjas;

    public TaskukirjaViewModel (Application application) {
        super(application);

        mRepository = new TaskukirjaRepository(application);
        mAlltaskukirjas = mRepository.getAllTaskukirjas();
    }

    LiveData<List<Taskukirja>> getAllTaskukirjas() {
        Log.d("TaskukirjaViewModel", "Get All tapahtui");
        return mAlltaskukirjas;
    }

    public void insert(Taskukirja taskukirja) {
        Log.d("TaskukirjaViewModel", "Insert tapahtui");
        mRepository.insert(taskukirja);
    }

    public void deleteAll(){
        mRepository.deleteAll();
    }
    public void deleteTaskukirja(Taskukirja taskukirja){
        mRepository.deleteTaskukirja(taskukirja);
    }
}
