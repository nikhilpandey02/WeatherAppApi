package dev.nikhil.weatherappapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weath {
    private int id;
    private String main;
    private String description;
    private String icon;
}
