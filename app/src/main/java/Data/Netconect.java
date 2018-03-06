package Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Utility.Utilities;


/**
 * Created by PC on 03/03/2018.
 */

public class Netconect {
    public String getWeatherData(String place) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {

            //fix this
            connection = (HttpURLConnection) (new URL(Utilities.BASE_URL + place + "&APPID=" + "3c8a435aa6d40a43683d8ae3e10ade7b")).openConnection();



            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.connect();


            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();

            return stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
