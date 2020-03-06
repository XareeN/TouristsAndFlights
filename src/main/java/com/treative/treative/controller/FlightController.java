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

    @PostMapping(value = "/addFlight", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
//        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
//        StringBuilder builder = new StringBuilder(2);
//        int y;
//        for (y = 0; y < 2; y++){
//            int index = (int)(s.length()*Math.random());
//            builder.append(s.charAt(index));
//        }
//        String randomString = builder.toString();

//        Flight flight = new Flight(
//                "2020-03-06T00:00:00",
//                "2020-03-13T00:00:00",
//                11,
//                Collections.singletonList(null),
//                50.00
//        );
        flightService.saveFlight(flight);
        return ResponseEntity.ok(flight);
    }

    @PostMapping("/deleteFlight")
    public ResponseEntity<List<Flight>> deleteFlight(@RequestBody String idToDelete){
        List<Flight> flights = flightService.deleteFlight(idToDelete);
        return ResponseEntity.ok(flights);
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight, @PathVariable String id){
        flightService.updateFlight(flight, id);
        return null;
    }


}
