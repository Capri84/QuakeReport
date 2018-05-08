package com.example.android.quakereport;

/**
 * Created by Capri on 25.04.2018.
 */

public class Earthquake {

    //private double mMagnitude;
    private String mMagnitude;
    private String mCity;
    private long mTimeInMilliseconds;

    // Create a new Earthquake object.
    public Earthquake(String magnitude, String city, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mCity = city;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    // Get the magnitude of the earthquake.
    //public double getMagnitude() {
    public String getMagnitude() {
        return mMagnitude;
    }

    // Get the city of the earthquake.
    public String getCity() {
        return mCity;
    }

    // Get the date and time of the earthquake.
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "Magnitude=" + mMagnitude +
                ", City='" + mCity + '\'' +
                ", DateTime=" + mTimeInMilliseconds +
                '}';
    }
}
