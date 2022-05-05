package FindTherapist;

class Visitor {  /** Visitor is one who use the app, is not a client but a potential client. */

   private String name;
   private int age;
   private String languagePreference;
   private int therapyPreference;
   private int expectationFromTherapy;
   private double maxCost;

   public Visitor() {
   }
   public Visitor(String name, int age, String languagePreference, int therapyPreference, int
                  expectationFromTherapy, double maxCost){

      this.name= name;
      this.age= age;
      this.languagePreference=languagePreference;
      this.therapyPreference=therapyPreference;
      this.expectationFromTherapy=expectationFromTherapy;
      this.maxCost=maxCost;

   }

   public String getName(){
      return name;
   }
   public void setName(String name){
      this.name= name;
   }
   public int getAge(){
      return age;
   }
   public void setAge(int age){
      this.age= age;
   }
   public String getLanguagePreference(){
      return languagePreference;
   }
   public void setLanguagePreference(String languagePreference){
      this.languagePreference=languagePreference;
   }
   public int getTherapyPreference(){
      return therapyPreference;
   }
   public void setTherapyPreference(int therapyPreference){
      this.therapyPreference= therapyPreference;
   }
   public int getExpectationFromTherapy(){
      return expectationFromTherapy;
   }
   public void setExpectationFromTherapy(int expectationFromTherapy){
      this.expectationFromTherapy=expectationFromTherapy;
   }
   public double getMaxCost(){
      return maxCost;
   }
   public void setMaxCost(int maxCost){
      this.maxCost= maxCost;
   }

   @Override
   public String toString() {
      return "Visitor{" +
              "name='" + name + '\'' +
              ", age=" + age +
              ", languagePreference='" + languagePreference + '\'' +
              ", therapyPreference=" + therapyPreference +
              ", expectationFromTherapy=" + expectationFromTherapy +
              ", maxCost=" + maxCost +
              '}';
   }
}
