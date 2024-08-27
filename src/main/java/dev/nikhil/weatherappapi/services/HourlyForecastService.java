package dev.nikhil.weatherappapi.services;

import dev.nikhil.weatherappapi.dtos.ForecastDetailsDto;
import dev.nikhil.weatherappapi.dtos.HourlyForecastDto;
import dev.nikhil.weatherappapi.dtos.weath;
import dev.nikhil.weatherappapi.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
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
        HourlyForecastDto hourlyForecastDto = restTemplate.getForObject(
                url,
                HourlyForecastDto.class,
                lat, lon, id
        );

        if (hourlyForecastDto == null) {
            throw new RuntimeException("Failed to retrieve hourly forecast data");
        }

        // Convert DTO to Model
        HourlyForecast hourlyForecast = convertToHourlyForecast(hourlyForecastDto);

        // Return a list containing the single converted object
        List<HourlyForecast> hourlyForecastList = new ArrayList<>();
        hourlyForecastList.add(hourlyForecast);

        return hourlyForecastList;
    }

    public HourlyForecast convertToHourlyForecast(HourlyForecastDto dto) {
        HourlyForecast hourlyForecast = new HourlyForecast();
        hourlyForecast.setCod(dto.getCod());
        hourlyForecast.setMessage(dto.getMessage());
        hourlyForecast.setCnt(dto.getCnt());

        // Convert List<ForecastDetailsDto> to List<ForecastDetails>
        List<ForecastDetail> forecastDetailsList = new ArrayList<>();
        for (ForecastDetailsDto detailsDto : dto.getList()) {
            ForecastDetail details = new ForecastDetail();
            details.setDt(detailsDto.getDt());

            All mainDetails = new All();
            mainDetails.setTemp(detailsDto.getMain().getTemp());
            mainDetails.setFeels_like(detailsDto.getMain().getFeels_like());
            mainDetails.setTemp_min(detailsDto.getMain().getTemp_min());
            mainDetails.setTemp_max(detailsDto.getMain().getTemp_max());
            mainDetails.setPressure(detailsDto.getMain().getPressure());
            mainDetails.setSea_level(detailsDto.getMain().getSea_level());
            mainDetails.setGrnd_level(detailsDto.getMain().getGrnd_level());
            mainDetails.setHumidity(detailsDto.getMain().getHumidity());
            mainDetails.setTemp_kf(detailsDto.getMain().getTemp_kf());

            details.setMain(mainDetails);

         List<Weath> weatherList = new ArrayList<>();
            for (Weath weatherDto : detailsDto.getWeather()) {
                Weath weather = new Weath();
                weather.setId(weatherDto.getId());
                weather.setMain(weatherDto.getMain());
                weather.setDescription(weatherDto.getDescription());
                weather.setIcon(weatherDto.getIcon());
                weatherList.add(weather);
            }
           details.setWeather(weatherList);

            forecastDetailsList.add(details);
        }
        hourlyForecast.setList(forecastDetailsList);

        return hourlyForecast;
    }
}
