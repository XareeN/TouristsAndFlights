package com.treative.treative.service;

import com.treative.treative.model.Tourist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristService {
    List<Tourist> getTouristByType(String filterType, String filterValue);
    Tourist saveTourist(Tourist tourist);
}
