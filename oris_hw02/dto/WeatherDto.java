
package itis.oris_hw02.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class WeatherDto {
    private String city;
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;

    @SuppressWarnings("unchecked")
    public static WeatherDto fromMap(Map<String, Object> map) {
        String city = (String) map.get("name");
        Map<String,Object> main = (Map<String,Object>) map.get("main");
        List<Map<String,Object>> weatherList = (List<Map<String,Object>>) map.get("weather");
        Map<String,Object> wind = (Map<String,Object>) map.get("wind");

        return WeatherDto.builder()
                .city(city)
                .temperature(((Number) main.get("temp")).doubleValue())
                .humidity((Integer) main.get("humidity"))
                .description((String) weatherList.get(0).get("description"))
                .windSpeed(((Number) wind.get("speed")).doubleValue())
                .build();
    }
}
