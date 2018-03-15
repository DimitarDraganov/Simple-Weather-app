package Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Model.Place;
import Model.Weather;
import Utility.Utilities;

/**
 * Created by PC on 04/03/2018.
 */

public class JSONp {

    public static Weather getWeather(String data) {

        Weather weather = new Weather();


        //We get the data from the Openweathermap databese and parse it with JSON into the weather array
        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();

            JSONObject coordOBj = Utilities.getObject("coord", jsonObject);

            JSONObject windOBj = Utilities.getObject("wind", jsonObject);

            place.setCity(Utilities.getString("name", jsonObject));


            JSONObject cloudOBj = Utilities.getObject("clouds", jsonObject);

            JSONObject sysOBj = Utilities.getObject("sys", jsonObject);
            place.setCountry(Utilities.getString("country", sysOBj));
            place.setSunrise(Utilities.getInt("sunrise", sysOBj));
            place.setSunset(Utilities.getInt("sunset", sysOBj));

            weather.place = place;

            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.condition.setWeatherId(Utilities.getInt("id", jsonWeather));
            weather.condition.setDescription(Utilities.getString("description", jsonWeather));
            weather.condition.setCondition(Utilities.getString("main", jsonWeather));

            JSONObject mainOBj = Utilities.getObject("main", jsonObject);
            weather.condition.setHumidity(Utilities.getInt("humidity", mainOBj));
            weather.condition.setPressure(Utilities.getInt("pressure", mainOBj));
            weather.condition.setTemperature(Utilities.getDouble("temp", mainOBj));


            weather.wind.setSpeed(Utilities.getFloat("speed", windOBj));
            weather.wind.setDegree(Utilities.getFloat("deg", windOBj));


            weather.clouds.setPrecipitation(Utilities.getInt("all", cloudOBj));

            return weather;

        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }
}
