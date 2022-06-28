package com.example.onetomanydemo.flight;

import org.springframework.data.repository.CrudRepository;

public interface IFlightRepository extends CrudRepository<Flight, Integer> {
}
