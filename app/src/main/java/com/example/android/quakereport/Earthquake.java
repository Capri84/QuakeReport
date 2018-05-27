package com.example.android.quakereport;

/**
 * Created by Capri on 25.04.2018.
 */

public class Earthquake {

    private double mMagnitude;
    private String mCity;
    private long mTimeInMilliseconds;
    private String mUrl;

    // Create a new Earthquake object.
    public Earthquake(double magnitude, String city, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mCity = city;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    // Get the magnitude of the earthquake.
    public double getMagnitude() {
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

    // Get the url of the earthquake.
    public String getUrl() {
        return mUrl;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "mMagnitude=" + mMagnitude +
                ", mCity='" + mCity + '\'' +
                ", mTimeInMilliseconds=" + mTimeInMilliseconds +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
