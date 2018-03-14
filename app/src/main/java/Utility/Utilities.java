package Utility;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by PC on 03/03/2018.
 */

public class Utilities {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    public static final String OPEN_API = "3c8a435aa6d40a43683d8ae3e10ade7b";


    //Throws exeption if soemthing goes wrong with the internet connection
    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException {
      return jsonObject.getString(tagName);
    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }
}
