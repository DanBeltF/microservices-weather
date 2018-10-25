/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.controller;

import edu.eci.arsw.weather.services.WeatherServices;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2104784
 */
@RestController
@RequestMapping (value = "/weather")
public class WeatherController {
    
    @Autowired
    WeatherServices ws;
    @RequestMapping(method = RequestMethod.GET, path = "/weather/{ciudad}")
    public ResponseEntity<?> getClimaCiudad(@PathVariable String ciudad) {
        try {
            return new ResponseEntity<>(ws.getClimaCiudad(ciudad), HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No es posible obtener el clima de: " + ciudad, HttpStatus.NOT_FOUND);
        }    
    }
    
}
