package com.TherapistFinder.TherapistFinder.model;


import lombok.*;

import javax.persistence.*;


@Builder
@Entity(name = "Visitor")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;

    private String name;
    private Integer age;
    private String languagePreference;
    private Integer therapyPreference;
    private Integer expectationFromTherapy;
    private Double maxCost;
}
