package com.company.lesson7DZ.DZ7;



import com.company.lesson7DZ.DZ7.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException;

}
