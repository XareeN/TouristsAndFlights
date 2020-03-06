package com.treative.treative.service;

import com.treative.treative.dao.FlightDAO;
import com.treative.treative.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Flight> deleteFlight(String idToDelete) {
        Flight flight = new Flight();
        flight.setId(idToDelete);
        flightDAO.delete(flight);
        return flightDAO.findAll();
    }

    @Override
    public ResponseEntity<Object> updateFlight(Flight flight, String id) {

        Optional<Flight> flightToUpdate = flightDAO.findById(id);
        if (!flightToUpdate.isPresent())
            return ResponseEntity.notFound().build();

        flight.setId(id);
        flightDAO.save(flight);

        return ResponseEntity.noContent().build();
    }
}
