package dev.nikhil.weatherappapi.services;

import dev.nikhil.weatherappapi.dtos.HourlyForecastDto;
import dev.nikhil.weatherappapi.model.HourlyForecast;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class HourlyForecastService {

    @Value("${ApiKey}")
    private String id;

    public List<HourlyForecast> get4hourdetails(double lat, double lon) {
        String url = "http://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={id}";

        RestTemplate restTemplate = new RestTemplate();

        // Fetch data from the API and handle the response
        HourlyForecastDto hourlyForecastDtoList = restTemplate.getForObject(
                url,
                HourlyForecastDto.class,
                lat, lon, id
        );

        // Initialize an empty list of HourlyForecast objects
        List<HourlyForecast> hourlyForecastList = new ArrayList<>();

        // Handle the case where the response might be null or empty
        if (hourlyForecastDtoList == null ) {
            throw new RuntimeException("Failed to retrieve hourly forecast data");
        }

        // Convert each HourlyForecastDto to HourlyForecast and add to the list
       // for (HourlyForecastDto dto : hourlyForecastDtoList) {
            hourlyForecastList.add(convertToHourlyForecast(hourlyForecastDtoList));
    //    }

        return hourlyForecastList;
    }

    public HourlyForecast convertToHourlyForecast(HourlyForecastDto dto) {
        HourlyForecast hourlyForecast = new HourlyForecast();
      //  hourlyForecast.setList(dto.getList());
        hourlyForecast.setCod(dto.getCod());
        hourlyForecast.setMessage(dto.getMessage());
     //   hourlyForecast.setWeather(dto.getWeather());
        hourlyForecast.setCnt(dto.getCnt());

        return hourlyForecast;
    }
}
