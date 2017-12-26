package com.map.event.model;

import android.content.Context;

import com.map.event.utils.EventObject;
import com.map.event.utils.Poi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MacBookPro on 1/5/17.
 */

public class JsonMode {
    static List<EventObject> eventArray;

    private static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("event.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static List<EventObject> readJson(String events) throws JSONException {
        eventArray = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(events);
        JSONArray jsonArray = jsonObject.getJSONArray("events");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            double[] latln = location(object.getString("location"));
            Poi location = new Poi(latln[0],latln[1]);
            EventObject event = new EventObject(object.getString("title"),
                    object.getInt("id"), object.getInt("category_id"),object.getString("address"),
                    object.getDouble("start_at"),object.getDouble("end_at"),
                    location,object.getBoolean("by_admin"));
        eventArray.add(event);
        }
        return eventArray;
    }

    private static double[] location(String location){
        String[] latln = location.split(",");
        return new double[]{Double.parseDouble(latln[0]),Double.parseDouble(latln[1])};
    }
}
