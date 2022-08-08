package com.company.lesson7DZ.DZ7;

public class WeatherData {
    private String city;
    private String localDate;
    private String weatrherText;
    private Double temperatureFromDB;

    public WeatherData(String city, String localDate, String weatrherText, Double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatrherText = weatrherText;
        this.temperatureFromDB = temperature;
    }

    public String getCity() {
        return this.city;
    }
    public String setLocalDate() {
        return  this.localDate;
    }
    public String weatherText() {
        return this.weatrherText;
    }
    public Double getTemperatureFromDB() {
        return this.temperatureFromDB;
    }

}
