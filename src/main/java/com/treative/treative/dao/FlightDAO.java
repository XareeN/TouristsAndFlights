package com.treative.treative.dao;

import com.treative.treative.model.Flight;
import com.treative.treative.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightDAO extends MongoRepository<Flight, String> {

    Flight findFlightsByIdEquals(String id);

    List<Flight> findFlightsByArrivalContaining(String arrival);

    List<Flight> findFlightsByDepartureContaining(String departure);

    List<Flight> findFlightsBySeatCountLike(int seatCount);

    List<Flight> findFlightsByTouristListContaining(Tourist tourist);

    List<Flight> findFlightsByTicketPriceLike(double ticketPrice);

}
