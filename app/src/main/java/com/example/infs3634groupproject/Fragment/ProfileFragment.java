package com.example.infs3634groupproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.infs3634groupproject.Database.AppDatabase;
import com.example.infs3634groupproject.R;

import java.util.Collections;
import java.util.List;

public class ProfileFragment extends Fragment {

    private TextView userNameTV;
    private TextView userAgeTV;
    private TextView userGenderTV;
    private TextView userWeightTV;
    private TextView squatPRTV;
    private TextView benchPRTV;
    private TextView deadliftPRTV;
    private TextView ohpPRTV;
    private ImageView squat1IV;
    private ImageView squat2IV;
    private ImageView squat3IV;
    private ImageView squat4IV;
    private ImageView squat5IV;
    private ImageView bench1IV;
    private ImageView bench2IV;
    private ImageView bench3IV;
    private ImageView bench4IV;
    private ImageView bench5IV;
    private ImageView deadlift1IV;
    private ImageView deadlift2IV;
    private ImageView deadlift3IV;
    private ImageView deadlift4IV;
    private ImageView deadlift5IV;
    private ImageView ohp1IV;
    private ImageView ohp2IV;
    private ImageView ohp3IV;
    private ImageView ohp4IV;
    private ImageView ohp5IV;
    private ImageView userProfile;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        squatPRTV = view.findViewById(R.id.squatPR);
        benchPRTV = view.findViewById(R.id.benchPR);
        deadliftPRTV = view.findViewById(R.id.deadliftPR);
        ohpPRTV = view.findViewById(R.id.ohpPR);
        squat1IV=view.findViewById(R.id.squat1);
        squat2IV =view.findViewById(R.id.sqaut2);
        squat3IV = view.findViewById(R.id.squat3);
        squat4IV = view.findViewById(R.id.squat4);
        squat5IV = view.findViewById(R.id.squat5);
        bench1IV = view.findViewById(R.id.bench1);
        bench2IV = view.findViewById(R.id.bench2);
        bench3IV = view.findViewById(R.id.bench3);
        bench4IV = view.findViewById(R.id.bench4);
        bench5IV = view.findViewById(R.id.bench5);
        deadlift1IV = view.findViewById(R.id.deadlift1);
        deadlift2IV = view.findViewById(R.id.deadlift2);
        deadlift3IV = view.findViewById(R.id.deadlift3);
        deadlift4IV = view .findViewById(R.id.deadlift4);
        deadlift5IV = view.findViewById(R.id.deadlift5);
        ohp1IV = view.findViewById(R.id.ohp1);
        ohp2IV = view.findViewById(R.id.ohp2);
        ohp3IV = view.findViewById(R.id.ohp3);
        ohp4IV = view.findViewById(R.id.ohp4);
        ohp5IV = view.findViewById(R.id.ohp5);
        userProfile = view.findViewById(R.id.userPhoto);





        List<Double> squatHistory = getPB("Squats");
        List<Double> benchHistory = getPB("Bench Press");
        List<Double> deadliftHistory = getPB("Deadlifts");
        List<Double> ohpHistory = getPB("Military Press");


        //handle what happens if there's no data available

        String errorMessage = "No Data Available";

        //handle setting Prs
            if(squatHistory.size() == 0) {
                squatPRTV.setText(errorMessage);
            }
            else {
                double squatPR = Collections.max(squatHistory);
                squatPRTV.setText(String.valueOf(squatPR)+ "kg");
            }

            if (benchHistory.size() == 0) {

                benchPRTV.setText(errorMessage);
            }
            else {
                double benchPR = Collections.max(benchHistory);
                benchPRTV.setText(String.valueOf(benchPR)+ "kg");

            }

            if(deadliftHistory.size() == 0) {
                deadliftPRTV.setText(errorMessage);

            }
            else {

                double deadliftPR = Collections.max(deadliftHistory);
                deadliftPRTV.setText(String.valueOf(deadliftPR)+ "kg");
            }

            if(ohpHistory.size() == 0) {
                ohpPRTV.setText(errorMessage);

            }
            else {
                double ohpPR = Collections.max(ohpHistory);
                ohpPRTV.setText(String.valueOf(ohpPR)+ "kg");
            }



        //squat medals

        double squatPR;
        if (squatHistory.size() == 0) {
             squatPR = 0;
        }
        else {
            squatPR = Collections.max(squatHistory);
        }

        if (squatPR <= 60.00) {
            squat1IV.setVisibility(View.VISIBLE);
            squat2IV.setVisibility(View.INVISIBLE);
            squat3IV.setVisibility(View.INVISIBLE);
            squat4IV.setVisibility(View.INVISIBLE);
            squat5IV.setVisibility(View.INVISIBLE);
        }
        else if (squatPR <= 100.00) {
            squat1IV.setVisibility(View.VISIBLE);
            squat2IV.setVisibility(View.VISIBLE);
            squat3IV.setVisibility(View.INVISIBLE);
            squat4IV.setVisibility(View.INVISIBLE);
            squat5IV.setVisibility(View.INVISIBLE);
        }
        else if (squatPR <= 130.00) {
            squat1IV.setVisibility(View.VISIBLE);
            squat2IV.setVisibility(View.VISIBLE);
            squat3IV.setVisibility(View.VISIBLE);
            squat4IV.setVisibility(View.INVISIBLE);
            squat5IV.setVisibility(View.INVISIBLE);

        }
        else if (squatPR <= 160.00) {
            squat1IV.setVisibility(View.VISIBLE);
            squat2IV.setVisibility(View.VISIBLE);
            squat3IV.setVisibility(View.VISIBLE);
            squat4IV.setVisibility(View.VISIBLE);
            squat5IV.setVisibility(View.INVISIBLE);
        }
        else if (squatPR >160.00 ){
            squat1IV.setVisibility(View.VISIBLE);
            squat2IV.setVisibility(View.VISIBLE);
            squat3IV.setVisibility(View.VISIBLE);
            squat4IV.setVisibility(View.VISIBLE);
            squat5IV.setVisibility(View.VISIBLE);
        }

        //Bench Medals



        double benchPr;
        if (benchHistory.size() == 0) {
            benchPr = 0;
        }
        else {
            benchPr = Collections.max(benchHistory);
        }
        if (benchPr <= 45.00) {
            bench1IV.setVisibility(View.VISIBLE);
            bench2IV.setVisibility(View.INVISIBLE);
            bench3IV.setVisibility(View.INVISIBLE);
            bench4IV.setVisibility(View.INVISIBLE);
            bench5IV.setVisibility(View.INVISIBLE);
        }
        else if (benchPr <= 65.00) {
            bench1IV.setVisibility(View.VISIBLE);
            bench2IV.setVisibility(View.VISIBLE);
            bench3IV.setVisibility(View.INVISIBLE);
            bench4IV.setVisibility(View.INVISIBLE);
            bench5IV.setVisibility(View.INVISIBLE);
        }
        else if (benchPr <= 90.00) {
            bench1IV.setVisibility(View.VISIBLE);
            bench2IV.setVisibility(View.VISIBLE);
            bench3IV.setVisibility(View.VISIBLE);
            bench4IV.setVisibility(View.INVISIBLE);
            bench5IV.setVisibility(View.INVISIBLE);

        }
        else if (benchPr <= 120) {
            bench1IV.setVisibility(View.VISIBLE);
            bench2IV.setVisibility(View.VISIBLE);
            bench3IV.setVisibility(View.VISIBLE);
            bench4IV.setVisibility(View.VISIBLE);
            bench5IV.setVisibility(View.INVISIBLE);
        }
        else if (benchPr >120 ){
            bench1IV.setVisibility(View.VISIBLE);
            bench2IV.setVisibility(View.VISIBLE);
            bench3IV.setVisibility(View.VISIBLE);
            bench4IV.setVisibility(View.VISIBLE);
            bench5IV.setVisibility(View.VISIBLE);
        }

        //deadlift


        double deadliftPR;
        if (deadliftHistory.size() == 0) {
            deadliftPR = 0;
        }
        else {
            deadliftPR = Collections.max(deadliftHistory);
        }

        if (deadliftPR <= 75.00) {
            deadlift1IV.setVisibility(View.VISIBLE);
            deadlift2IV.setVisibility(View.INVISIBLE);
            deadlift3IV.setVisibility(View.INVISIBLE);
            deadlift4IV.setVisibility(View.INVISIBLE);
            deadlift5IV.setVisibility(View.INVISIBLE);
        }
        else if (deadliftPR <= 110.00) {
            deadlift1IV.setVisibility(View.VISIBLE);
            deadlift2IV.setVisibility(View.VISIBLE);
            deadlift3IV.setVisibility(View.INVISIBLE);
            deadlift4IV.setVisibility(View.INVISIBLE);
            deadlift5IV.setVisibility(View.INVISIBLE);
        }
        else if (deadliftPR <= 150.00) {
            deadlift1IV.setVisibility(View.VISIBLE);
            deadlift2IV.setVisibility(View.VISIBLE);
            deadlift3IV.setVisibility(View.VISIBLE);
            deadlift4IV.setVisibility(View.INVISIBLE);
            deadlift5IV.setVisibility(View.INVISIBLE);

        }
        else if (deadliftPR <= 190) {
            deadlift1IV.setVisibility(View.VISIBLE);
            deadlift2IV.setVisibility(View.VISIBLE);
            deadlift3IV.setVisibility(View.VISIBLE);
            deadlift4IV.setVisibility(View.VISIBLE);
            deadlift5IV.setVisibility(View.INVISIBLE);
        }
        else if (deadliftPR >240 ){
            deadlift1IV.setVisibility(View.VISIBLE);
            deadlift2IV.setVisibility(View.VISIBLE);
            deadlift3IV.setVisibility(View.VISIBLE);
            deadlift4IV.setVisibility(View.VISIBLE);
            deadlift5IV.setVisibility(View.VISIBLE);
        }

        //OHP

        double ohpPR;
        if (ohpHistory.size() == 0) {
            ohpPR = 0;
        }
        else {
            ohpPR = Collections.max(ohpHistory);
        }


        if (ohpPR <= 30.00) {
            ohp1IV.setVisibility(View.VISIBLE);
            ohp2IV.setVisibility(View.INVISIBLE);
            ohp3IV.setVisibility(View.INVISIBLE);
            ohp4IV.setVisibility(View.INVISIBLE);
            ohp5IV.setVisibility(View.INVISIBLE);
        }
        else if (ohpPR <= 45) {
            ohp1IV.setVisibility(View.VISIBLE);
            ohp2IV.setVisibility(View.VISIBLE);
            ohp3IV.setVisibility(View.INVISIBLE);
            ohp4IV.setVisibility(View.INVISIBLE);
            ohp5IV.setVisibility(View.INVISIBLE);
        }
        else if (ohpPR <= 60) {
            ohp1IV.setVisibility(View.VISIBLE);
            ohp2IV.setVisibility(View.VISIBLE);
            ohp3IV.setVisibility(View.VISIBLE);
            ohp4IV.setVisibility(View.INVISIBLE);
            ohp5IV.setVisibility(View.INVISIBLE);

        }
        else if (ohpPR <= 77) {
            ohp1IV.setVisibility(View.VISIBLE);
            ohp2IV.setVisibility(View.VISIBLE);
            ohp3IV.setVisibility(View.VISIBLE);
            ohp4IV.setVisibility(View.VISIBLE);
            ohp5IV.setVisibility(View.INVISIBLE);
        }
        else if (ohpPR >97 ){
            ohp1IV.setVisibility(View.VISIBLE);
            ohp2IV.setVisibility(View.VISIBLE);
            ohp3IV.setVisibility(View.VISIBLE);
            ohp4IV.setVisibility(View.VISIBLE);
            ohp5IV.setVisibility(View.VISIBLE);
        }

        double totalPR = squatPR + deadliftPR + benchPr + ohpPR;

        if (totalPR < 210) {
            userProfile.setImageResource(R.drawable.avatar1);

        }
        else if (totalPR< 500) {
            userProfile.setImageResource(R.drawable.avatar2);
        }
        else if (totalPR>500) {
            userProfile.setImageResource(R.drawable.avatar3);
        }





        return view;
    }

    public List<Double> getPB(String exerciseName) {
        AppDatabase db = AppDatabase.getInstance(getContext());
        return db.historyDao().getPB(exerciseName);

    }






}


