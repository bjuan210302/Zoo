package model;

import java.text.DecimalFormat;

public class Dragon {

    // Atributos //
    public static final char FEMALE = 'F';
    public static final char MALE = 'M';
    public static final String BLOOD_TYPE_A = "A";
    public static final String BLOOD_TYPE_B = "B";
    public static final String BLOOD_TYPE_AB = "AB";
    public static final String BLOOD_TYPE_O = "O";
    
    private String name;
    private String blood;
    private double weight;
    private double height;
    private int age;
    private char sex;
    private double BMI;

    private Date birthDate;
    DecimalFormat f;

    // Metodos //
    public Dragon(String na, String bl, double wg, double hg, char sx, int bd, int bm, int by) {
        name = na;
        blood = bl;
        weight = wg;
        height = hg;
        sex = sx;
        birthDate = new Date(bd, bm, by);
        f = new DecimalFormat("#.00");
    }

    public String getName() {
        return name;
    }
    public String getBlood() {
        return blood;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public String getBirthDate() {
        // Return a String like "DD/MM/YYYY" with the dragons's birthdate
        return birthDate.getDay() + ", " + birthDate.getMonth() + ", " + birthDate.getYear();
    }
    public int getAge() {
        // This method updates the variable "age" and then returns said variable //
        updateAge();
        return age;
    }
    public char getSex() {
        return sex;
    }
    public double getBMI() {
        // This method updates the variable "BMI" and then returns said variable //
        updateBMI();
        return BMI;
    }

    public void setName(String newName) {
        name = newName;
    }
    public void setWeight(double newWeight) {
        weight = newWeight;
    }
    public void setHeight(double newHeight) {
        height = newHeight;
    }
    
    public void updateAge() {
        // This method calcs and update "age" but returns nothig//
        int testAge = Date.currentDate.getYear() - birthDate.getYear();                                                  // Calc approximately how old the kangaroo is subtrating their birthdate year to the current year //

        if (birthDate.getMonth() == Date.currentDate.getMonth() && birthDate.getDay() > Date.currentDate.getDay()) {    // This 'if' compares the kangaroos' birthdate month to the current month, and birthdate day to the current day 
            age = testAge;                                                                                              // in both cases, if the first number is bigger than the second one it means that the kangaroo has already surpassed their birthday
        } else {
            age = testAge - 1;                                                                                          // If the animal hasnt surpassed their birthday yet, it means that kangaroos age is the difference between their birthdate year and the current year  //
        }
    }
    public void updateBMI() {
        // Updates the BMI variable //
            BMI = weight/(height*height);
    }

    public double calcAreaReq() {
        return height * 8;
    }
    public double calcFoodReq() {
        double foodReq;
            if(weight < 30){
                foodReq = (weight * 0.8); //  Asing 'foodReq' the 80% of the animal's weight //
            }else if(weight == 30 || weight > 30 && weight <48){
                foodReq = (weight + (weight * 0.1)); // Asing 'foodReq' the animal's weight increased by 10%//
            }else{
                double wDifference = weight - 48; // calcules the difference between kangaroo's weight and 48kg //
                foodReq = (40 + (wDifference * 0.4)); // Asing 'foodReq' 40kg in food plus 0.4kg per each kg he exceds 48 //
            }
            return foodReq;
    }
    public double calcWaterReq() {
        return (getBMI() * 0.75);
    }
    public double calcCR() {    // RC = Cardiac Risk //
        double cardiacRiskLevel = 0;
        if (BMI < 18) {
            if (blood.equals(BLOOD_TYPE_A) || blood.equals(BLOOD_TYPE_AB)) {
                cardiacRiskLevel = 1;
            } else {
                cardiacRiskLevel = 2;
            }
        }
        if (BMI >= 18 && BMI < 25) {
            cardiacRiskLevel = 1;
        }
        if (BMI >= 25) {
            if (blood.equals(BLOOD_TYPE_A) || blood.equals(BLOOD_TYPE_B) || blood.equals(BLOOD_TYPE_O)) {
                cardiacRiskLevel = 3;
            }
            if (blood.equals(BLOOD_TYPE_AB)) {
                cardiacRiskLevel = 2;
            }
        }
        return cardiacRiskLevel;
    }
    
    public String searchByLetter(){
            String nameList = "";
            String Name = getName();
            
            Name = Name.trim(); Name = Name.toLowerCase();
            int length = Name.length();
            
            char firstLetter = Name.charAt(0);
            char LastLetter = Name.charAt(length - 1);
            
            if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o'|| firstLetter == 'u'){
                if(LastLetter == 'a' || LastLetter == 'e' || LastLetter == 'i' || LastLetter == 'o'|| LastLetter == 'u'){
                nameList = getName() + "\n";
                }
            }
            return nameList;
        }
    
    public String DragonUI() {
        String ln1 = String.format("%63s", "|  |\n");
        String ln2 = String.format("%40s %s", "", "#######################################\n");
        String ln3 = String.format("%40s %s %-29.15s %s", "", "# Name:", getName(), "#\n");
        String ln4 = String.format("%40s %s %-12.13s %s %-3.2s %s", "", "# BirthDate:", getBirthDate(), "|  Age:", getAge(), "#\n");
        String ln5 = String.format("%40s %s %-6.5s %s %-9.5s %s", "","# Weight:", f.format(getWeight()), "|  Height:", f.format(getHeight()), "#\n");
        String ln6 = String.format("%39s %s %-9.1s %s %-5.2s %s", "", "_# Sex:", getSex(), "|  Blood Type:", getBlood(), "#\n");
        String ln7 = String.format("%38s %s %38s", "", "__#", "#\n");
        String ln8 = String.format("%37s %s %-21.10s %s", "", "___# Request Area:", f.format(calcAreaReq()) + "m2", "#\n");
        String ln9 = String.format("%38s %s %-21.10s %s", "", "__# Request Food:", f.format(calcFoodReq()) + "kg", "#\n");
        String ln10 = String.format("%39s %s %-20.19s %s", "", "_# Request Water:", f.format(calcWaterReq()) + "L/m2", "#\n");
        String ln11 = String.format("%40s %s %38s", "", "#", "#\n");
        String ln12 = String.format("%40s %s %-6.5s %s %-7.5s %s", "","# BMI:", f.format(getBMI()), "|  CardiacRisk:", f.format(calcCR()), "#\n");
        String ln13 = String.format("%40s %s", "", "#_____________________________________#\n");

        String screenText = ln1 + ln2 + ln3 + ln4 + ln5 + ln6+ ln7 +ln8 + ln9 + ln10 + ln11 + ln12 + ln13;
        return screenText;
    }
}
