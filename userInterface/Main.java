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
        // Ask the user the current date //
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
        // Show all info available //
        System.out.println("\n\n");
        System.out.println(sAustralia.SeccionAusUI());
    }
    public void seeZone1(){
        // Show only Zone1 information //
        System.out.println(sAustralia.Zone1UI());
    }
    public void seeZone2(){
        // Show only Zone2 information //
        System.out.println(sAustralia.Zone2UI());
    }
    
    public void addKang(){
        // Ask the user about the new kangaroo //
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
	
        // Calls addKang() in SeccionAus with the previus info //
	sAustralia.addKang(name, blood, weight, height, inEnvi, sex, bdDay, bdMonth, bdYear);
	}
    public void deleteKang(){
        // Ask the user the name of the kangaro that wants to delete //
        System.out.println("\nWhat's the name of the kangaroo that you want to delete?");
        String kangName = lecStrings.nextLine();
        
        // Calls deleteKang() in SeccionAus with the previus info //
        sAustralia.deleteKang(kangName);
    }
    public void moveKang(){
        // Ask the user the name of the kangaro that wants to move and to wich environment //
        System.out.println("\nWhat's the name of the kangaroo that you want to move?");
        String kangName = lecStrings.nextLine();
        System.out.println("\nMove " + kangName + " to wich Environment?");
        int toEnvi = lec.nextInt();
        
        // Calls deleteKang() in SeccionAus with the previus info //
        sAustralia.moveKang(kangName, toEnvi);
    }
    public void searchByVowel(){
        // Shows a list of all animal that its name begins and ends with a vowel //
        System.out.println("\nAnimals that their name begins and ends with vowels: \n");
        System.out.println(sAustralia.searchByVowel());
    }
    public void neededVaccines(){
        // Shows a list of all kangaroos and if they need vaccines //
        System.out.println("\nNeeded Vaccines:");
        System.out.println(sAustralia.neededVaccines());
    }
    
    public void menu(){
        // Shows a menu with all the functions //
	System.out.println("\nWhat do you want to do?");
	System.out.println("1) See all areas                     2) See zone 1                     3) See zone 2");
	System.out.println("4) Add kangaroo                      5) Delete kangaroo                6) Move kangaroo");
        System.out.println("7) Animals per vowels                8) List of needed vaccines        9) Exit");
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
                 
                case 6: moveKang();
		break;
                
                case 7: searchByVowel();
		break;
                
                case 8: neededVaccines();
		break;
                
                case 9: System.out.println("GoodBye!");
		break;
			
		default: System.out.println("Sorry but option '" + select + "' doesn't exist.");
		}
	}
	
    public static void main(String args[]){
        Main main = new Main();
        main.Main();
        
        main.insertDate();
        do{main.menu();} while(main.select != 9); // When a process is finished the menu shows itself again, unless the user select the option 9 "exit" //
    }
}