package FindTherapist;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class FileOperations {

    //Write a therapist to a CSV file.
    public static void writeOneTherapist(String filepath, Therapist therapists) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(therapists.getNameSurname() + ","
                    + therapists.getIdNumber() + ","
                    + therapists.getPhoneNo() + ","
                    + therapists.getSubfield() + ","
                    + therapists.getTherapeuticApproach() + ","
                    + therapists.getTherapyLanguage() + ","
                    + therapists.getTherapyLanguage2() + ","
                    + therapists.getYearInTheField() + ","
                    + therapists.getCostTherapy());

            pw.flush();
            pw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    //Read all therapists from the CSV file and add them to a temporary list.
    public static List<Therapist> readTherapists(String filepath){
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

                    therapists.add(new Therapist(nameSurname, idNumber, phoneNo, subfield, therapeuticApproach,
                            therapyLanguage, therapyLanguage2, yearInTheField, costTherapy));
                }
                lineNo++;
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return therapists;
    }
}
