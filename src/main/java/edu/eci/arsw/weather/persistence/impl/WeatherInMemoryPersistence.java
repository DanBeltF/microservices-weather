/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.persistence.impl;

import edu.eci.arsw.weather.model.HttpConnection;
import edu.eci.arsw.weather.persistence.WeatherPersistence;
import edu.eci.arsw.weather.services.WeatherServicesException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2104784
 */
@Service
public class WeatherInMemoryPersistence implements WeatherPersistence{

    @Autowired
    HttpConnection externalAPI;
    
    private Map<String, String> cache;
    
    public WeatherInMemoryPersistence() {
        cache = new ConcurrentHashMap<>();
    }
    
    @Override
    public String getClimaCiudad(String ciudad) throws WeatherServicesException {
        if(cache.containsKey(ciudad)){
            return cache.get(ciudad);
        }else{
            String Weather = externalAPI.getClimaCiudad(ciudad);
            cache.put(ciudad, Weather);
            return Weather;
        }
    }
}
