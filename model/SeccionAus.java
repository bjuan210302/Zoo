package model;

import java.text.DecimalFormat;

public class SeccionAus{
	
	// Atributos //
	private static final double TOTAL_AREA = 1500;
	private static final int TOTAL_ZONES = 2;
	private int totalAnimals;
        
        // Zonas //
        private Zone1 zonak1;
        private Zone2 zonad1;
        
        
        DecimalFormat f;
	
	// SeccionAus Methods//
        // Constructor 
	public SeccionAus(){
		
            Environment envi1;
			Environment envi2;
			Environment envi3;
			
            Kangaroo kang1 = new Kangaroo("nameK1", "A", 58.8, 1.9, 1, 'M', 19, 2, 2015);
            Kangaroo kang2 = new Kangaroo("nameK2", "B", 32.6, 1.3, 1, 'F', 5, 3, 1998);
            Kangaroo kang3 = new Kangaroo("nameK3", "AB", 37.2, 1.6, 1, 'F', 22,2, 2018);
            envi1 = new Environment (1, null, null, null);
			
            Kangaroo kang4 = new Kangaroo("nameK4", "A", 24.2, 1.3, 2, 'F', 4, 1, 2018);
            Kangaroo kang5 = new Kangaroo("nameK5", "O", 36.4, 2.4, 2, 'M', 18, 12, 2018);
            Kangaroo kang6 = new Kangaroo("nameK6", "AB", 27.2, 1.7, 2, 'F', 29, 4, 2017);
            envi2 = new Environment (2, null, null, null);
			
            Kangaroo kang7 = new Kangaroo("nameK7", "O", 22.2, 1.1, 3, 'F', 17, 5, 2003);
            Kangaroo kang8 = new Kangaroo("nameK8", "B", 30.3, 1.8, 3, 'M', 6, 1, 2018);
            Kangaroo kang9 = new Kangaroo("nameK9", "B", 26.2, 1.4, 3, 'F', 2, 6, 1999);
            envi3 = new Environment (3, null, null, null);
            
            zonak1 = new Zone1(envi1, envi2, envi3);
			
            Dragon drag1 = new Dragon("awtfffffffu", "AB", 75.34, 2.75, 'F', 21, 5, 1992);
            Dragon drag2 = new Dragon("uhho", "B", 82.13, 3.42, 'M', 18, 11, 1988);
            zonad1 = new Zone2(15.5, drag1, drag2);
            
            f = new DecimalFormat("#.00");
        }
	
        //General Services
	public double getTotalArea(){
		return TOTAL_AREA;
	}
	public int getTotalZones(){
		return TOTAL_ZONES;
	}
	public int getTotalAnimals(){
                updateTotalAnimals();
		return totalAnimals;
	}
        
        public void updateTotalAnimals(){
            int newTotalAnimals = zonak1.getNumKangaroos() + zonad1.getNumDragons();
            totalAnimals = newTotalAnimals;
        }
        
	public void addKang(String name, String blood, double weight, double height, int inEnvi, char sex, int bdDay, int bdMonth, int bdYear){
		zonak1.addKang(name, blood, weight, height, inEnvi, sex, bdDay, bdMonth, bdYear);
	}
        public void deleteKang(String kangName){
            System.out.println(zonak1.deleteKang(kangName));
        }
        public void moveKang(String kangName, int toEnvi){
            System.out.println(zonak1.moveKang(kangName, toEnvi));
        }
        public String searchByLetter(){
            String nameList = "";
            nameList += zonak1.searchByLetter();
            nameList += zonad1.searchByLetter();
            
            return nameList;
        }
        public String neededVaccines(){
            String nameList = "";
            
            nameList += zonak1.neededVaccines();
            return nameList;
        }
	
	public double calcTotalAreaReq(){
            return zonak1.calcTotalAreaReq() + zonad1.calcTotalAreaReq();
        }
	public double calcTotalFoodReq(){
            return zonak1.calcTotalFoodReq() + zonad1.calcTotalFoodReq();
        }
	public double calcTotalWaterReq(){
            return zonak1.calcTotalWaterReq() + zonad1.calcTotalWaterReq();
        }
	public double calcAvAge(){
            return (zonak1.calcAvAge() + zonad1.calcAvAge())/2;
        }
	public double calcAvBMI(){       // AvBMI = Average Body Mass Index //
            return (zonak1.calcAvBMI() + zonad1.calcAvBMI())/2;
        }      	  	   
	public double calcAvCR(){        // AvCR = Average Cardiac Risk //
            return (zonak1.calcAvCR() + zonad1.calcAvCR())/2;
        }
	public double calcFreeArea(){
            return getTotalArea() - (zonak1.calcTotalAreaReq() + zonad1.calcTotalAreaReq());
        }
	public boolean calcAllVaccined(){
            return zonak1.calcAllVaccined();
        }
        
        public String SeccionAusUI(){
            
            String ln0 = String.format("%40s %s",                         "", "#############################################################################\n");
            String ln1 = String.format("%40s %s",                         "", "#                      Section 'Australia'                                  #\n");
            String ln2 = String.format("%40s %s",                         "", "#                                                                           #\n");
            String ln3 = String.format("%40s %s %-24.5s %s",              "", "#   Terrain:                              Animals:", getTotalAnimals(), "#\n");
            String ln4 = String.format("%40s %s %-22.10s %s %-9.8s %s",   "", "#    |__Total Area:", f.format(getTotalArea()) + "m2",           "|__ Food requirement: ", f.format(calcTotalFoodReq()) + "kg", "#\n");
            String ln5 = String.format("%40s %s %-21.10s %s %-8.7s %s",   "", "#    |__Taken Area: ", f.format(calcTotalAreaReq()) + "m2",      "|__ Water requirement: ", f.format(calcTotalWaterReq()) + "L", "#\n");
            String ln6 = String.format("%40s %s %-22.10s %s %-14.12s %s", "", "#    |__Free Area: ", f.format(calcFreeArea()) + "m2",           "|__ Average age: ", f.format(calcAvAge()), "#\n");
            String ln7 = String.format("%40s %s %67s %-5.4s %s",          "", "#", "|__ Average cardiac risk: ", f.format(calcAvCR()), "#\n");
            String ln8 = String.format("%40s %s",                         "", "#___________________________________________________________________________#\n");
            String ln9 = String.format("%s", "\n\n");
            
            String screenText = ln0 + ln1 + ln2 + ln3 + ln4 + ln5 + ln6 + ln7 + ln8 + ln9;
            
            screenText += zonak1.ZoneUI();
            screenText += zonad1.ZoneUI();
            
            return screenText;
        }
        public String Zone1UI(){
            String screenText = zonak1.ZoneUI();
            return screenText;
        }
        public String Zone2UI(){
            String screenText = zonad1.ZoneUI();
            return screenText;
        }
}