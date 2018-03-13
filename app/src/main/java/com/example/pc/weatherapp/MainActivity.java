package com.example.pc.weatherapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

import Data.JSONp;
import Data.Netconect;
import Model.Weather;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView temp;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    public TextView cityName;
    private TextView sunset;
    private TextView sunrise;
    private TextView wind;
    private TextView cloud;
    private Button btnR;
    private Button btnGO;

    public String kek;

    Weather weather = new Weather();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (TextView) findViewById(R.id.cityText);
        description = (TextView) findViewById(R.id.Desc);
        temp = (TextView) findViewById(R.id.tempText);
        wind = (TextView) findViewById(R.id.Wind);
        cloud = (TextView) findViewById(R.id.Cloud);
        humidity = (TextView) findViewById(R.id.Humidity);
        pressure = (TextView) findViewById(R.id.Pressure);
        sunrise = (TextView) findViewById(R.id.Srise);
        sunset = (TextView) findViewById(R.id.Sset);

        btnR = (Button) findViewById(R.id.btnR);
        btnR.setOnClickListener(MainActivity.this);

        btnGO = (Button) findViewById(R.id.btnGO);
        btnGO.setOnClickListener(MainActivity.this);

        readWheaterData("edinburgh,uk");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnR:
                recreate();
                break;

            case R.id.btnGO:
                Intent activity2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(activity2);
                break;
        }
    }


    public void readWheaterData( String city ) {

        WeaterTask weaterTask = new WeaterTask();
        weaterTask.execute(new String[]{city + "&APPID=" + "3c8a435aa6d40a43683d8ae3e10ade7b"});
    }


    private class WeaterTask extends AsyncTask<String, Void, Weather> {
        @Override
        protected void onPostExecute(Weather weather) {

            super.onPostExecute(weather);


            DateFormat dataFormat = DateFormat.getTimeInstance();

            String sunriseTX = dataFormat.format(new Date(weather.place.getSunrise()));
            String sr = sunriseTX.substring(0,4);


            String sunsetTX = dataFormat.format(new Date(weather.place.getSunset()));
            String st = sunsetTX.substring(0,4);

            DecimalFormat decimalFormat = new DecimalFormat("##.##");

            String temperatureTX = decimalFormat.format(weather.condition.getTemperature()/100);

             kek = temperatureTX;

            cityName.setText(weather.place.getCity() + "," + weather.place.getCountry());

            char sign = 0x00B0;
            temp.setText("" + temperatureTX + sign +"C");

            humidity.setText("Humidity: " + weather.condition.getHumidity() + "%");

            pressure.setText("Pressure: " + weather.condition.getPressure() + "hPa");

            wind.setText("Wind: " + weather.wind.getSpeed() + "mps");

            sunrise.setText("Sunrise: " + sr + " am");

            sunset.setText("Sunset: " + st + " pm");

            cloud.setText("Sky: " + weather.condition.getCondition());

            description.setText(weather.condition.getDescription());

        }

        @Override
        protected Weather doInBackground(String... strings) {

            String data = ( (new Netconect()).getWeatherData(strings[0]));

            weather = JSONp.getWeather(data);

            Log.v("Data: ", weather.place.getCity());

            return weather;
        }




    }

}
