package com.treative.treative.dao;

import com.treative.treative.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightDAO extends MongoRepository<Flight, String> {

}
