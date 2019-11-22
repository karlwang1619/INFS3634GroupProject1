package com.example.infs3634groupproject.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.infs3634groupproject.Database.AppDatabase;
import com.example.infs3634groupproject.Fragment.ExerciseFragment;
import com.example.infs3634groupproject.Fragment.HistoryFragment;
import com.example.infs3634groupproject.Fragment.ProfileFragment;
import com.example.infs3634groupproject.Fragment.TopViewFragment;
import com.example.infs3634groupproject.Model.ApiResponse;
import com.example.infs3634groupproject.Model.YoutubeConfig;
import com.example.infs3634groupproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final AppDatabase db = AppDatabase.getInstance(getApplicationContext());




        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://wger.de/api/v2/exercise/?language=2&limit=199&status=2";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                ApiResponse apiResponse = gson.fromJson(response, ApiResponse.class);

                db.exerciseDao().insertAll(apiResponse.results);

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"The Request Failed " +error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };



        bottomNavMenu = findViewById(R.id.nav_menu);
        bottomNavMenu.setSelectedItemId(R.id.menu_exercise);
        bottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the menu of the BottomnNavigationView
                // The menu is chunked out as bottom_nav_menu.xml in the res > menu folder
                if (menuItem.getItemId() == R.id.menu_exercise) {
                    Fragment fragment = new ExerciseFragment();
                    swapMainFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.menu_history) {
                    Fragment fragment = new HistoryFragment();
                    swapMainFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.menu_profile) {
                    Fragment fragment = new ProfileFragment();
                    swapMainFragment(fragment);
                    return true;
                }
                return false;
            }
        });

        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Fragment fragment1 = new TopViewFragment();
                Fragment fragment = new ExerciseFragment();
                setTopFragment(fragment1);

                createYoutubeTable();
                swapMainFragment(fragment);
                // do something
            }
        }, 5000);


    }

    public void swapMainFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }

    public void setTopFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.topView, fragment);
        fragmentTransaction.commit();

    }

    public void createYoutubeTable() {
        AppDatabase db = AppDatabase.getInstance(getApplicationContext());

        YoutubeConfig squatVideo = new YoutubeConfig(111, "Dy28eq2PjcM");
        YoutubeConfig benchVideo = new YoutubeConfig(192, "gRVjAtPip0Y");
        YoutubeConfig deadliftVideo = new YoutubeConfig(105, "-4qRntuXBSc");
        YoutubeConfig ohpVideo = new YoutubeConfig(229, "F3QY5vMz_6I");

        db.youtubeConfigDAO().addYoutubeVideo(squatVideo);
        db.youtubeConfigDAO().addYoutubeVideo(benchVideo);
        db.youtubeConfigDAO().addYoutubeVideo(deadliftVideo);
        db.youtubeConfigDAO().addYoutubeVideo(ohpVideo);


    }
}
