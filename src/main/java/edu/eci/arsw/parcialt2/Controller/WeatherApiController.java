package edu.eci.arsw.parcialt2.Controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.parcialt2.CovidService.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller para los endpoints del api que ofrece nuestro backend
 */
@RestController
@RequestMapping("/weather")
public class WeatherApiController {

    @Autowired
    private WeatherServices service;

    /**
     * Ofrece el endpoint del api para que sea consultado por el front end
     * @param city
     * @return
     * @throws UnirestException
     */
    @RequestMapping(value="/{city}",method= RequestMethod.GET)
    public ResponseEntity<?> getStatsByCountry(@PathVariable String city) throws UnirestException {
        return new ResponseEntity<>(service.getWeatherByCity(city), HttpStatus.ACCEPTED);
    }

}
