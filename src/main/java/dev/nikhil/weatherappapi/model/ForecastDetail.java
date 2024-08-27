package dev.nikhil.weatherappapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDetail {
    private long dt;
    private All main;
    private List<Weath> weather;
}
