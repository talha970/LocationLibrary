package com.example.locationlibrary;

/**
 * Created by tjaved on 9/30/17.
 */

public class LocationParams {
    public static final LocationParams NAVIGATION = new Builder().setAccuracy(LocationAccuracy.HIGH).setDistance(0).setInterval(500).build();
    public static final LocationParams BEST_EFFORT = new Builder().setAccuracy(LocationAccuracy.MEDIUM).setDistance(150).setInterval(2500).build();
    public static final LocationParams LAZY = new Builder().setAccuracy(LocationAccuracy.LOW).setDistance(500).setInterval(5000).build();


    private long interval;
    private float distance;
    LocationAccuracy accuracy;

    public LocationParams(LocationAccuracy accuracy, long interval, float distance) {
        this.accuracy=accuracy;
        this.interval=interval;
        this.distance=distance;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public LocationAccuracy getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(LocationAccuracy accuracy) {
        this.accuracy = accuracy;
    }
    public static class Builder {
        private LocationAccuracy accuracy;
        private long interval;
        private float distance;

        public Builder setAccuracy(LocationAccuracy accuracy) {
            this.accuracy = accuracy;
            return this;
        }

        public Builder setInterval(long interval) {
            this.interval = interval;
            return this;
        }

        public Builder setDistance(float distance) {
            this.distance = distance;
            return this;
        }

        public LocationParams build() {
            return new LocationParams(accuracy, interval, distance);
        }
    }
}
