/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.services;

import edu.eci.arsw.weather.persistence.WeatherPersistence;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2104784
 */
@Service
public class WeatherServicesStub implements WeatherServices{

    @Autowired
    @Qualifier("Alpha")
    WeatherPersistence wp;
    
    @Override
    public String getClimaCiudad(String ciudad) throws IOException{
        return wp.getClimaCiudad(ciudad);
    }
    
}
