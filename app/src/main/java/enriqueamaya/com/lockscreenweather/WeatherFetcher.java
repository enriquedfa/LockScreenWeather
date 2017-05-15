package enriqueamaya.com.lockscreenweather;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by enriq on 5/15/2017.
 */

public class WeatherFetcher {

    private static final String DARK_SKY_KEY = "d7e72c9a32dcf7e1ae04b978ed500ce6";
    private static final String DARK_SKY_WEATHER_API = "https://api.darksky.net/forecast/%s/%s,%s";

    public static JSONObject getJSON(Context context, String latitude, String longitude){
        try {
            URL url = new URL(String.format(DARK_SKY_WEATHER_API, DARK_SKY_KEY, latitude, longitude));
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            return data;
        }catch (Exception e){
            return null;
        }
    }

}
