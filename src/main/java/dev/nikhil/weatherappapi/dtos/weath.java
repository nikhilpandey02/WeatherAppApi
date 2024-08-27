package dev.nikhil.weatherappapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class weath {
    private int id;
    private String main;
    private String description;
    private String icon;

}
