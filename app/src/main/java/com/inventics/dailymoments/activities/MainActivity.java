package com.inventics.dailymoments.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.inventics.dailymoments.R;
import com.inventics.dailymoments.adapter.DailyCoordinatesAdapter;
import com.inventics.dailymoments.databinding.ActivityMainBinding;
import com.inventics.dailymoments.modal.DailyCoordinatesModal;
import com.inventics.dailymoments.util.IntentUtils;
import com.inventics.dailymoments.util.StatusBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DailyCoordinatesModal> data = new ArrayList<>();
    DailyCoordinatesAdapter mAdapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        makeChangesToStatusBar();

        makeChangesToActionBar();

        handleOnClickListener();

        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));
        data.add(new DailyCoordinatesModal("momentName1", "date1", "source1", "destination1", "total_distance1"));

        mAdapter = new DailyCoordinatesAdapter(getApplicationContext(),data);
        binding.rvDailyMoments.setAdapter(mAdapter);
        
    }

    private void handleOnClickListener() {
        binding.historyActionBar.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.startIntentToAnotherActivity(getApplicationContext(),MapsActivity.class);
                finish();
            }
        });
    }

    private void makeChangesToStatusBar() {
        StatusBar.setStatusBackgroundToWhite(MainActivity.this);
        StatusBar.setStatusIconToBlack(MainActivity.this);
    }

    private void makeChangesToActionBar(){
        binding.historyActionBar.tvDailyMoments.setText("Your Moments");
    }

}