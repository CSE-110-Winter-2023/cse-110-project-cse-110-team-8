package edu.ucsd.cse110.cse110group8_compass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void onNextClick(View view) {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView error = findViewById(R.id.ErrorText);

        Intent intent = new Intent(this, MainActivity.class);


        TextView latitude = findViewById(R.id.latitudeText);
        TextView longitude = findViewById(R.id.longitudeText);

        System.out.println("latitude: " + latitude.getText().toString());
        System.out.println("longitude: " + longitude.getText().toString());
        Log.i("NumberGenerated", "BEFORE");
        if(latitude.getText().toString().isEmpty()){
            Log.i("NumberGenerated", "Function has generated zero.");
            error.setVisibility(View.VISIBLE);
        }
        else if(longitude.getText().toString().isEmpty()){
            Log.i("NumberGenerated", "Function has generated zero.");
            error.setVisibility(View.VISIBLE);
        }
        else{
            error.setVisibility(View.INVISIBLE);
            String lat = latitude.getText().toString();
            String longit = longitude.getText().toString();
            Pin defaultPin = new Pin();
            Pin parent = new Pin("Testparent",Integer.parseInt(lat),
                    Integer.parseInt(longit));
            intent.putExtra("label", parent.name);
            intent.putExtra("latitude", lat);
            intent.putExtra("longitude", longit);
            startActivity(intent);
        }

    }

    public void onCancelClick(View view) {
        finish();

    }
}