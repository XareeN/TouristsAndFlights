package com.treative.treative.service;

import com.treative.treative.dao.TouristDAO;
import com.treative.treative.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
