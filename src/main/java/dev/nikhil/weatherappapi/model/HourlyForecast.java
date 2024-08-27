package dev.nikhil.weatherappapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class HourlyForecast {
    String cod;
    long message;
    int cnt;
//    Map<String,Double> list;
//    Map<String,String>weather;
}
