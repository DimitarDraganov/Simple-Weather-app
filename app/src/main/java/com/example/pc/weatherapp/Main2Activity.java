package com.example.pc.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import Data.JSONp;
import Data.Netconect;
import Model.Weather;
import Utility.Utilities;

public class Main2Activity extends AppCompatActivity  {

    private TextView lastupdate;
    public TextView cityName;

    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lastupdate = (TextView) findViewById(R.id.lastUpdate);

        cityName = (TextView) findViewById(R.id.cityText);

        readaWeatherData2("edinburgh,uk");

//        setContentView(R.layout.activity_main2);
    }


    public void readaWeatherData2( String city ) {
        ImportWeather2 importWeather2 = new ImportWeather2();
        importWeather2.execute(new String[]{city + "&APPID=" + Utilities.OPEN_API});
    }


    private class  ImportWeather2 extends AsyncTask<String, Void, Weather> {
        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

      //      lastupdate.setText("Last Update: " + weather.place.getSunrise());
     //


        }

        @Override
        protected Weather doInBackground(String... strings) {

            String data = ( (new Netconect()).getWeatherData(strings[0]));

            weather = JSONp.getWeather(data);

            Log.v("Data: ", weather.place.getCity());

            return null;
        }
    }

}
