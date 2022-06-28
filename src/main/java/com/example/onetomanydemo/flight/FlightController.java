package com.example.onetomanydemo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    @Autowired 
    FlightService flightService;

    @PostMapping(value = "/flight",
                    consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight f = flightService.addFlight(flight);
        if (f == null) {
           return new ResponseEntity<Flight>(f, HttpStatus.CONFLICT);
        } else {
           return new ResponseEntity<Flight>(f, HttpStatus.CREATED);
        }
    }
}
