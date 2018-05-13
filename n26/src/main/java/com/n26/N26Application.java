package com.n26;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entity to start the application. By default the port of the application is 8080 and you can access the application
 * using http://localhost:8080.
 * 
 * To change the port number you should have to add the entry in application.properties file as :
 * 
 * <pre>
 * server.port = 9090
 * </pre>
 * 
 * @author jobanpreetsingh
 *
 */
@SpringBootApplication
public class N26Application {

    /**
     * Main method of the application i.e. point of start.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(N26Application.class, args);
    }
}
