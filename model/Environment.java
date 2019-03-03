package model;
import java.text.DecimalFormat;

public class Environment {
    // Atributes //
        public static final int MAX_KANGAROOS = 3;
        public static final int MIN_KANGAROOS = 1;
	private int numKangaroos = 0;
        private int enviID;
        
        // Kangaroos //
        public Kangaroo kangp1;
        public Kangaroo kangp2;
        public Kangaroo kangp3;
        
        DecimalFormat f;
		
	// Methods //
	public Environment(int ID, Kangaroo nkang1, Kangaroo nkang2, Kangaroo nkang3){
            enviID = ID;
            kangp1 = nkang1;
            kangp2 = nkang2;
            kangp3 = nkang3;
            
            f = new DecimalFormat("#.00");
        }
	
        //General Services
	public double getTotalArea(){
            double areaReq = 0;
            if(kangp1 != null){areaReq += kangp1.calcAreaReq();}
            if(kangp2 != null){areaReq += kangp2.calcAreaReq();}
            if(kangp3 != null){areaReq += kangp3.calcAreaReq();}
            
            return areaReq;
	}
	public int getNumKangaroos(){
	    updateNumKangaroos();
            return numKangaroos;
	}
        public int getEnviID(){
            return enviID;
        }
	
        // these "setKang" methods are used to create, move and delete kangaroos //
	public void setKangp1(Kangaroo newKang){
		kangp1 = newKang;
	}
	public void setKangp2(Kangaroo newKang){
		kangp2 = newKang;
	}
	public void setKangp3(Kangaroo newKang){
		kangp3 = newKang;
	}
	
	public double calcTotalFoodReq(){
            double foodReq = 0;
            if(kangp1 != null){foodReq += kangp1.calcFoodReq();}
            if(kangp2 != null){foodReq += kangp2.calcFoodReq();}
            if(kangp3 != null){foodReq += kangp3.calcFoodReq();}
            
            return foodReq;
        }
        public double calcTotalWaterReq(){
            double waterReq = 0;
            if(kangp1 != null){waterReq += kangp1.calcWaterReq();}
            if(kangp2 != null){waterReq += kangp2.calcWaterReq();}
            if(kangp3 != null){waterReq += kangp3.calcWaterReq();}
            
            return waterReq;
        }
        public double calcTotalAreaReq(){
            double areaReq = 0;
            if(kangp1 != null){areaReq += kangp1.calcAreaReq();}
            if(kangp2 != null){areaReq += kangp2.calcAreaReq();}
            if(kangp3 != null){areaReq += kangp3.calcAreaReq();}
            
            return areaReq;
        }
        public double calcAvAge(){ // AvAge = Average Age //
            double avAge = 0;
            if(kangp1 != null){avAge += kangp1.getAge();}
            if(kangp2 != null){avAge += kangp2.getAge();}
            if(kangp3 != null){avAge += kangp3.getAge();}
            
            return avAge/getNumKangaroos();
        }
        public double calcAvBMI(){// AvBMI = Average Body Mass Index //
            double avBMI = 0;
            if(kangp1 != null){avBMI += kangp1.getBMI();}
            if(kangp2 != null){avBMI += kangp2.getBMI();}
            if(kangp3 != null){avBMI += kangp3.getBMI();}
            
            return avBMI/getNumKangaroos();
        }      		   
        public double calcAvCR(){// AvCR = Average Cardiac Risk //
            double avCR = 0;
            if(kangp1 != null){avCR += kangp1.calcCR();}
            if(kangp2 != null){avCR += kangp2.calcCR();}
            if(kangp3 != null){avCR += kangp3.calcCR();}
            
            return avCR/getNumKangaroos();
        }
        public boolean calcAllVaccined(){
            // Test if all kangaroos inside a environment are vaccined //
            boolean needVacc1 = false, needVacc2 = false, needVacc3 = false, generalNeedVacc;
            
            if(kangp1 != null){needVacc1 = kangp1.needVaccine();}
            if(kangp2 != null){needVacc2 = kangp2.needVaccine();}
            if(kangp3 != null){needVacc3 = kangp3.needVaccine();}
            
            if(needVacc1 == false && needVacc2 == false && needVacc3 == false){ // If noone needs a vaccine then they all are vaccined //
                generalNeedVacc = true;
            }else{
                generalNeedVacc = false;
            }
            return generalNeedVacc;
        }
        
        public void updateNumKangaroos(){
            // Checks if some kangaroo is now null or != null //
            int newNumKangaroos = 0; // This is to count how many kangaroos are != null //
            if(kangp1 != null){newNumKangaroos ++;}
            if(kangp2 != null){newNumKangaroos ++;}
            if(kangp3 != null){newNumKangaroos ++;}
            
            numKangaroos = newNumKangaroos;
        }
        
        public boolean existMale(){
            // Checks y theres already a male kangaroo in the environment //
            boolean existMale = false;
            
            if(kangp1 != null && kangp1.getSex() == Kangaroo.MALE){existMale = true;}
            if(kangp2 != null && kangp2.getSex() == Kangaroo.MALE){existMale = true;}
            if(kangp3 != null && kangp3.getSex() == Kangaroo.MALE){existMale = true;}
            
            return existMale;
        }
        public boolean deleteKang(String kangName){
            // Search for coincidences between a searched name and a kangaroo name //
            // If searched name and a kangaroo name are equals that kangaroo is turned to null //
            boolean kangDeleted = false;
            if(kangp1 != null && kangp1.getName().equals(kangName)){kangp1 = null; kangDeleted = true;}
            else if(kangp2 != null && kangp2.getName().equals(kangName)){kangp2 = null; kangDeleted = true;}
            else if(kangp3 != null && kangp3.getName().equals(kangName)){kangp3 = null; kangDeleted = true;}
            
            return kangDeleted; // Returns a boolean to make others methods know if the kangaroo was found and deleted //
        }
        public Kangaroo searchKang(String kangName){
            // Search for coincidences between a searched name and a kangaroo name //
            // If searched name and a kangaroo name are equals the method return said kangaroo //
            Kangaroo kangFound = null;
            if(kangp1 != null && kangp1.getName().equals(kangName)){kangFound = kangp1;}
            else if(kangp2 != null && kangp2.getName().equals(kangName)){kangFound = kangp2;}
            else if(kangp3 != null && kangp3.getName().equals(kangName)){kangFound = kangp3;}
            
            return kangFound;
        }
        public String searchByVowel(){
            // Uses searchByVowel() in Kangaroo class to check all kangaroos in the environment //
            String nameList = "";
            if(kangp1 != null){nameList += kangp1.searchByVowel();}
            if(kangp2 != null){nameList += kangp2.searchByVowel();}
            if(kangp3 != null){nameList += kangp3.searchByVowel();}
            
            return nameList;
        }
        public String neededVaccines(){
            // Uses daysTillVaccine() in Kangaroo class to check all kangaroos in the environment and then put them in a list //
            String nameList = "\nName:     (ENVIRONMENT " + getEnviID() +")     Days to vaccine\n";
            if(kangp1 != null){nameList += String.format("%-30.10s %s %s", kangp1.getName(), kangp1.calcDaysTillVaccine(),"\n");}
            if(kangp2 != null){nameList += String.format("%-30.10s %s %s", kangp2.getName(), kangp2.calcDaysTillVaccine(),"\n");}
            if(kangp3 != null){nameList += String.format("%-30.10s %s %s", kangp3.getName(), kangp3.calcDaysTillVaccine(),"\n");}
            
            return nameList;
        }
        
        public String EnvironmentUI(){
        //Creates a screen with this class information //
        String ln1 = String.format("\n\n       ###############################\n");
        String ln2 = String.format("%6s %s %-6.2s %s", "", "# Kangaroo Environment", getEnviID(), "#\n");
        String ln3 = String.format("%6s %s", "", "#                             #\n");
        String ln4 = String.format("%6s %s %-15.10s %s", "", "# Total Area:", f.format(getTotalArea()) + "m2", "#\n");
        String ln5 = String.format("%6s %s", "", "#                             #\n");
        String ln6 = String.format("%6s %s %-12.2s %s", "", "# Total Animals:", getNumKangaroos(), "#___________________\n");
        String ln7 = String.format("%6s %s %-13.6s %s", "", "# All Vaccined:", calcAllVaccined(),  "#                 | |\n");
        String ln8 = String.format("%6s %s", "", "#                             #                 | |\n");
        String ln9 = String.format("%6s %s %-9.7s %s", "", "# Food Requirement:", f.format(calcTotalFoodReq())   + "kg", "#                 | |\n");
        String ln10 = String.format("%6s %s %-8.7s %s", "", "# Water Requirement:", f.format(calcTotalWaterReq()) + "L", "#                 | |\n");
        String ln11 = String.format("%6s %s", "", "#                             #                 | |\n");
        String ln12 = String.format("%6s %s %-14.7s %s", "", "# Average Age:", f.format(calcAvAge()), "#                 | |\n");
        String ln13 = String.format("%6s %s %-5.4s %s", "", "# Average Cardiac Risk:", f.format(calcAvCR()), "#                 | |\n");
        String ln14 = String.format("%6s %s", "", "#_____________________________#                 | |\n");
        
        String screenText = ln1 + ln2 + ln3 + ln4 + ln5 + ln6 + ln7 + ln8 + ln9 + ln10 + ln11 + ln12 + ln13 + ln14;
        
        // Add kangaroos info to this screen //
        if(kangp1 != null){screenText += kangp1.KangarooUI();}
        if(kangp2 != null){screenText += kangp2.KangarooUI();}
        if(kangp3 != null){screenText += kangp3.KangarooUI();}
        
        return screenText;
        }
        
}
