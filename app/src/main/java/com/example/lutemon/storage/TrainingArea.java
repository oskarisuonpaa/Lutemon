package com.example.lutemon.storage;

import android.os.Handler;
import android.util.Log;

import com.example.lutemon.fragments.TrainingAreaFragment;
import com.example.lutemon.lutemon.Lutemon;

import java.util.Map;


public class TrainingArea extends Storage {
    public TrainingArea() {
        super("Training Area");
    }

    @Override
    public void addLutemon(Lutemon lutemon) {
        super.addLutemon(lutemon);
        lutemon.setNextExperienceGain(System.currentTimeMillis() + 10000);
    }

    public void train() {
        Handler handler = new Handler();
        int delay = 1000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!getLutemons().isEmpty()) {
                    for (Map.Entry<Integer, Lutemon> entry : lutemons.entrySet()) {
                        Lutemon lutemon = entry.getValue();
                        if (System.currentTimeMillis() >= lutemon.getNextExperienceGain()) {
                            lutemon.gainExperience(1);
                            lutemon.setNextExperienceGain(System.currentTimeMillis() + 10000);
                            TrainingAreaFragment.getInstance().updateView();
                        }
                    }
                }
                handler.postDelayed(this, delay);
            }
        }, delay);
    }
}
