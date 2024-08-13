package com.deliveryboy.deliveryboy.controller;

import com.deliveryboy.deliveryboy.config.KafkaConfig;
import com.deliveryboy.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/location")
public class LocationController
{
    @Autowired
    private KafkaService KafkaService;
    //KafkaService is a class that we created
    //We'll get the object of that class by @Autowired

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation()
    {
        //Random latitude and longitude (LaLo) will be returned to locationKafka
        String locationKafka = generateRandomLocation();

        //this random LaLo will be sent to KafkaService class' function updateLocation
        //(not this class' function, as both the names are same
        this.KafkaService.updateLocation(locationKafka);

        //Handles Postman
        return new ResponseEntity<>(Map.of("message","location updated"), HttpStatus.OK);

        //ResponseEntity is a generic class in Spring that represents an HTTP response.
        // It can hold a body of any type, HTTP status code, and headers.
    }

    private String generateRandomLocation() {
        Random random = new Random();
        double latitude = -90 + (90 + 90) * random.nextDouble();
        double longitude = -180 + (180 + 180) * random.nextDouble();
        return latitude + "," + longitude;
    }


}
