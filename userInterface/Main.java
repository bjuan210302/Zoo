package userInterface;

import model.*;
import java.util.Scanner;

public class Main{
    
    private Scanner lec;
    private Scanner lecStrings;
    private SeccionAus sAustralia;
    private int select;
    
    public void Main(){
        sAustralia = new SeccionAus();
        lec = new Scanner(System.in);
		lecStrings = new Scanner(System.in);
    }
    public void insertDate(){
        
        System.out.println("Type today's date, please");
        System.out.println("");
        System.out.print("Day: ");
        Date.currentDate.setDay(lec.nextInt());
        System.out.print("Month (in numbers): ");
        Date.currentDate.setMonth(lec.nextInt());
        System.out.print("Year (four digits): ");
        Date.currentDate.setYear(lec.nextInt());
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");
    }
	
    public void seeAllAreas(){
        System.out.println("\n\n");
        System.out.println(sAustralia.SeccionAusUI());
    }
    public void seeZone1(){
        System.out.println(sAustralia.Zone1UI());
    }
    public void seeZone2(){
        System.out.println(sAustralia.Zone2UI());
    }
    
    public void addKang(){
		System.out.println("\nPlease type the necessary info:\n");
		
		System.out.print("Name: ");         String name = lecStrings.nextLine();
		System.out.print("Blood type: ");   String blood = lecStrings.nextLine();
		System.out.print("Weight (obligatory: .xxx): ");  double weight = lec.nextDouble();
		System.out.print("Height (obligatory: .xxx): ");  double height = lec.nextDouble();
		System.out.print("In environment: ");   int inEnvi = lec.nextInt();
		System.out.print("Sex (F/M): ");         String sexString = lecStrings.nextLine(); char sex = sexString.charAt(0);
		System.out.print("Birth day: ");   int bdDay = lec.nextInt();
		System.out.print("Birth month: "); int bdMonth = lec.nextInt();
		System.out.print("Birth year (xxxx): ");  int bdYear = lec.nextInt();
                System.out.print("");
		
		sAustralia.addKang(name, blood, weight, height, inEnvi, sex, bdDay, bdMonth, bdYear);
	}
    public void deleteKang(){
        System.out.println("\nWhat's the name of the kangaroo that you want to delete?");
        String kangName = lecStrings.nextLine();
        sAustralia.deleteKang(kangName);
    }
    
    public void menu(){
	System.out.println("\nWhat do you want to do?");
	System.out.println("1) See all areas                     2) See zone 1                     3) See zone 2");
	System.out.println("4) Add a new kangaroo                5) Delete a kangaroo              6) Edit a kangaroo");
	select = (lec.nextInt());
                
	switch(select){
		case 1: seeAllAreas();
		break;
			
		case 2: seeZone1();
		break;
			
		case 3: seeZone2();
		break;
                            
                case 4: addKang();
		break;
                        
                case 5: deleteKang();
		break;
                 
                case 6: System.out.println("Sorry, this option will be available soon!");
		break;
                
                case 10: System.out.println("GoodBye!");
		break;
			
		default: System.out.println("Sorry but option '" + select + "' doesn't exist.");
		}
	}
	
    
    
	
    

    
    public static void main(String args[]){
        Main main = new Main();
        main.Main();
        
        //main.insertDate();
        do{main.menu();} while(main.select != 10);
    }
}