package dev.nikhil.weatherappapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.nikhil.weatherappapi.model.Weath;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDetailsDto {
    private long dt;
    private All main;
    private List<Weath> weather;


}
