package dev.nikhil.weatherappapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {

    public String name;
    public double lat;
    public double lon;
    public String country;
}
