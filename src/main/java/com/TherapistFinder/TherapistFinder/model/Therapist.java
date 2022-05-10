package com.TherapistFinder.TherapistFinder.model;


import lombok.*;

import javax.persistence.*;


@Builder
@Entity(name = "Therapist")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Therapist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;

    private String nameSurname;
    private String idNumber;
    private Integer subfield;
    private Integer therapeuticApproach;
    private String therapyLanguage;
    private String therapyLanguage2;
    private Integer yearInTheField;
    private Double costTherapy;
    private String phoneNo;
}
