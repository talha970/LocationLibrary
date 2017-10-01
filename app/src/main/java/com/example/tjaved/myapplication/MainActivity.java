package com.example.tjaved.myapplication;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.locationlibrary.LocationLibrary;
import com.example.locationlibrary.Providers.GooglePlayLocationProvider;
import com.example.locationlibrary.Providers.OnLocationUpdatedListener;

public class MainActivity extends AppCompatActivity implements OnLocationUpdatedListener{
    TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationLibrary library= new LocationLibrary.Builder(this).build();
        GooglePlayLocationProvider fused = new GooglePlayLocationProvider();
       library.provider(fused);
       library.start(this);
        locationText=  (TextView) findViewById(R.id.tv1);
    }

    @Override
    public void OnLocationUpdated(Location location) {

        locationText.setText(location.toString());


    }
}
