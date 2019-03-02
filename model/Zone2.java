package model;
import java.text.DecimalFormat;

public class Zone2{
	
	// Atributos //
        private static final double TOTAL_AREA = 1500/2;
	private int numDragons;
        private double foodInWeight;
        private int temp;
	
        // Dragones //
        public Dragon drag1;
        public Dragon drag2;
        
        DecimalFormat f;
        
	// Metodos //
	public Zone2(double fIw, Dragon ndrag1, Dragon ndrag2){
            foodInWeight = fIw;
            temp = 37;
            drag1 = ndrag1;
            drag2 = ndrag2;
            
            f = new DecimalFormat("#.00");
        }
        
        public double getTotalArea(){
		return TOTAL_AREA;
	}
        public double getFoodInWeight(){
            return foodInWeight;
        }
	public int getNumDragons(){
		int kCounter = 0;
            if(drag1 != null){kCounter ++;}
            if(drag2 != null){kCounter ++;}
            
            return kCounter;
	}
        public int getTemp(){
		return temp;
	}
        
	public double calcTotalAreaReq(){
        return drag1.calcAreaReq() + drag2.calcAreaReq();
        }
        public double calcTotalFoodReq(){
            double foodReq = 0;
            if(drag1 != null){foodReq += drag1.calcFoodReq();}
            if(drag2 != null){foodReq += drag2.calcFoodReq();}
            
            return foodReq;
        }
        public double calcTotalWaterReq(){
            double waterReq = 0;
            if(drag1 != null){waterReq += drag1.calcWaterReq();}
            if(drag2 != null){waterReq += drag2.calcWaterReq();}
            
            return waterReq;
        }
        public double calcFreeArea(){
            return TOTAL_AREA - calcTotalAreaReq(); 
        }
        public double calcAvAge(){
            double avAge = 0;
            if(drag1 != null){avAge += drag1.getAge();}
            if(drag2 != null){avAge += drag2.getAge();}
            
            return avAge/2;
        }
        public double calcAvBMI(){   // AvBMI = Average Body Mass Index //
            double avBMI = 0;
            if(drag1 != null){avBMI += drag1.getBMI();}
            if(drag2 != null){avBMI += drag2.getBMI();}
            
            return avBMI/2;
        }
        public double calcAvCR(){
            double avCR = 0;
            if(drag1 != null){avCR += drag1.calcCR();}
            if(drag2 != null){avCR += drag2.calcCR();}
            
            return avCR/2;
        }
        
        public void updateNumDragons(){
            int newNumDragons = 0;
            if(drag1 != null){newNumDragons ++;}
            if(drag2 != null){newNumDragons ++;}
            numDragons = newNumDragons;
        }
        
	public void heatingControl(int newTemp){
            temp = newTemp;
        }
        
        public String ZoneUI(){
            
            String ln0 = String.format("%s",                          "______________________________________________________________________________");
            String ln1 = String.format("%s",                          "\n\n##############################################################################\n");
            String ln2 = String.format("%s",                          "#                            Zone 2: Dragons                                 #\n");
            String ln3 = String.format("%s",                          "#                                                                            #\n");
            String ln4 = String.format("%s %-24.5s %s",               "#    Terrain:                              Animals:", getNumDragons(), "#\n");
            String ln5 = String.format("%s %-21.10s %s %-10.9s %s",   "#     |__Total Area: ", f.format(getTotalArea()) + "m2",    "|__ Food requirement:", f.format(calcTotalFoodReq())+ "kg", "#\n");
            String ln6 = String.format("%s %-22.10s %s %-8.7s %s",    "#     |__Taken Area:", f.format(calcTotalAreaReq()) + "m2", "|__ Water requirement: ", f.format(calcTotalWaterReq()) + "L", "#\n");
            String ln7 = String.format("%s %-23.10s %s %-14.12s %s",  "#     |__Free Area:", f.format(calcFreeArea()) + "m2",      "|__ Average age: ", f.format(calcAvAge()), "#\n");
            String ln8 = String.format("%s %-20.10s %s %-6.5s %s",    "#     |__ Temperature:", getTemp()+ "°C",                   "|__ Average cardiac risk:", f.format(calcAvCR()), "#\n");
            String ln9 = String.format("%s %61s %-12.10s %s",         "#",                                                         "|__ Food in weight:", getFoodInWeight() + "kg", "#\n");
            String ln10 = String.format("%s",                         "#____________________________________________________________________________#\n");
            
            String screenText = ln0 + ln1 + ln2 + ln3 + ln4 + ln5 + ln6 + ln7 + ln8 + ln9 + ln10;
            
            if(drag1 != null){screenText += drag1.DragonUI();}
            if(drag2 != null){screenText += drag2.DragonUI();}
            
            return screenText;
    }
}