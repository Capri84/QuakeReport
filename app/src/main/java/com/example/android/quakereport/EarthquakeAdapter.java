package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.PatternSyntaxException;

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
        //String formattedMagnitude = String.valueOf(currentQuake.getMagnitude());
        //magnitude.setText(formattedMagnitude);
        magnitude.setText(currentQuake.getMagnitude());

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
        //String formattedDateTime = String.valueOf(currentQuake.getDateTime());
        //dateTime.setText(formattedDateTime);
        date.setText(dateToDisplay);

        TextView time = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(dateObject);
        time.setText(timeToDisplay);

        return listItemView;
    }
}
