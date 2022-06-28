package com.example.onetomanydemo.flight;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomanydemo.passenger.Passenger;

@Service
public class FlightService implements IFlightService {
    @Autowired
    IFlightRepository iFlightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        Flight f = new Flight();
        f.setName(flight.getName());

        Set<Passenger> passengers = flight.getPassengers();
        for(Passenger p: passengers) {
            Passenger o = new Passenger();
            o.setName(p.getName());
            f.addPassenger(o);
        }
        return iFlightRepository.save(f);
    }
}
