package com.TherapistFinder.TherapistFinder.dto;

import com.TherapistFinder.TherapistFinder.model.Therapist;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TherapistRequest {

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
