package com.treative.treative.controller;

import com.treative.treative.model.Flight;
import com.treative.treative.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> getFlights(
            @RequestParam(value = "filterType", required = false) String filterType,
            @RequestParam(value = "filterValue", required = false) String filterValue
    ){
        List<Flight> allFlights = flightService.getFlightsByType(filterType, filterValue);
        return ResponseEntity.ok(allFlights);
    }

    @PostMapping("/addFlight")
    public void addFlight(){
        Flight flight = new Flight(
                "2020-03-06T00:00:00",
                "2020-03-13T00:00:00",
                10,
                5,
                50.00
        );
        flightService.saveFlight(flight);
//        return ResponseEntity.ok("OK");
    }


}
