package com.example.infs3634groupproject.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.infs3634groupproject.Model.History;
import com.example.infs3634groupproject.Model.YoutubeConfig;

@Dao
public interface youtubeConfigDao {

    @Query("Select youtubeURL from youtubeconfig where exerciseID = :id")
    String getYoutubeURL(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addYoutubeVideo(YoutubeConfig youtubeConfig);


}
