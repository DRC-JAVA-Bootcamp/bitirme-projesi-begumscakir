package FindTherapist;

class Therapist {
    private String nameSurname;
    private String idNumber;
    private int subfield;
    private int therapeuticApproach;
    private String therapyLanguage;
    private String therapyLanguage2;
    private int yearInTheField;
    private double costTherapy;
    private String phoneNo;

    public Therapist() {
    }

    public Therapist(String nameSurname, String idNumber, String phoneNo, int subfield, int therapeuticApproach,
                     String therapyLanguage,
                     String therapyLanguage2, int yearInTheField, double costTherapy){
        this.nameSurname= nameSurname;
        this.idNumber= idNumber;
        this.subfield= subfield;
        this.therapeuticApproach= therapeuticApproach;
        this.therapyLanguage= therapyLanguage;
        this.therapyLanguage2=therapyLanguage2;
        this.yearInTheField= yearInTheField;
        this.costTherapy= costTherapy;
        this.phoneNo= phoneNo;

    }
    public String getNameSurname(){
        return nameSurname;
    }
    public void setNameSurname(String nameSurname){
        this.nameSurname= nameSurname;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public void setIdNumber(String idNumber){
        this.idNumber= idNumber;
    }
    public int getSubfield(){
        return subfield;
    }
    public void setSubfield(int subfield){
        this.subfield= subfield;
    }
    public int getTherapeuticApproach(){
        return therapeuticApproach;
    }
    public void setTherapeuticApproach(int therapeuticApproach){
        this.therapeuticApproach= therapeuticApproach;
    }
    public String getTherapyLanguage(){
        return therapyLanguage;
    }
    public void setTherapyLanguage(String  therapyLanguage){
        this.therapyLanguage= therapyLanguage;
    }
    public int getYearInTheField(){
        return yearInTheField;
    }
    public void setYearInTheField(int yearInTheField){
        this.yearInTheField= yearInTheField;
    }
    public double getCostTherapy(){
        return costTherapy;
    }
    public void setCostTherapy(int costTherapy){
        this.costTherapy= costTherapy;
    }
    public String getTherapyLanguage2(){
        return therapyLanguage2;
    }
    public void setTherapyLanguage2(String therapyLanguage2) {
        this.therapyLanguage2 = therapyLanguage2;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "nameSurname='" + nameSurname + '\'' +
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