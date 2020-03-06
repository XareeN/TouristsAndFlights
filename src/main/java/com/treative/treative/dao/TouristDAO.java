package com.treative.treative.dao;

import com.treative.treative.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TouristDAO extends MongoRepository<Tourist, String> {

    Tourist findTouristsByIdEquals(String id);

    List<Tourist> findTouristsByNameContaining(String name);

    List<Tourist> findTouristsBySurnameContaining(String surname);

    List<Tourist> findTouristsByCountryContaining(String country);

    List<Tourist> findTouristsByGenderContaining(String gender);

    List<Tourist> findTouristsByNotesContaining(String notes);

    List<Tourist> findTouristsByBirthdayContaining(String birthday);

    List<Tourist> findTouristsByIdEqualsOrNameContainingOrSurnameContainingOrCountryContainingOrGenderContainingOrNotesContainingOrBirthdayContaining(String text);
}
