/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.weather.model.impl;


import edu.eci.arsw.weather.model.HttpConnection;
import edu.eci.arsw.weather.services.WeatherServicesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author dbeltran
 */
@Service
public class HttpConnectionWeather implements HttpConnection {

    private final String USER_AGENT = "Mozilla/5.0";
    private final String APIkey = "a1ed7c550f7812bda022c8556179e290";

    @Override
    public String getClimaCiudad(String ciudad) throws WeatherServicesException {
        String GET_URL = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s", ciudad, APIkey);
        try {

            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                return response.toString();

            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            throw new WeatherServicesException("Error consultando al API externo.");
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new WeatherServicesException("Error consultando al API externo.");
        }
    }
}
