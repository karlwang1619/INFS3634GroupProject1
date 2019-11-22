package com.example.infs3634groupproject;

import com.example.infs3634groupproject.Model.Exercise;

import java.util.HashMap;
import java.util.List;

public class FakeDatabase {

    public static HashMap<Integer, Exercise> exercises = new HashMap<>();

    public static Exercise getExerciseByID(int exerciseID) {
        return exercises.get(exerciseID);

    }

    public static void saveExercisesToFakeDatabase(List<Exercise> exercisesToSave) {
        for(int i = 0 ; i <exercisesToSave.size(); i++) {
            Exercise exercise = exercisesToSave.get(i);
            exercises.put(exercise.getExerciseID(), exercise);
        }
    }



}
