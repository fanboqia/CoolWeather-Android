package com.coolweather.android.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {

    @SerializedName("comf")
    public Comfort comf;

    @SerializedName("cw")
    public Carwash cw;

    @SerializedName("sport")
    public Sport sport;

    public class Comfort{
        @SerializedName("txt")
        public String info;
    }

    public class Sport{
        @SerializedName("txt")
        public String info;
    }

    public class Carwash{
        @SerializedName("txt")
        public String info;
    }
}
