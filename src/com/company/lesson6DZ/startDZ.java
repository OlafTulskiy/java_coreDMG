package com.company.lesson6DZ;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Properties;


public class startDZ {

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {

        loadProperties();
        OkHttpClient client = new OkHttpClient();


        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(prop.getProperty("MOSCOW_KEY"))
                .addQueryParameter("apikey", prop.getProperty("API_KEY"))
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();


        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);

    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/source/lesson6.properties")){
            prop.load(configFile);
        }
    }
}
