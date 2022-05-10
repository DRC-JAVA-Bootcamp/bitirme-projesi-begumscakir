package com.TherapistFinder.TherapistFinder.service;

import com.TherapistFinder.TherapistFinder.repository.TherapistRegisterRepository;

public class TherapistRegisterService {

    private final TherapistRegisterRepository therapistRegisterRepository;


    public TherapistRegisterService(TherapistRegisterRepository therapistRegisterRepository) {
        this.therapistRegisterRepository = therapistRegisterRepository;
    }


}
