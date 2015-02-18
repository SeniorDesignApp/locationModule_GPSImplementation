package com.example.cwilliams.locationmodulegpsimplementation_nowifi;

import android.location.Location;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends ActionBarActivity{

    private TextView Lat;
    private TextView Lng;
    private Button LocationB, ClearB;

    // instantiate an object of the class
    locationLIBRARY loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lat = (TextView) findViewById(R.id.Lat_textView);
        Lng = (TextView) findViewById(R.id.Lng);
        LocationB = (Button) findViewById(R.id.location_button);
        ClearB = (Button) findViewById(R.id.clear_button);
    }

    public void showLocation(View v){
        loc = new locationLIBRARY(MainActivity.this);

        if(loc.GPSstatus()){
            double latitude = loc.getLatitude();
            double longitude = loc.getLongitude();

            Lat.setText(String.valueOf(latitude));
            Lng.setText(String.valueOf(longitude));
        }

    }

    public void clearLocation(View v){
        Lat.setText("");
        Lng.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
