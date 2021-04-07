package edu.eci.arsw.parcialt2.CovidService;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcialt2.Model.*;
import edu.eci.arsw.parcialt2.Service.HttpWeatherServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Esta clase ofrece servicios para manipular los JSON que son consultados por la API
 */
@Service
public class WeatherServices {


    @Autowired
    HttpWeatherServices httpWeatherservice;

    /**
     * Crea un objeto City a partir del resultado dado por la API, este resultado se toma de la inyeccion de dependencias "httpWeatherservice"
     * @param cityName
     * @return
     * @throws UnirestException
     */
    public City getWeatherByCity(String cityName) throws UnirestException {

        JSONObject cityApiObject = httpWeatherservice.getWeatherByCity(cityName);

        JSONObject cityLocationObj = cityApiObject.isNull("coord") ? null:cityApiObject.getJSONObject("coord");
        Location cityLocation = new Location(cityLocationObj.getDouble("lon"),cityLocationObj.getDouble("lat"));

        JSONObject weatherLocationObj = cityApiObject.isNull("weather") ? null:cityApiObject.getJSONArray("weather").getJSONObject(0);
        Weather cityWeather = new Weather(weatherLocationObj.getInt("id"), weatherLocationObj.getString("main"), weatherLocationObj.getString("description"));

        JSONObject cityTemperatureObj =cityApiObject.isNull("main")? null:cityApiObject.getJSONObject("main");
        //Temperature cityTemperature = new Temperature(1.1,1.1,1.1,1.1,1.1,1.1);
        Temperature cityTemperature = new Temperature(
                cityTemperatureObj.getDouble("temp"),
                cityTemperatureObj.getDouble("feels_like"),
                cityTemperatureObj.getDouble("temp_min"),
                cityTemperatureObj.getDouble("temp_max"),
                cityTemperatureObj.getDouble("pressure"),
                cityTemperatureObj.getDouble("humidity")
        );

        JSONObject windObj = cityApiObject.isNull("wind") ? null:cityApiObject.getJSONObject("wind");
        Wind cityWind = new Wind(windObj.getDouble("speed"), windObj.getDouble("deg"));


        City cityObject = new City(
                cityApiObject.isNull("name") ? null:cityApiObject.getString("name"),
                cityLocation,
                cityWeather,
                cityTemperature,
                cityWind
                );
        return cityObject;
    }


}
