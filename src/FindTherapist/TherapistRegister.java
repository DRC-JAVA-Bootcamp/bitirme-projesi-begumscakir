package FindTherapist;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TherapistRegister {
    
    private List<Therapist> therapistList ;
    private static String filepathTherapist = "src/FindTherapist/data/Therapists.csv";

    public TherapistRegister() {
        therapistList = FileOperations.readTherapists(filepathTherapist);
    }

    public void signUp(){
        System.out.println("Press 1 - if you're a therapist.");
        System.out.println("Press 2 - if you're looking for a therapist.");
        try (Scanner start = new Scanner(System.in,StandardCharsets.UTF_8)) {

            int i = start.nextInt();

            if (i == 1) this.createTherapists();
            else if (i == 2) this.chooseTherapistAsVisitor();
            else {
                System.out.println("You press the wrong number!");
                System.exit(0);
            }
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    private void createTherapists(){
        // Therapist
        Scanner inputTher = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println();
        System.out.println("Have you completed your Master's degree in Clinical Psychology?");
        System.out.println("Enter 1 for 'Yes', 0 for 'No'.");

        int masterQ = inputTher.nextInt();
        System.out.println();
        if (masterQ == 1) {

            System.out.println("Please write your name and surname: ");
            inputTher.nextLine(); //nameSurname
            String nameTher = inputTher.nextLine();
            System.out.println();
            //
            System.out.println("Please enter your ID number: ");
            String idTher = inputTher.nextLine(); //idNumber
            System.out.println();
            //
            System.out.println("Please enter your phone number: ");
            String phoneTher = inputTher.nextLine(); //phoneNo
            System.out.println();
            //
            
            // if you want to add more specializations or qualities related to them, adjust
            System.out.println("Please choose your specialization.");
            System.out.println("Enter 1 for 'Adult Psychology', 2 for 'Children and Adolescent Psychology, " +
                    "and 3 for 'Couple Psychology'.");
            int subfieldTher = inputTher.nextInt(); //subfield
            System.out.println();
            //
            int approachTher; 
            if(subfieldTher == 1){
                System.out.println("Please enter your main therapeutic approach. Press 1 for" +
                        "'Cognitive-Behavioural Therapy', "+" 2 for 'Psychodynamic Therapy', 3 for 'Existential Therapy'");
                //therapeuticApproach
                approachTher = inputTher.nextInt(); /** I've just added 3 approaches to make an example. */
                System.out.println();
            }
            else approachTher = 0;
            //
            System.out.println("Please enter your years of professional experience in the field using numbers:");
            int yearTher = inputTher.nextInt(); //yearInTheField
            System.out.println();
            //
            System.out.println("What is the primary language you use in therapy?");
            System.out.println("Please write without using abbreviations.");
            inputTher.nextLine();
            String languageTher = inputTher.nextLine(); //therapyLanguage
            //
            System.out.println(
                    "If you also use another language in therapy please write it without abbreviations:");
            System.out.println("If not pass.");
            String language2Ther = inputTher.nextLine(); //therapyLanguage2
            System.out.println();
            //
            System.out.println("How much TL do you charge a client per session?");
            double costTher = inputTher.nextDouble(); //costTherapy
            System.out.println();

            System.out.println(new Therapist(nameTher, idTher, phoneTher, subfieldTher, approachTher, languageTher,
                    language2Ther, yearTher, costTher));
            FileOperations.writeOneTherapist(filepathTherapist,new Therapist(nameTher, idTher, phoneTher,
                    subfieldTher, approachTher, languageTher, language2Ther, yearTher, costTher));
        }
        else {
            System.out.println("You need to complete your Master's degree in Clinical Psychology in " +
                    "order to be in our system.");
        }
    }
    private void chooseTherapistAsVisitor(){
        
        // Visitor
        try (Scanner inputVisit = new Scanner(System.in,StandardCharsets.UTF_8)) {
            //
            System.out.println();
            System.out.println("Please enter a nickname:");
            String nameVisit = inputVisit.nextLine(); //name
            System.out.println();
            //
            System.out.println("Please enter your age:");
            int ageVisit = inputVisit.nextInt(); //age
            if (ageVisit >= 18) {
                //
                System.out.println();
                System.out.println("Which language would you like to speak during therapy?:");
                System.out.println("Please write without using abbreviations.");
                inputVisit.nextLine();
                String languageVisit = inputVisit.nextLine(); //languagePreference
                System.out.println(languageVisit);
                System.out.println();
                //
                System.out.println("What kind of support would you like to get?: ");
                System.out.println("Please enter" +
                        " 1 for 'Individual (for myself)', 2 for 'Couples (for myself and my partner)', 3 for "
                        +
                        "'For my child'.");
                int supportPref = inputVisit.nextInt(); //therapyPreference
                System.out.println();
                //
                int expectVisit;
                if(supportPref == 1){
                    System.out.println("What is your expectation from therapy?");
                    System.out.println("Press 1 for 'Changing the behaviours that made my life difficult.'," +
                            " 2 for 'Understanding the effects of my childhood on today.', 3 for 'Living a more fulfilling life.'");
                    // can be adjusted
                    expectVisit = inputVisit.nextInt(); //expectationFromTherapy
                    System.out.println();
                }
                else expectVisit = 0;
                //
                System.out.println("Please enter maximum cost you are willing to pay per session in TL:");
                double costVisit = inputVisit.nextDouble(); //maxCost

                System.out.println(new Visitor(nameVisit, ageVisit, languageVisit, supportPref, expectVisit, costVisit).toString());
                showMatchedTherapists(new Visitor(nameVisit, ageVisit, languageVisit, supportPref, expectVisit, costVisit));
            }
            else {
                System.out.println("You should be at least 18 to be in our system.");
            }
        }
    }
    private void showMatchedTherapists(Visitor v){
        List<Therapist> temp = new ArrayList<>();
        for(Therapist t : therapistList){
            if(
                    (t.getTherapyLanguage().equals(v.getLanguagePreference()) ||
                            t.getTherapyLanguage2().equals(v.getLanguagePreference()))&&
                    v.getTherapyPreference() == t.getSubfield()&&
                    v.getExpectationFromTherapy() == t.getTherapeuticApproach()&&
                            v.getMaxCost() >= t.getCostTherapy()
            ){
                temp.add(t);
            }
        }
        if (temp.isEmpty()) {
            System.out.println("No therapist found for the your search.");
        }
        else printTherapist(temp);
    }
    private void printTherapist(List<Therapist> therapists){
        String subfield = "";
        String therapeuticApproach = "";
        for(Therapist t : therapists){
            switch (t.getSubfield()){
                case 1 :
                    subfield = "Adult Psychology";
                    break;
                case 2 :
                    subfield = "Children and Adolescent Psychology";
                    break;
                case 3:
                    subfield = "Couple Psychology";
                    break;
            }
            switch (t.getTherapeuticApproach()){
                case 0:
                    break;
                case 1 :
                    therapeuticApproach = "Cognitive-Behavioural Therapy";
                    break;
                case 2 :
                    therapeuticApproach = "Psychodynamic Therapy";
                    break;
                case 3:
                    therapeuticApproach = "Existential Therapy";
                    break;
            }
            System.out.printf("Therapist{nameSurname=%s, subfield=%s, therapeuticApproach=%s, therapyLanguage=%s," +
                            "therapyLanguage2=%s, yearInTheField=%d, costTherapy=%.0f, phoneNo=%s}\n",
                    t.getNameSurname(),subfield,therapeuticApproach,t.getTherapyLanguage(),t.getTherapyLanguage2(),
                    t.getYearInTheField(),t.getCostTherapy(),t.getPhoneNo());
        }
    }
}
