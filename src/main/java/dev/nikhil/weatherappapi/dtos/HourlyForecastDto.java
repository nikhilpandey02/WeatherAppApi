package dev.nikhil.weatherappapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyForecastDto {
    String cod;
    long message;
    int cnt;
    private List<ForecastDetailsDto> list;
//    Map<String,Double> list;
//    Map<String,String>weather;

}

//that api give

//    {
//        "cod": "200",
//            "message": 0,
//            "cnt": 96,
//            "list": [
//        {
//            "dt": 1661875200,
//                "main": {
//            "temp": 296.34,
//                    "feels_like": 296.02,
//                    "temp_min": 296.34,
//                    "temp_max": 298.24,
//                    "pressure": 1015,
//                    "sea_level": 1015,
//                    "grnd_level": 933,
//                    "humidity": 50,
//                    "temp_kf": -1.9
//        },
//            "weather": [
//            {
//                "id": 500,
//                    "main": "Rain",
//                    "description": "light rain",
//                    "icon": "10d"
//            }
//      ],
//
//}
