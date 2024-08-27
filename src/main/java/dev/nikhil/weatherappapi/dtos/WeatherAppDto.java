package dev.nikhil.weatherappapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAppDto {

    private String name;
    private String localNames;
    private String country;
    private double lat;
    private double lon;
    private String state; // Add this field if it is relevant

}
