package com.example.akutaskarit2022;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskukirjaDao {

    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert
    void insert(Taskukirja taskukirja);

    @Query("DELETE FROM taskukirja_table")
    void deleteAll();

    @Query("SELECT * FROM taskukirja_table ORDER BY number ASC")
    LiveData<List<Taskukirja>> getNumberOrderedTaskukirjas();

    @Delete
    void deleteTaskukirja(Taskukirja taskukirja);

}
