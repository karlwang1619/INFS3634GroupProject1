package com.example.infs3634groupproject.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.infs3634groupproject.Model.Exercise;
import com.example.infs3634groupproject.Model.History;
import com.example.infs3634groupproject.Model.YoutubeConfig;

@Database(entities = {Exercise.class, History.class, YoutubeConfig.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract  exerciseDao exerciseDao();
    public abstract  historyDao historyDao();
    public abstract youtubeConfigDao youtubeConfigDAO();

    private static AppDatabase instance;
    public  static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "FitnessDB")
                    .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
                    //     This is NOT correct to do in a completed app.
                    //     Next week we will fix it, but for now this
                    //     line is necessary for the app to work.
                    //     This line will basically allow the database
                    //     queries to freeze the app.
                    .build();
        }
        return instance;
    }
}

