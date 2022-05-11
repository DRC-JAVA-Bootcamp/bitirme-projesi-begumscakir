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

    public Therapist(String nameSurname, String idNumber, Integer subfield,
                     Integer therapeuticApproach, String therapyLanguage,
                     String therapyLanguage2, Integer yearInTheField,
                     Double costTherapy, String phoneNo) {
        this.nameSurname = nameSurname;
        this.idNumber = idNumber;
        this.subfield = subfield;
        this.therapeuticApproach = therapeuticApproach;
        this.therapyLanguage = therapyLanguage;
        this.therapyLanguage2 = therapyLanguage2;
        this.yearInTheField = yearInTheField;
        this.costTherapy = costTherapy;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "id=" + id +
                ", nameSurname='" + nameSurname + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", subfield=" + subfield +
                ", therapeuticApproach=" + therapeuticApproach +
                ", therapyLanguage='" + therapyLanguage + '\'' +
                ", therapyLanguage2='" + therapyLanguage2 + '\'' +
                ", yearInTheField=" + yearInTheField +
                ", costTherapy=" + costTherapy +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
