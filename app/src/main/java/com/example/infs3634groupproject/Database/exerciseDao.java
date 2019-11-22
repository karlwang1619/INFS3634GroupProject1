package com.example.infs3634groupproject.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.infs3634groupproject.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface exerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Exercise> exercises);

    @Query("Select * From Exercise where exerciseID = :id")
    Exercise findExerciseByID(int id);

    @Query("Select * FRom Exercise where exerciseID NOT IN(111,192,105,229, 388, 414, 423, 397, 141, 227,289, 407) order by exerciseName asc ")
    List<Exercise > getAddExercises();


}
