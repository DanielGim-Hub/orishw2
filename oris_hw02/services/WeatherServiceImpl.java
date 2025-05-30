package itis.oris_hw02.services;

import itis.oris_hw02.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${openweathermap.url}")
    private String url;

    @Value("${openweathermap.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherDto getCurrentWeather(String city) {
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
            URI uri = new URI(url + "?q=" + encodedCity + "&appid=" + apiKey + "&units=metric&lang=ru");
            @SuppressWarnings("unchecked")
            Map<String, Object> resp = restTemplate.getForObject(uri, Map.class);
            return WeatherDto.fromMap(resp);
        } catch (Exception e) {
            log.error("Ошибка при вызове OpenWeatherMap", e);
            throw new RuntimeException("Не удалось получить данные о погоде");
        }
    }
}
