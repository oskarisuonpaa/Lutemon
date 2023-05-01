package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.TrainingAreaFragment;
import com.example.lutemon.storage.DuelArena;
import com.example.lutemon.storage.Graveyard;
import com.example.lutemon.storage.Home;
import com.example.lutemon.storage.TrainingArea;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    Home home;
    TrainingArea trainingArea;
    DuelArena duelArena;
    Graveyard graveyard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiating storages
        home = new Home();
        trainingArea = new TrainingArea();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = new HomeFragment();
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new TrainingAreaFragment();
                        break;
                    case 2:
                        // fragment = new DuelArenaFragment();
                        break;
                    case 3:
                        // fragment = new GraveyardFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public Home getHome() {
        return home;
    }

    public TrainingArea getTrainingArea() { return trainingArea;}
}