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
	
    public void screenTextPrinter(){
        System.out.println("\n\n");
        System.out.println(sAustralia.SeccionAusUI());
    }
    public void menu(){
	System.out.println("What do you want to do?");
	System.out.println("1) See all areas                     2) See zone 1                     3) See zone 2");
	System.out.println("4) Add a new kangaroo                5) Delete a kangaroo              6) Edit a kangaroo");
	select = (lec.nextInt());
                
	switch(select){
		case 1: screenTextPrinter();
		break;
			
		case 2: System.out.println("Sorry, this option will be available soon!");
		break;
			
		case 3: System.out.println("Sorry, this option will be available soon!");
		break;
                            
        case 4: addKang();
		break;
                        
        case 5: System.out.println("Sorry, this option will be available soon!");
		break;
                 
        case 6: System.out.println("Sorry, this option will be available soon!");
		break;
			
		default: System.out.println("Sorry but option '" + select + "' doesn't exist.");
		}
	}
	
	public void addKang(){
		System.out.println("Please type the necessary info:\n");
		
		System.out.println("Name: ");       String name = lecStrings.nextLine();
		System.out.println("Blood type: "); String blood = lecStrings.nextLine();
		System.out.println("Weight: ");     double weight = lec.nextInt();
		System.out.println("Height: ");     double height = lec.nextInt();
		System.out.println("In environment: "); int inEnvi = lec.nextInt();
		System.out.println("Sex: ");        String sexString = lecStrings.nextLine(); char sex = sexString.charAt(0);
		System.out.println("Birth day: ");   int bdDay = lec.nextInt();
		System.out.println("Birth month: "); int bdMonth = lec.nextInt();
		System.out.println("Birth year: ");  int bdYear = lec.nextInt();
		
		sAustralia.addKang(name, blood, weight, height, inEnvi, sex, bdDay, bdMonth, bdYear);
	}
    
	
    

    
    public static void main(String args[]){
        Main main = new Main();
        main.Main();
        
        //main.insertDate();
		main.menu();
    }
}