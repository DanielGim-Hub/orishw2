package itis.oris_hw02.controllers;

import itis.oris_hw02.dto.WeatherDto;
import itis.oris_hw02.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // отображение формы ввода города
    @GetMapping
    public String getWeatherPage() {
        return "weather_page";
    }

    // получение погоды в формате JSON
    @GetMapping("/current")
    @ResponseBody
    public WeatherDto getCurrentWeather(@RequestParam("city") String city) {
        return weatherService.getCurrentWeather(city);
    }

    // отображение результата на HTML-странице
    @PostMapping
    public String showWeather(
            @RequestParam("city") String city,
            Model model
    ) {
        WeatherDto weather = weatherService.getCurrentWeather(city);
        model.addAttribute("weather", weather);
        return "weather_page";
    }
}
