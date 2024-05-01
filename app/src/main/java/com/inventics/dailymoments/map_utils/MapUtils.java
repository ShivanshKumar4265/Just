package com.inventics.dailymoments.map_utils;

import android.graphics.Color;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapUtils {
    private static final double LUCKNOW_LAT_MIN = 26.5; // Latitude range for Lucknow
    private static final double LUCKNOW_LAT_MAX = 27.3;
    private static final double LUCKNOW_LNG_MIN = 80.9; // Longitude range for Lucknow
    private static final double LUCKNOW_LNG_MAX = 81.2;

    public static void addDemoPolygon(GoogleMap googleMap) {
        if (googleMap != null) {
            List<LatLng> coordinates = generateRandomCoordinates();
            PolygonOptions polygonOptions = new PolygonOptions()
                    .addAll(coordinates)
                    .strokeWidth(5)
                    .strokeColor(Color.RED)
                    .fillColor(Color.argb(100, 255, 0, 0)); // Adjust the alpha (100) for transparency
            Polygon polygon = googleMap.addPolygon(polygonOptions);

            // Add markers for each coordinate in the sequence
            for (int i = 0; i < coordinates.size(); i++) {
                LatLng latLng = coordinates.get(i);
                if(i == 0){
                    googleMap.addMarker(new MarkerOptions().position(latLng).title("Source Point"));
                }else if(i == coordinates.size() -1 ){
                    googleMap.addMarker(new MarkerOptions().position(latLng).title("Last Place"));
                }else{
                    googleMap.addMarker(new MarkerOptions().position(latLng).title("Marker " + (i + 1)));
                }
            }

            // Zoom to fit the entire polygon area
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (LatLng latLng : coordinates) {
                builder.include(latLng);
            }
            LatLngBounds bounds = builder.build();
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
        }
    }

    private static List<LatLng> generateRandomCoordinates() {
        Random random = new Random();
        List<LatLng> coordinates = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Adjust the number of vertices as needed
            double lat = LUCKNOW_LAT_MIN + (LUCKNOW_LAT_MAX - LUCKNOW_LAT_MIN) * random.nextDouble();
            double lng = LUCKNOW_LNG_MIN + (LUCKNOW_LNG_MAX - LUCKNOW_LNG_MIN) * random.nextDouble();
            coordinates.add(new LatLng(lat, lng));
        }
        return coordinates;
    }
}

