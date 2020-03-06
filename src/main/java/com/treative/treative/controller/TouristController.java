package com.treative.treative.controller;

import com.treative.treative.model.Tourist;
import com.treative.treative.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping(value = "/tourists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tourist>> getTourists(
            @RequestParam(value = "filterType", required = false) String filterType,
            @RequestParam(value = "filterValue", required = false) String filterValue
    ){
        List<Tourist> allTourists = touristService.getTouristByType(filterType, filterValue);
        return ResponseEntity.ok(allTourists);
    }

    @PostMapping("/addTourist")
    public ResponseEntity<Tourist> addTourist(){
        Tourist tourist1 = new Tourist(
                "Jason",
                "Bourne",
                "MALE",
                "Great Britain",
                "",
                "1980-12-12T00:00:00.000"
        );
        touristService.saveTourist(tourist1);
        return ResponseEntity.ok(tourist1);
    }

    @PostMapping("/deleteTourist")
    public ResponseEntity<List<Tourist>> deleteTourist(@RequestBody String idToDelete){
        List<Tourist> tourists = touristService.deleteTourist(idToDelete);
        return ResponseEntity.ok(tourists);
    }

    @PutMapping("/tourists/{id}")
    public ResponseEntity<Tourist> updateTourist(@RequestBody Tourist tourist, @PathVariable String id){
        touristService.updateTourist(tourist, id);
        return null;
    }


}
