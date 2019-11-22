package com.example.infs3634groupproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.infs3634groupproject.Database.AppDatabase;
import com.example.infs3634groupproject.R;

import java.util.Collections;
import java.util.List;

public class TopViewFragment extends Fragment {

    private TextView userNameTV;
    private ImageView userSquatTopMedalIV;
    private ImageView userBenchTopMedalIV;
    private ImageView userDeadliftTopMedalIV;
    private ImageView userOHPTopMedalIV;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_topview, container, false);

        AppDatabase db = AppDatabase.getInstance(getContext());


        userNameTV = view.findViewById(R.id.userName);
        userSquatTopMedalIV = view.findViewById(R.id.userSquatTopMedal);
        userBenchTopMedalIV = view.findViewById(R.id.userBenchTopMedal);
        userDeadliftTopMedalIV = view.findViewById(R.id.userDeadliftTopMedal);
        userOHPTopMedalIV = view.findViewById(R.id.userOHPTopMedal);

        //set top bench medal


        List<Double> squatHistory = db.historyDao().getPB("Squats");
        List<Double> benchHistory = db.historyDao().getPB("Bench Press");
        List<Double> deadliftHistory = db.historyDao().getPB("Deadlifts");
        List<Double> ohpHistory = db.historyDao().getPB("Military Press");

        double benchPR;
        if (benchHistory.size() == 0 ) {
            benchPR = 0;
            System.out.println(benchPR);
        }
        else { benchPR = Collections.max(benchHistory);
        System.out.println("bench pr is " +benchPR);

        }

        if (benchPR >= 120) {
            userBenchTopMedalIV.setImageResource(R.drawable.bench5);
        }
        else if (benchPR >= 90) {
            userBenchTopMedalIV.setImageResource(R.drawable.bench4);
        }
        else if ( benchPR >= 65 ) {
            userBenchTopMedalIV.setImageResource(R.drawable.bench3);
        }
        else if (benchPR >= 45) {
            userBenchTopMedalIV.setImageResource(R.drawable.bench2);
        } else if (benchPR < 45) {
            userBenchTopMedalIV.setImageResource(R.drawable.bench1);
        }

        //set top squat medal

        double squatPR;
        if (squatHistory.size() == 0 ) {
            squatPR = 0;
            System.out.println(squatPR);
        }
        else { squatPR =Collections.max(squatHistory);
        System.out.println("Squat pr is " +squatPR);

        }


        if (squatPR >= 160) {
            userSquatTopMedalIV.setImageResource(R.drawable.squat5);
        }
        else if (squatPR >= 130) {
            userSquatTopMedalIV.setImageResource(R.drawable.squat4);
        }
        else if (squatPR >= 100 ) {
            userSquatTopMedalIV.setImageResource(R.drawable.squat3);
        }
        else if (squatPR >= 60) {
            userSquatTopMedalIV.setImageResource(R.drawable.squat2);
        } else if (squatPR < 60) {
            userSquatTopMedalIV.setImageResource(R.drawable.squat1);
        }

        //set top deadlift medal


        double deadliftPR;
        if (deadliftHistory.size() == 0 ) {
            deadliftPR = 0;
            System.out.println(deadliftPR);
        }
        else { deadliftPR = Collections.max(deadliftHistory);
            System.out.println("deadlift PR is " +deadliftPR);

        }


        if (deadliftPR >= 190) {
            userDeadliftTopMedalIV.setImageResource(R.drawable.deadlift5);
        }
        else if (deadliftPR >= 150) {
            userDeadliftTopMedalIV.setImageResource(R.drawable.deadlift4);
        }
        else if (deadliftPR >= 110 ) {
            userDeadliftTopMedalIV.setImageResource(R.drawable.deadlift3);
        }
        else if (deadliftPR >= 75) {
            userDeadliftTopMedalIV.setImageResource(R.drawable.deadlift2);
        } else if (deadliftPR < 75) {
            userDeadliftTopMedalIV.setImageResource(R.drawable.deadlift1);
        }

        //set top ohp medal

        double ohpPR;
        if (ohpHistory.size() == 0 ) {
            ohpPR = 0;
            System.out.println(ohpPR);
        }
        else { ohpPR = Collections.max(ohpHistory);
        System.out.println("ohpPR is " + ohpPR);

        }


        if (ohpPR >= 97) {
            userOHPTopMedalIV.setImageResource(R.drawable.ohp5);
        }
        else if (ohpPR >= 77) {
            userOHPTopMedalIV.setImageResource(R.drawable.ohp4);
        }
        else if (ohpPR >= 60 ) {
            userOHPTopMedalIV.setImageResource(R.drawable.ohp3);
        }
        else if (ohpPR >= 45) {
            userOHPTopMedalIV.setImageResource(R.drawable.ohp2);
        } else if (ohpPR < 45) {
            userOHPTopMedalIV.setImageResource(R.drawable.ohp1);
        }





        return view;
    }
}
