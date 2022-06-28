package com.example.onetomanydemo.flight;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.onetomanydemo.passenger.Passenger;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idflight")
    private int idflight;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    Set<Passenger> passengers = new HashSet<Passenger>(); 

    public Flight() {}

    public Flight(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setFlight(this);
    }
    
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setFlight(null);
    }
}
