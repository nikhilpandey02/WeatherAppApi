package dev.nikhil.weatherappapi.Controller;

import dev.nikhil.weatherappapi.model.HourlyForecast;
import dev.nikhil.weatherappapi.model.Weather;
import dev.nikhil.weatherappapi.services.CurrentWeather;
import dev.nikhil.weatherappapi.services.HourlyForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired

    private CurrentWeather currentWeather;

    private List<Weather> weather;
    @Autowired

    private HourlyForecastService hourlyForecastService;

    @GetMapping("/lat/{v1}/long/{v2}")
    public ResponseEntity<List<Weather>> getarea(@PathVariable("v1") double v1, @PathVariable("v2") double v2)
    {

        return new ResponseEntity<>(currentWeather.getValue(v1,v2), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/hourly/{v1}/{v2}")
    public ResponseEntity<List<HourlyForecast>> Hourly(@PathVariable("v1") double first, @PathVariable("v2") double sec)
    {

        return new ResponseEntity<>(hourlyForecastService.get4hourdetails(first,sec), HttpStatusCode.valueOf(200));
    }

}
