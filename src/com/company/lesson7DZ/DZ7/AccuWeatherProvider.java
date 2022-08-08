package com.company.lesson7DZ.DZ7;

import com.company.lesson7DZ.DZ7.enums.Periods;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    static Properties prop = new Properties();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {

        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {

            HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

            Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
            //===================================

            //=================================
            Response response = client.newCall(request).execute();

            ObjectMapper objectMapper = new ObjectMapper();

            //Почему-то так не сработало. Пришлось через массив
            //ArrayList<WeatherResponse> ourresp = objectMapper.readValue(response.body().string(), new TypeReference<ArrayList<WeatherResponse>>() {});
            WeatherResponse[] ourresp = objectMapper.readValue(response.body().string(), WeatherResponse[].class);
            System.out.println("Temperature in city now is - " + ourresp[0].getTemperature().getMetric().getValue() + " C");
            System.out.println("And weather is - " + ourresp[0].getWeatherText());

            DatabaseRepositorySQLiteimpl db = new DatabaseRepositorySQLiteimpl();
            db.createTableIfNotExists();
            db.saveWeatherData(ourresp[0],ApplicationGlobalState.getInstance().getSelectedCity());

            System.out.println("===========================");

            // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
            //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
            //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
        } else if(periods.equals(Periods.FIVE_DAYS)){

            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment("forecasts")
                    .addPathSegment(API_VERSION)
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();
            //===================================

            String jsonResponse = client.newCall(request).execute().body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse5day weatherOn5day = objectMapper.readValue(jsonResponse, WeatherResponse5day.class);
            for (int i = 0; i < 5; i++) {
                printMessage(i,weatherOn5day);
            }

        }
        else if(periods.equals(Periods.CUSTOM)){
            DatabaseRepositorySQLiteimpl db = new DatabaseRepositorySQLiteimpl();
            //ArrayList<WeatherData> myWeather = new ArrayList<WeatherData>();

            //System.out.println("You are in 3 point of menu");

        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
            .scheme("http")
            .host(BASE_HOST)
            .addPathSegment("locations")
            .addPathSegment(API_VERSION)
            .addPathSegment("cities")
            .addPathSegment("autocomplete")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("q", selectedCity)
            .build();

        Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(detectLocationURL)
            .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unable to read city information. " +
                "Answer code from server = " + response.code() + " answer body = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Searching for a city " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Find city " + cityName + " in country " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/source/lesson6.properties")){
            prop.load(configFile);
        }
    }

    private void printMessage( int numberOfDats, WeatherResponse5day ss) {
        System.out.println("In city - " + ApplicationGlobalState.getInstance().getSelectedCity() + " on date - "+ss.getDailyForecasts().get(numberOfDats).getDate()+
                " will be weather in day - " + ss.getDailyForecasts().get(numberOfDats).getDay().getIconPhrase()+
                " and in night - "+ss.getDailyForecasts().get(numberOfDats).getNight().getIconPhrase()+
                ". Temperature at minimum - "+ converteFromFtoC(ss.getDailyForecasts().get(numberOfDats).getTemperature().getMinimum().getValue())+
                "C and at maximum - "+ converteFromFtoC(ss.getDailyForecasts().get(numberOfDats).getTemperature().getMaximum().getValue())+"C.");

        System.out.println("===========================");
    }

    private String converteFromFtoC(double gradusFarengate) {
        return String.format("%.2f",((gradusFarengate - 32)/ 1.8));
    }
}
