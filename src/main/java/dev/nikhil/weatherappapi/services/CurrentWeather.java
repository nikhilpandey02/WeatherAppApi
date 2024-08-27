package dev.nikhil.weatherappapi.services;


import dev.nikhil.weatherappapi.dtos.WeatherAppDto;
import dev.nikhil.weatherappapi.model.Weather;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class CurrentWeather {

   // private String id = "4fcee1929729888c494e4f1d0ff070cc";
   @Value("${ApiKey}")
   private String id;


    public List<Weather> getValue(double lat, double lon) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.openweathermap.org/geo/1.0/reverse?lat={lat}&lon={lon}&limit={limit}&appid={id}";

        // Expand the URI template with actual values
        List<WeatherAppDto> weatherAppDto = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WeatherAppDto>>() {},
                lat, lon, 5, id
        ).getBody();
        List<Weather> weather=new ArrayList<>();
        System.out.println(weather.size());
        // Handle the case where the response might be null
        if (weatherAppDto.size() == 0) {
            throw new RuntimeException("Failed to retrieve weather data");
        }
        for(WeatherAppDto w:weatherAppDto)
        {
            weather.add(convertDtoToCurrentWeather(w));
        }

        return weather;
    }

    public Weather convertDtoToCurrentWeather(WeatherAppDto dto) {
        Weather weather = new Weather();
        weather.setName(dto.getName());
        weather.setCountry(dto.getCountry());
        weather.setLat(dto.getLat());
        weather.setLon(dto.getLon());

        return weather;
    }
}