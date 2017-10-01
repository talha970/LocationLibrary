package com.example.locationlibrary.Providers;

import android.content.Context;
import android.location.Location;

import com.example.locationlibrary.LocationParams;

/**
 * Created by tjaved on 9/30/17.
 */

public interface ProviderContract {
    void init(Context context);
    void start(OnLocationUpdatedListener listener, LocationParams params,boolean singleUpdate);
    void stop();
    Location getLastLocation();
}
