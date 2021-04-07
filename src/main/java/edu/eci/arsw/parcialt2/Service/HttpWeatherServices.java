package edu.eci.arsw.parcialt2.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Esta clase se conecta con el endpoint openweather y hace un peticion con unirest
 */
@Service
public class HttpWeatherServices {
    /**
     * Consulta la informacion de clima de una ciudad especificada
     * @param city
     * @return
     * @throws UnirestException
     */
    public JSONObject getWeatherByCity(String city) throws UnirestException{
//        HttpResponse<String> response = Unirest.get("api.openweathermap.org/data/2.5/weather?q="+city+"&appid=b454b294ded6abe62e7512d10a87b051").asString();
        HttpResponse<String> response = Unirest.get("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=b454b294ded6abe62e7512d10a87b051").asString();
        return new JSONObject(response.getBody());
    }



}
