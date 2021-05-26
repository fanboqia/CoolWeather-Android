package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray arr = new JSONArray(response);
                for(int i = 0; i < arr.length(); i++){
                    JSONObject obj = arr.getJSONObject(i);
                    String provinceName = obj.getString("name");
                    int id = obj.getInt("id");
                    Province province =  new Province();
                    province.setProvinceCode(id);
                    province.setProvinceName(provinceName);
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的城市级数据
     * @param response
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray arr = new JSONArray(response);
                for(int i = 0; i < arr.length(); i++){
                    JSONObject obj = arr.getJSONObject(i);
                    String cityName = obj.getString("name");
                    int id = obj.getInt("id");
                    City city =  new City();
                    city.setCityCode(id);
                    city.setCityName(cityName);
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * @param response
     * @return
     */
    public static boolean handleCountyResponse(String response, int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray arr = new JSONArray(response);
                for(int i = 0; i < arr.length(); i++){
                    JSONObject obj = arr.getJSONObject(i);
                    String countyName = obj.getString("name");
                    String weather_id = obj.getString("weather_id");
                    County county =  new County();
                    county.setCountyName(countyName);
                    county.setCityId(cityId);
                    county.setWeatherId(weather_id);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
