package com.TherapistFinder.TherapistFinder.service;

import com.TherapistFinder.TherapistFinder.dto.TherapistRequest;
import com.TherapistFinder.TherapistFinder.model.Therapist;
import com.TherapistFinder.TherapistFinder.model.Visitor;
import com.TherapistFinder.TherapistFinder.repository.TherapistRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TherapistService {

    private final TherapistRepository therapistRepository;

    public TherapistService(TherapistRepository therapistRepository) {
        this.therapistRepository = therapistRepository;
    }
    public Therapist createTherapist(Therapist therapist){
        return therapistRepository.saveAndFlush(therapist);

    }

    public List<Therapist> createBulkTherapist(String filepath){
        List<Therapist> therapists = new ArrayList<>();
        String nameSurname = "", idNumber = "",therapyLanguage = "",therapyLanguage2 = "",phoneNo = "";
        int subfield,therapeuticApproach,yearInTheField;
        double costTherapy;
        try {
            File file = new File(filepath);
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                if(lineNo != 0) {
                    tempArr = line.split(",");
                    nameSurname = tempArr[0];
                    idNumber = tempArr[1];
                    phoneNo = tempArr[2];
                    subfield = Integer.parseInt(tempArr[3]);
                    therapeuticApproach = Integer.parseInt(tempArr[4]);
                    therapyLanguage = tempArr[5];
                    therapyLanguage2 = tempArr[6];
                    yearInTheField = Integer.parseInt(tempArr[7]);
                    costTherapy = Double.parseDouble(tempArr[8]);


                    therapists.add(Therapist.builder().nameSurname(nameSurname).idNumber(idNumber).subfield(subfield)
                            .therapeuticApproach(therapeuticApproach).therapyLanguage(therapyLanguage)
                            .therapyLanguage2(therapyLanguage2).yearInTheField(yearInTheField).costTherapy(costTherapy)
                            .phoneNo(phoneNo).build());
                }
                lineNo++;
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return therapistRepository.saveAll(therapists); //Listeye döner
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
