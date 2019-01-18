package edu.eci.arsw.weather.test;

import edu.eci.arsw.weather.persistence.WeatherPersistence;
import edu.eci.arsw.weather.services.WeatherServicesException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *
 * @author dbeltran
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationServicesTests {

    @Autowired
    WeatherPersistence services;

    String queryLondon;

    @Before
    public void initial() throws WeatherServicesException {
        queryLondon = services.getClimaCiudad("london");
    }

    @Test
    public void contextLoads() throws WeatherServicesException {

    }

    @Test
    public void concurrentQueryToPersitence() throws WeatherServicesException {
        
        List<Thread> threads = new ArrayList<>();
        int numThreads = 10;
        for (int i = 0; i < numThreads; i++) {
            threads.add(new ThreadTest());
        }
        for (Thread t: threads) {
            t.start();
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(WeatherApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    }

    public class ThreadTest extends Thread {

        @Override
        public void run() {
            String queryB;
            try {
                queryB = services.getClimaCiudad("london");
                assertTrue(queryLondon.equals(queryB));
            } catch (WeatherServicesException ex) {
                Logger.getLogger(WeatherApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
