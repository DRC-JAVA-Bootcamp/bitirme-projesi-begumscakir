package com.TherapistFinder.TherapistFinder.service;

import com.TherapistFinder.TherapistFinder.dto.TherapistRequest;
import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.model.Visitor;
import com.TherapistFinder.TherapistFinder.repository.TherapistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TherapistService {

    private final TherapistRepository therapistRepository;

    public TherapistService(TherapistRepository therapistRepository) {
        this.therapistRepository = therapistRepository;
    }
    public Therapist createTherapist(Therapist therapist)  {
        return therapistRepository.save(therapist);
    }

    public List<Therapist> findSuitableTherapists(Visitor v) throws Exception {

        if(v.getAge() < 18 ) throw new Exception("You should be at least 18 to be in our system.");

        if(v.getTherapyPreference() != 1) v.setExpectationFromTherapy(0);

        List<Therapist>therapists= therapistRepository.findAll();

        List<Therapist> temp = new ArrayList<>();

        for(Therapist t : therapists){
            if(
                    (t.getTherapyLanguage().equals(v.getLanguagePreference()) || t.getTherapyLanguage2().equals(v.getLanguagePreference()))&&
                            Objects.equals(v.getTherapyPreference(), t.getSubfield()) &&
                            Objects.equals(v.getExpectationFromTherapy(), t.getTherapeuticApproach()) &&
                            v.getMaxCost() >= t.getCostTherapy()
            ){
                temp.add(t);
            }
        }
        return temp;
    }
    public List<Therapist> getAllTherapists(){
       return therapistRepository.findAll();
    }


}
