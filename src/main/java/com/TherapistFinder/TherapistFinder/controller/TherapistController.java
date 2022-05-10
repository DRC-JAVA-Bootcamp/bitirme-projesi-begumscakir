package com.TherapistFinder.TherapistFinder.controller;

import com.TherapistFinder.TherapistFinder.dto.TherapistRequest;
import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.model.Visitor;
import com.TherapistFinder.TherapistFinder.service.TherapistService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/therapist")
public class TherapistController {

    private final TherapistService therapistService;

    public TherapistController(TherapistService therapistService) {
        this.therapistService = therapistService;
    }

    @GetMapping("/get")
    public List<Therapist> getAllTherapists(){
        return therapistService.getAllTherapists();
    }
    @GetMapping("/find")
    public List<Therapist> findSuitableTherapists(Visitor visitor) throws Exception {
        return therapistService.findSuitableTherapists(visitor);
    }

    @PostMapping("/add")
    public Therapist createTherapist(@RequestBody Therapist therapist){

        return therapistService.createTherapist(therapist);
    }
    @PostMapping("/addAll")
    public List<Therapist> createBulkTherapist(@RequestParam String filepath){
        return therapistService.createBulkTherapist(filepath);
    }

}
