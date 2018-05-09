package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Capri on 25.04.2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    String locOffset;
    String primaryLoc;
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquake currentQuake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magToDisplay = formatter.format(currentQuake.getMagnitude());
        magnitude.setText(magToDisplay);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView primaryLocation = (TextView) listItemView.findViewById(R.id.primary_location);
        String originalLocation = currentQuake.getCity();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] locationParts = originalLocation.split(LOCATION_SEPARATOR);
            locOffset = locationParts[0] + LOCATION_SEPARATOR;
            primaryLoc = locationParts[1];
        } else {
            locOffset = getContext().getString(R.string.near_the);
            primaryLoc = currentQuake.getCity();
        }
        locationOffset.setText(locOffset);
        primaryLocation.setText(primaryLoc);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentQuake.getTimeInMilliseconds());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(dateToDisplay);

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(dateObject);
        time.setText(timeToDisplay);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
