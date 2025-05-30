package itis.oris_hw02.services;

import itis.oris_hw02.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getCurrentWeather(String city);
}
