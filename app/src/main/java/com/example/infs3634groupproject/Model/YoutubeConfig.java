package com.example.infs3634groupproject.Model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class YoutubeConfig {
    @Ignore
    private static final String apiKey = "AIzaSyA0p1Jx774NgGVzyuD-g-VOdW3dA_OqwBU";

    @PrimaryKey @NonNull
    private int exerciseID;

    private String youtubeURL;

    public YoutubeConfig(int exerciseID, String youtubeURL) {
        this.exerciseID = exerciseID;
        this.youtubeURL = youtubeURL;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public static String getApiKey() {
        return apiKey;
    }
}
