package com.treative.treative.service;

import com.treative.treative.dao.FlightDAO;
import com.treative.treative.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightDAO flightDAO;

    @Autowired
    public FlightServiceImpl(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public List<Flight> getFlightsByType(String filterType, String filterValue) {
        List<Flight> flights = flightDAO.findAll();
        return flights;
    }

    @Override
    public Flight saveFlight(Flight flight) {
        flightDAO.save(flight);
        return null;
    }
}
