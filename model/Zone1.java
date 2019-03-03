package model;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Zone1{
	
	// Atributos //
        private static final double TOTAL_AREA = 1500/2;
	private int numEnvi;
	private int numKangaroos;
        private Scanner lec;
        
        // Environments //
        private Environment envi1;
        private Environment envi2;
        private Environment envi3;
        
        DecimalFormat f;
		
	// Metodos //
	public Zone1(Environment nEnvi1, Environment nEnvi2, Environment nEnvi3){
            envi1 = nEnvi1;
            envi2 = nEnvi2;
            envi3 = nEnvi3;
            lec = new Scanner(System.in);
            f = new DecimalFormat("#.00");
        }
	
        public double getTotalArea(){
		return TOTAL_AREA;
	}
	public int getNumEnvi(){
            updateNumEnvi();
            return numEnvi;
	}
	public int getNumKangaroos(){
                updateNumKangaroos();
		return numKangaroos;
	}
        
	public Environment getEnvi1(){
		return envi1;
	}
	public Environment getEnvi2(){
		return envi2;
	}
	public Environment getEnvi3(){
		return envi3;
	}
	
        public void updateNumKangaroos(){
            int newNumKangaroos = 0;
            if(envi1 != null){newNumKangaroos += envi1.getNumKangaroos();}
            if(envi2 != null){newNumKangaroos += envi2.getNumKangaroos();}
            if(envi3 != null){newNumKangaroos += envi3.getNumKangaroos();}
            numKangaroos = newNumKangaroos;
        }
        public void updateNumEnvi(){
            int newNumEnvi = 0;
            if(envi1 != null){newNumEnvi ++;}
            if(envi2 != null){newNumEnvi ++;}
            if(envi3 != null){newNumEnvi ++;}
            
            numEnvi = newNumEnvi;
        }
        
        
        public double calcTotalAreaReq(){
            double areaReq = 0;
            if(envi1 != null){areaReq += envi1.calcTotalAreaReq();}
            if(envi2 != null){areaReq += envi2.calcTotalAreaReq();}
            if(envi3 != null){areaReq += envi3.calcTotalAreaReq();}
            
            return areaReq;
        }
	public double calcTotalFoodReq(){
            double foodReq = 0;
            if(envi1 != null){foodReq += envi1.calcTotalFoodReq();}
            if(envi2 != null){foodReq += envi2.calcTotalFoodReq();}
            if(envi3 != null){foodReq += envi3.calcTotalFoodReq();}
            
            return foodReq;
        }
        public double calcTotalWaterReq(){
            double waterReq = 0;
            if(envi1 != null){waterReq += envi1.calcTotalWaterReq();}
            if(envi2 != null){waterReq += envi2.calcTotalWaterReq();}
            if(envi3 != null){waterReq += envi3.calcTotalWaterReq();}
            
            return waterReq;
        }
        public double calcFreeArea(){
            return TOTAL_AREA - calcTotalAreaReq(); 
        }
        public double calcAvAge(){
            double avAge = 0;
            if(envi1 != null){avAge += envi1.calcAvAge();}
            if(envi2 != null){avAge += envi2.calcAvAge();}
            if(envi3 != null){avAge += envi3.calcAvAge();}
            
            return avAge/3;
        }
        public double calcAvBMI(){
            double AvBMI = 0;
            if(envi1 != null){AvBMI += envi1.calcAvBMI();}
            if(envi2 != null){AvBMI += envi2.calcAvBMI();}
            if(envi3 != null){AvBMI += envi3.calcAvBMI();}
            
            return AvBMI/3;
        }
        public double calcAvCR(){// AvCR = Average Cardiac Risk //
            double avCR = 0;
            if(envi1 != null){avCR += envi1.calcAvCR();}
            if(envi2 != null){avCR += envi2.calcAvCR();}
            if(envi3 != null){avCR += envi3.calcAvCR();}
            
            return avCR/3;
        }
        public boolean calcAllVaccined(){
            boolean needVacc1 = false, needVacc2 = false, needVacc3 = false, generalNeedVacc;
            
            if(envi1 != null){needVacc1 = envi1.calcAllVaccined();}
            if(envi2 != null){needVacc2 = envi2.calcAllVaccined();}
            if(envi3 != null){needVacc3 = envi3.calcAllVaccined();}
            
            if(needVacc1 == false && needVacc2 == false && needVacc3 == false){
                generalNeedVacc = true;
            }else{
                generalNeedVacc = false;
            }
            return generalNeedVacc;
        }
        
        
        
        public String infoComprobation(String blood, char sex, String name){
            String message = "";
            if(!(blood.equals(Kangaroo.BLOOD_TYPE_A)) && 
                    !(blood.equals(Kangaroo.BLOOD_TYPE_B)) &&
                    !(blood.equals(Kangaroo.BLOOD_TYPE_AB))&&
                    !(blood.equals(Kangaroo.BLOOD_TYPE_O)))
            {message += "\nError, blood type '" + blood + "' doesn't exist";}
            
            if(sex != Kangaroo.MALE && sex != Kangaroo.FEMALE){
            message += "\nError, '" + sex + "' isn't a valid character";}
            
            if(envi1.searchKang(name) != null || envi2.searchKang(name) != null || envi3.searchKang(name) != null){
            message += "\nError, name '" + name + "' is assigned to another kangaroo";}
            return message;
        }
        
	public void addKang(String name, String blood, double weight, double height, int inEnvi, char sex, int bdDay, int bdMonth, int bdYear){
            Kangaroo newKang = new Kangaroo(name, blood, weight, height, inEnvi, sex, bdDay, bdMonth, bdYear);
            String message = "";
            int select;
		
        if(getNumKangaroos() == getNumEnvi()*3) {message = "Error, there's no space for another kangaroo! Try deleting one of those existing ones.";}
	else{
                select = newKang.getInEnvi();
		switch(select){
                    case 1:
                    message = infoComprobation(newKang.getBlood(), newKang.getSex(), newKang.getName());
                    
                    if (message.equals("")){
                        if(envi1.getNumKangaroos() == Environment.MAX_KANGAROOS){message += "\nError, there's no space for another kangaroo in ENVIRONMENT 1";}
                        else if(sex == Kangaroo.MALE && envi1.existMale() == true){message += "\nError, there's already a male kangaroo in ENVIRONMENT 1";}
                        else if(envi1.kangp1 == null){getEnvi1().setKangp1(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully"; }
                        else if(envi1.kangp2 == null){getEnvi1().setKangp2(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                        else if(envi1.kangp3 == null){getEnvi1().setKangp3(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                    }break;
                    
                    case 2:
                    message = infoComprobation(newKang.getBlood(), newKang.getSex(), newKang.getName());
                    
                    if (message.equals("")){
                        if(envi2.getNumKangaroos() == Environment.MAX_KANGAROOS){message += "\nError, there's no space for another kangaroo in ENVIRONMENT 2";}
                        else if(sex == Kangaroo.MALE && envi2.existMale() == true){message += "\nError, there's already a male kangaroo in ENVIRONMENT 2";}
                        else if(envi2.kangp1 == null){getEnvi2().setKangp1(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                        else if(envi2.kangp2 == null){getEnvi2().setKangp2(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                        else if(envi2.kangp3 == null){getEnvi2().setKangp3(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                    }break;
                    
                    case 3:
                    message = infoComprobation(newKang.getBlood(), newKang.getSex(), newKang.getName());
                    
                    if (message.equals("")){
                        if(envi3.getNumKangaroos() == Environment.MAX_KANGAROOS){message += "\nError, there's no space for another kangaroo in ENVIRONMENT 3";}
                        else if(sex == Kangaroo.MALE && envi3.existMale() == true){message += "\nError, there's already a male kangaroo in ENVIRONMENT 3";}
                        else if(envi3.kangp1 == null){getEnvi3().setKangp1(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                        else if(envi3.kangp2 == null){getEnvi3().setKangp2(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                        else if(envi3.kangp3 == null){getEnvi3().setKangp3(newKang); message = "\nKangaroo " + newKang.getName() + " added successfully";}
                    }break;
                    
                    default: message = "\nError, there's no 'ENVIRONMENT " + newKang.getInEnvi() + "'";
                }
	}
			
		System.out.println (message);
    }
        public String deleteKang(String kangName){
            String message = "\nSorry, kangaroo '" + kangName +"' wasn't found";
            if(envi1.deleteKang(kangName) == true){message = "\nKangaroo '" + kangName +"' successfully deleted";}
            if(envi2.deleteKang(kangName) == true){message = "\nKangaroo '" + kangName +"' successfully deleted";}
            if(envi3.deleteKang(kangName) == true){message = "\nKangaroo '" + kangName +"' successfully deleted";}
            return message;
        }
        public String moveKang(String kangName, int toEnvi){
            Kangaroo copiedKang = null;
            String message = "\nMake sure you write the requested info correctly."
                        + "\nRemember: Write the animal's name exactly as it is showed on the info bar. "
                        + "\nRemember: There's only 3 environments.";
            
            if(envi1.searchKang(kangName) != null){copiedKang = envi1.searchKang(kangName);}
            else if(envi2.searchKang(kangName) != null){copiedKang = envi2.searchKang(kangName);}
            else if(envi3.searchKang(kangName) != null){copiedKang = envi3.searchKang(kangName);}
            
            if(copiedKang != null){
            copiedKang.setInEnvi(toEnvi);
            switch(copiedKang.getInEnvi()){
                case 1:
                    if(envi1.existMale() == true && copiedKang.getSex() == 'M'){
                        message = "\nError, there's already a male kangaroo in ENVIRONMENT 1";
                    }else if(envi1.getNumKangaroos() < 3){
                    deleteKang(kangName);
                    addKang(copiedKang.getName() + "", copiedKang.getBlood(), copiedKang.getWeight(), copiedKang.getHeight(), toEnvi, copiedKang.getSex(), copiedKang.getbdDay(), copiedKang.getbdMonth(), copiedKang.getbdYear());
                    message = "Successful process";
                    }
                    break;
                    
                case 2:
                    if(envi2.existMale() == true && copiedKang.getSex() == 'M'){
                        message = "\nError, there's already a male kangaroo in ENVIRONMENT 1";
                    }else if(envi2.getNumKangaroos() < 3){
                    deleteKang(kangName);
                    addKang(copiedKang.getName() + "", copiedKang.getBlood(), copiedKang.getWeight(), copiedKang.getHeight(), toEnvi, copiedKang.getSex(), copiedKang.getbdDay(), copiedKang.getbdMonth(), copiedKang.getbdYear());
                    message = "Successful process";
                    }
                    break;
                    
                case 3:
                    if(envi3.existMale() == true && copiedKang.getSex() == 'M'){
                        message = "\nError, there's already a male kangaroo in ENVIRONMENT 1";
                    }else if(envi3.getNumKangaroos() < 3){
                    deleteKang(kangName);
                    addKang(copiedKang.getName() + "", copiedKang.getBlood(), copiedKang.getWeight(), copiedKang.getHeight(), toEnvi, copiedKang.getSex(), copiedKang.getbdDay(), copiedKang.getbdMonth(), copiedKang.getbdYear());
                    message = "Successful process";
                    }
                    break;
                    
                default:message = "\nMake sure you write the requested info correctly."
                        + "\nRemember: Write the animal's name exactly as it is showed on the info bar. "
                        + "\nRemember: There's only 3 environments.";}
            }
            
            return message;
        }
	
        public String searchByLetter(){
            String nameList = "";
            nameList += envi1.searchByLetter();
            nameList += envi2.searchByLetter();
            nameList += envi3.searchByLetter();
            
            return nameList;
        }
        public String neededVaccines(){
            String nameList = "";
            
            nameList += envi1.neededVaccines();
            nameList += envi2.neededVaccines();
            nameList += envi3.neededVaccines();
            
            return nameList;
        }
	
        public String ZoneUI(){
            
            String ln1 = String.format("%s",                         "#############################################################################\n");
            String ln2 = String.format("%s",                         "#                             Zone 1: Kangaroos                             #\n");
            String ln3 = String.format("%s",                         "#                                                                           #\n");
            String ln4 = String.format("%s %-24.6s %s",              "#    Terrain:                             Animals:", getNumKangaroos(), "#\n");
            String ln5 = String.format("%s %-21.10s %s %-10.9s %s",  "#     |__Total Area:", f.format(getTotalArea()) + "m2",     "|__ Food requirement:", f.format(calcTotalFoodReq())+ "kg", "#\n");
            String ln6 = String.format("%s %-21.10s %s %-9.8s %s",   "#     |__Taken Area:", f.format(calcTotalAreaReq()) + "m2", "|__ Water requirement:", f.format(calcTotalWaterReq()) + "L", "#\n");
            String ln7 = String.format("%s %-22.10s %s %-15.10s %s", "#     |__Free Area:", f.format(calcFreeArea()) + "m2",      "|__ Average age:", f.format(calcAvAge()), "#\n");
            String ln8 = String.format("%s %66s %-6.5s %s",          "#",                                                         "|__ Average cardiac risk:", f.format(calcAvCR()), "#\n");
            String ln9 = String.format("%s",                         "#___________________________________________________________________________#");
            
            String screenText = ln1 + ln2 + ln3 + ln4 + ln5 + ln6 + ln7 + ln8 + ln9;
            
            if(envi1 != null){screenText += envi1.EnvironmentUI();}
            if(envi2 != null){screenText += envi2.EnvironmentUI();}
            if(envi3 != null){screenText += envi3.EnvironmentUI();}
            
            return screenText;
    }
}