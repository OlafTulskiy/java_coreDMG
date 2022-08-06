package com.company.lesson7DZ.DZ7;

public class WeatherData {
    private String city;
    private String localDate;
    private String weatrherText;
    private Double temperature;

    public WeatherData(String city, String localDate, String weatrherText, Double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatrherText = weatrherText;
        this.temperature = temperature;
    }

}
