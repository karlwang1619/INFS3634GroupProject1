package com.example.infs3634groupproject.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class History {
    @PrimaryKey @NonNull
    public int historyID;
    public String exerciseName;
    public double weight;
    public String date;
    public int reps;
    public double oneRM;

    public History(@NonNull int historyID, String exerciseName, double weight, String date, int reps, double oneRM) {
        this.historyID = historyID;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.date = date;
        this.reps = reps;
        this.oneRM = oneRM;
    }

    @NonNull
    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(@NonNull int historyID) {
        this.historyID = historyID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getOneRM() {
        return oneRM;
    }

    public void setOneRM(double oneRM) {
        this.oneRM = oneRM;
    }

    @Override
    public String toString() {
        return historyID + " " + exerciseName + " " + weight + " " + date + " " +reps + " " + oneRM;
    }
}
