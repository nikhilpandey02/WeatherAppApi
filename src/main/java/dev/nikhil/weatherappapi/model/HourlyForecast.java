package dev.nikhil.weatherappapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HourlyForecast {
    private String cod;
    private long message;
    private int cnt;
    private List<ForecastDetail> list;
}

