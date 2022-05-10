package com.TherapistFinder.TherapistFinder.service;

import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.model.Visitor;
import com.TherapistFinder.TherapistFinder.repository.VisitorRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }





}
