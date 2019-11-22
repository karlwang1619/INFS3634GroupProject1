package com.example.infs3634groupproject.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Exercise {


    @SerializedName("id")
    @PrimaryKey
    private int exerciseID;
    @SerializedName("name")
    private String exerciseName;
    @SerializedName("description")
    private String exerciseInstructions;

    //private int exerciseDrawableID;


    public Exercise(int exerciseID, String exerciseName, String exerciseInstructions) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseInstructions = exerciseInstructions;
        //this.exerciseDrawableID = exerciseDrawableID;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseInstructions() {
        return exerciseInstructions;
    }

    /*public int getExerciseDrawableID() {
        return exerciseDrawableID;
    }*/

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setExerciseInstructions(String exerciseInstructions) {
        this.exerciseInstructions = exerciseInstructions;
    }

    @Override
    public String toString () {
        return exerciseID+" " +exerciseName + " " +exerciseInstructions;
    }


    /*  public void setExerciseDrawableID(int exerciseDrawableID) {
        this.exerciseDrawableID = exerciseDrawableID;
    }*/

}
