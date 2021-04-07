package edu.eci.arsw.parcialt2.Cache;

import edu.eci.arsw.parcialt2.Model.City;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cache de consultas de informacion climatica en una ciudad, contiene un hashmap donde almacena los objetos de ciudad
 */
@Service
public class CityCache {
    private ConcurrentHashMap<String, Pair<City, Date>> cachePersistence=new ConcurrentHashMap<>();

    public CityCache(){

    }

    public void addCache(String cityName, City cityInfo){
        cachePersistence.put(cityName, new Pair<City, Date>(cityInfo, new Date()));
    }

    public Pair<City, Date> getCache(String name){
        return cachePersistence.get(name);
    }


}
