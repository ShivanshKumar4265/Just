package com.inventics.dailymoments.activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.inventics.dailymoments.R;
import com.inventics.dailymoments.databinding.ActivityMapsBinding;
import com.inventics.dailymoments.map_utils.MapUtils;
import com.inventics.dailymoments.util.IntentUtils;
import com.inventics.dailymoments.util.StatusBar;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        makeChangesToStatusBar();

        setUpMapFragment();

        makeChangesToActionBar();

        handleOnClickListener();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        MapUtils.addDemoPolygon(mMap);
    }

    private void setUpMapFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void handleOnClickListener() {
        binding.actionbar.ivHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.startIntentToAnotherActivity(getApplicationContext(),MainActivity.class);
            }
        });
    }
    private void makeChangesToStatusBar() {
        StatusBar.setStatusBackgroundToWhite(MapsActivity.this);
        StatusBar.setStatusIconToBlack(MapsActivity.this);
    }
    private void makeChangesToActionBar() {
        binding.actionbar.ivBack.setVisibility(View.GONE);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) binding.actionbar.tvDailyMoments.getLayoutParams();
        layoutParams.setMarginStart(50); // Adjust the margin value as needed
        binding.actionbar.tvDailyMoments.setLayoutParams(layoutParams);
    }




}