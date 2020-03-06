package com.treative.treative.service;

import com.treative.treative.dao.TouristDAO;
import com.treative.treative.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {

    private TouristDAO touristDAO;

    @Autowired
    public TouristServiceImpl(TouristDAO touristDAO) {
        this.touristDAO = touristDAO;
    }

    @Override
    public List<Tourist> getTouristByType(String filterType, String filterValue) {
        List<Tourist> tourists = touristDAO.findAll();
        if (filterType != null){
            switch (filterType){
                case "id":
                    tourists = Collections.singletonList(touristDAO.findTouristsByIdEquals(filterValue));
                    break;
                case "name":
                    tourists = touristDAO.findTouristsByNameContaining(filterValue);
                    break;
                case "surname":
                    tourists = touristDAO.findTouristsBySurnameContaining(filterValue);
                    break;
                case "country":
                    tourists = touristDAO.findTouristsByCountryContaining(filterValue);
                    break;
                case "gender":
                    tourists = touristDAO.findTouristsByGenderContaining(filterValue);
                    break;
                case "notes":
                    tourists = touristDAO.findTouristsByNotesContaining(filterValue);
                    break;
                case "birthday":
                    tourists = touristDAO.findTouristsByBirthdayContaining(filterValue);
                    break;
                default:
                    throw new IllegalArgumentException("Enter valid parameter");
            }
        }
        return tourists;
    }

    @Override
    public List<Tourist> getTouristByAnything(String text) {
        return touristDAO.findTouristsByIdEqualsOrNameContainingOrSurnameContainingOrCountryContainingOrGenderContainingOrNotesContainingOrBirthdayContaining(text);
    }

    @Override
    public Tourist getTouristById(String id) {
        return touristDAO.findTouristsByIdEquals(id);
    }

    @Override
    public Tourist saveTourist(Tourist tourist) {
        touristDAO.save(tourist);
        return null;
    }

    @Override
    public List<Tourist> deleteTourist(String idToDelete) {
        Tourist tourist = new Tourist();
        tourist.setId(idToDelete);
        touristDAO.delete(tourist);
        return touristDAO.findAll();
    }

    @Override
    public ResponseEntity<Object> updateTourist(Tourist tourist, String id) {

        Optional<Tourist> touristToUpdate = touristDAO.findById(id);
        if(!touristToUpdate.isPresent())
            return ResponseEntity.notFound().build();

        tourist.setId(id);
        touristDAO.save(tourist);

        return ResponseEntity.noContent().build();
    }
}
