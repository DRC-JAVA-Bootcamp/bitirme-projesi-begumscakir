package com.TherapistFinder.TherapistFinder.controller;

import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.model.Visitor;
import com.TherapistFinder.TherapistFinder.service.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/therapist")
public class TherapistController {

    private final TherapistService therapistService;

    @Autowired
    public TherapistController(TherapistService therapistService) {
        this.therapistService = therapistService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Therapist>> getAllTherapists(){
        return new ResponseEntity<>(therapistService.getAllTherapists(), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Therapist>> findSuitableTherapists(@RequestBody Visitor visitor) throws Exception {
        return new ResponseEntity<>(therapistService.findSuitableTherapists(visitor), HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Therapist> createTherapist(@RequestBody Therapist therapist)  {
        return new ResponseEntity<>(therapistService.createTherapist(therapist), HttpStatus.OK);
    }

}
