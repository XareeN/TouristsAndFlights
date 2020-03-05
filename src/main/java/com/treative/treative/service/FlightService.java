package com.treative.treative.service;

import com.treative.treative.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightService {
    List<Flight> getFlightsByType(String filterType, String filterValue);
    Flight saveFlight(Flight flight);
}
