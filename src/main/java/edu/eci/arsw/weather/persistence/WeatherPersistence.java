/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.persistence;

import edu.eci.arsw.weather.services.WeatherServicesException;

/**
 *
 * @author 2104784
 */
public interface WeatherPersistence {
    
    public String getClimaCiudad(String ciudad) throws WeatherServicesException;
    
}
