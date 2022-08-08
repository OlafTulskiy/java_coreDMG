package com.company.lesson7DZ.DZ7;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseRepositorySQLiteimpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteimpl() {
        filename = "lesson8db.db";
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:lesson8db.db");
        return connection;
    }

    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherResponse weatherData, String sityName) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, sityName);
            saveWeather.setString(2, weatherData.getLocalObservationDateTime());
            saveWeather.setString(3, weatherData.getWeatherText());
            saveWeather.setDouble(4, weatherData.getTemperature().getMetric().getValue());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public ArrayList<WeatherData> getAllSavedData(String sityName) throws IOException, SQLException {
        String gatAllRecords = "SELECT * FROM weather WHERE city = '" + sityName + "'";
//        ArrayList<WeatherData> myWeather = new ArrayList<WeatherData>();
//        Statement statement = this.getConnection().createStatement();
//        ResultSet resultSet = statement.executeQuery(gatAllRecords);
//        while(resultSet.next()) {
//            myWeather.add(new WeatherData(resultSet.getString(1),
//                    resultSet.getString(2),
//                    resultSet.getString(3),
//                    resultSet.getDouble(4)));
//        }
        //========
        ArrayList<WeatherData> myWeather = new ArrayList<WeatherData>();

        try ( Statement statement = this.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(gatAllRecords);
            while(resultSet.next()) {
            myWeather.add(new WeatherData(resultSet.getString("city"),
                    resultSet.getString("date_time"),
                    resultSet.getString("weather_text"),
                    resultSet.getDouble("temperature")));
            }
            return  myWeather;
        } catch (SQLException e) {
            e.printStackTrace();;
            return myWeather;
        }

    }
}
