package com.TherapistFinder.TherapistFinder.repository;

import com.TherapistFinder.TherapistFinder.model.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TherapistRepository extends JpaRepository<Therapist, Integer> {
}
