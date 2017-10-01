package com.example.locationlibrary;

import android.content.Context;
import android.location.LocationListener;
import android.support.annotation.NonNull;

import com.example.locationlibrary.Providers.OnLocationUpdatedListener;
import com.example.locationlibrary.Providers.ProviderContract;

/**
 * Created by tjaved on 9/30/17.
 */

public class LocationLibrary {
    Context context;
    ProviderContract providerContract;


    public LocationLibrary( Context context) {
        this.context = context;
    }

    public static class Builder{
        Context context;

        public Builder(@NonNull Context context) {
            this.context = context;
        }



        public LocationLibrary build(){
            return new LocationLibrary(context);
        }


    }

    public void provider(ProviderContract providerContract){
        this.providerContract=providerContract;

    }
    public void start(OnLocationUpdatedListener listener) {
        if (providerContract == null) {
            throw new RuntimeException("A provider must be initialized");
        }
        providerContract.init(context);
        providerContract.start(listener, LocationParams.BEST_EFFORT, false);
    }
}
