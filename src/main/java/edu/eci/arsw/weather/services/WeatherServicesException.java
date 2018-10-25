/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.services;

/**
 *
 * @author 2104784
 */
public class WeatherServicesException extends Exception {
    
    public WeatherServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherServicesException(String message) {
        super(message);
    }
}
