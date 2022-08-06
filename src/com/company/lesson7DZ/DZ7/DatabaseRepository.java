package com.company.lesson7DZ.DZ7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseRepository {

    boolean saveWeatherData(WeatherResponse weatherData, String sityName) throws SQLException;

    ArrayList<WeatherData> getAllSavedData(String sityName) throws IOException, SQLException;
}
