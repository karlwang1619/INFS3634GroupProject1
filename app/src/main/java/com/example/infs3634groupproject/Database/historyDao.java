package com.example.infs3634groupproject.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.infs3634groupproject.Model.Exercise;
import com.example.infs3634groupproject.Model.History;

import java.lang.reflect.Array;
import java.util.List;

@Dao
public interface historyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addHistory(History history);

    @Query ("Select * From History order by historyID ASC")
    List<History> getAll();

    @Query("Select oneRM from History where exerciseName = :name")
    List<Double> getPB(String name);
}
