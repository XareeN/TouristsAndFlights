package com.treative.treative.service;

import com.treative.treative.model.Tourist;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristService {
    List<Tourist> getTouristByType(String filterType, String filterValue);
    Tourist saveTourist(Tourist tourist);

    List<Tourist> deleteTourist(String idToDelete);

    ResponseEntity<Object> updateTourist(Tourist tourist, String id);
}
