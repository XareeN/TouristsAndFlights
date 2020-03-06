package com.treative.treative.service;

import com.treative.treative.dao.TouristDAO;
import com.treative.treative.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        return tourists;
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
