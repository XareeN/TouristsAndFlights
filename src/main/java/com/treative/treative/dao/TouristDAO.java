package com.treative.treative.dao;

import com.treative.treative.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TouristDAO extends MongoRepository<Tourist, String> {
}
