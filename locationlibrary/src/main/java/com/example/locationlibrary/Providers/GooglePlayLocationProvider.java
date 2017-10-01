package com.example.locationlibrary.Providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.locationlibrary.LocationParams;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static com.example.locationlibrary.LocationAccuracy.HIGH;
import static com.example.locationlibrary.LocationAccuracy.LOW;
import static com.example.locationlibrary.LocationAccuracy.LOWEST;
import static com.example.locationlibrary.LocationAccuracy.MEDIUM;

/**
 * Created by tjaved on 9/30/17.
 */

public class GooglePlayLocationProvider extends LocationCallback implements ProviderContract {
    OnLocationUpdatedListener listener;
    FusedLocationProviderClient client;
    @Override
    public void init(Context context) {

        client=new FusedLocationProviderClient(context);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void start(OnLocationUpdatedListener listener,LocationParams params,boolean singleUpdate) {
        if(listener==null){
            //TODO throw warning
        }
        this.listener=listener;
        client.requestLocationUpdates( createRequest(params,singleUpdate), this,Looper.getMainLooper());

    }

    @Override
    public void onLocationResult(LocationResult locationResult) {
        super.onLocationResult(locationResult);
        for (Location location : locationResult.getLocations()) {
            listener.OnLocationUpdated(location);
        }

    }

    @Override
    public void onLocationAvailability(LocationAvailability locationAvailability) {
        super.onLocationAvailability(locationAvailability);
    }

    @Override
    public void stop() {

    }

    @Override
    public Location getLastLocation() {
        return null;
    }
    private LocationRequest createRequest(LocationParams params, boolean singleUpdate) {
        LocationRequest request = LocationRequest.create()
                .setFastestInterval(params.getInterval())
                .setInterval(params.getInterval())
                .setSmallestDisplacement(params.getDistance());

        switch (params.getAccuracy()) {
            case HIGH:
                request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                break;
            case MEDIUM:
                request.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                break;
            case LOW:
                request.setPriority(LocationRequest.PRIORITY_LOW_POWER);
                break;
            case LOWEST:
                request.setPriority(LocationRequest.PRIORITY_NO_POWER);
                break;
        }

        if (singleUpdate) {
            request.setNumUpdates(1);
        }

        return request;
    }
}
