package com.example.a1.ret;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Item {

    String title;
    String lat;
    @SerializedName("long")
    String loong;
    String link;
    String pubDate;
    Condition condition;
    Guid guid;
    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;

    public List<Forecast>  getForecast() {
        return forecast;
    }

    public String getTitle() {
        return title;
    }

    public String getLat() {
        return lat;
    }

    public String getLoong() {
        return loong;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public Guid getGuid() {
        return guid;
    }
}
