package com.example.cocoweather.util;

import android.text.TextUtils;

import com.example.cocoweather.db.City;
import com.example.cocoweather.db.County;
import com.example.cocoweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jun.Zhou on 2018/4/11.
 */

public class Utility {

    public static boolean handleProvinceRespond(String respond){
        if (!TextUtils.isEmpty(respond)){
            try {
                JSONArray allProvinces = new JSONArray(respond);
                for (int i = 0; i < allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }


    public static boolean handleCityRespond(String respond,  int provinceId){
        if (!TextUtils.isEmpty(respond)){
            try {
                JSONArray allCities = new JSONArray(respond);
                for (int i = 0; i < allCities.length(); i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }



    public static boolean handleCountyRespond(String respond,  int cityId){
        if (!TextUtils.isEmpty(respond)){
            try {
                JSONArray allCounties = new JSONArray(respond);
                for (int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

}
