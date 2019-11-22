package com.example.infs3634groupproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.infs3634groupproject.Database.AppDatabase;
import com.example.infs3634groupproject.Fragment.ExerciseFragment;
import com.example.infs3634groupproject.Fragment.TopViewFragment;
import com.example.infs3634groupproject.Model.Exercise;
import com.example.infs3634groupproject.Model.History;
import com.example.infs3634groupproject.Model.YoutubeConfig;
import com.example.infs3634groupproject.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ExerciseDetailActivity extends YouTubeBaseActivity {
    private TextView exerciseNameTV;
    private TextView exerciseDescTV;
    public EditText addDateET;
    public EditText addWeightET;
    public EditText addRepsET;
    public TextView oneRMHistoryTV;
    public Button addExerciseBtn;
    private YouTubePlayerView youTubePlayerViewExercises;
    private Button playVideoBtn;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private TextView TV17;
    private TextView TV18;
    private TextView TV19;
    private TextView TV20;
    private TextView TV21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        exerciseNameTV=findViewById(R.id.histExerciseName);
        exerciseDescTV= findViewById(R.id.exerciseDesc);
        addDateET = findViewById(R.id.addDate);
        addWeightET = findViewById(R.id.addWeight);
        addRepsET = findViewById(R.id.addReps);
        oneRMHistoryTV = findViewById(R.id.oneRM);
        addExerciseBtn = findViewById(R.id.recordHistory);
        playVideoBtn = findViewById(R.id.playYoutube);
        youTubePlayerViewExercises = findViewById(R.id.youtubePlayer);
        TV17 = findViewById(R.id.textView17);
        TV18 = findViewById(R.id.textView18);
        TV19 = findViewById(R.id.textView19);
        TV20 = findViewById(R.id.textView20);
        TV21 = findViewById(R.id.textView21);



        Intent intent = getIntent();
        final int exerciseID = intent.getIntExtra("exerciseID",0);
        final AppDatabase db = AppDatabase.getInstance(this);

        Exercise exercise = db.exerciseDao().findExerciseByID(exerciseID);

        if (exerciseID == 111 || exerciseID == 192 || exerciseID == 105 || exerciseID == 229 ) {
            onInitializedListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    String url = db.youtubeConfigDAO().getYoutubeURL(exerciseID);
                    youTubePlayer.loadVideo(url);


                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };

            playVideoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    youTubePlayerViewExercises.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
                }
            });

        }
        else {
            playVideoBtn.setVisibility(View.GONE);
            youTubePlayerViewExercises.setVisibility(View.GONE);
            addWeightET.setVisibility(View.GONE);
            addRepsET.setVisibility(View.GONE);
            addDateET.setVisibility(View.GONE);
            addExerciseBtn.setVisibility(View.GONE);
            TV17.setVisibility(View.GONE);
            TV18.setVisibility(View.GONE);
            TV19.setVisibility(View.GONE);
            TV20.setVisibility(View.GONE);
            TV21.setVisibility(View.GONE);
            addExerciseBtn.setVisibility(View.GONE);


        }





        exerciseNameTV.setText(exercise.getExerciseName());
        exerciseDescTV.setText(Html.fromHtml(exercise.getExerciseInstructions()));

        addExerciseBtn = findViewById(R.id.recordHistory);
        addExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                addHistory();
            }
        }) ;





    }

    public void addHistory () {
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        if (String.valueOf(addDateET.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Can't Add Because Date Field isn't filled", Toast.LENGTH_SHORT).show();
        }
        else if (String.valueOf(addRepsET.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Can't Add Because Reps Field isn't filled", Toast.LENGTH_SHORT).show();
        }

        else if (String.valueOf(addWeightET.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Can't Add Because Weight Field isn't filled", Toast.LENGTH_SHORT).show();
        }
        else {

            int id = db.historyDao().getAll().size();
            id += 1;
            String exerciseName1 = (String) exerciseNameTV.getText();
            double w =  Double.valueOf(String.valueOf(addWeightET.getText()));
            String date1 = String.valueOf(addDateET.getText());
            int r = Integer.valueOf(String.valueOf(addRepsET.getText()));
            double oneRM1 =  Math.round((w * (1 + Double.valueOf(r) / 30))*100) /100;
            oneRMHistoryTV.setText(String.valueOf(oneRM1));


            History history = new History(id, exerciseName1, w, date1, r, oneRM1);

            db.historyDao().addHistory(history);
            Toast.makeText(getApplicationContext(),"Exercise Submitted to History " , Toast.LENGTH_SHORT).show();





        }

    }


}
