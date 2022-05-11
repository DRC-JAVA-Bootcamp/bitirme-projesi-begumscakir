package com.TherapistFinder.TherapistFinder.config;

import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.repository.TherapistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TherapistConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            TherapistRepository therapistRepository
    ){
        return args -> {

            therapistRepository.saveAll(
                    List.of(
                            new Therapist("Erich", "22222222222", 1, 1, "Turkish",
                                    "English", 5, 500.0, "53255555")
                    )
            );
        };
    }
}
