import java.util.Scanner;
/**
 * Driver and main of HW3_LinkedList
 *
 * @author UfukcanErdem
 * @version 1.0.0
 * @since  20.03.2022
 */


public class Main {
    /**  
     * @param args
     */
	  public static void main(String args[]){
		  /**
		   * In first part of main function, program running and testing with given inputs automaticly.
		   */
		  Street s1=new Street();	//Creating a Street object.
		  /*
		   * addBuilding method is testing
		   */
		  s1.setStreetLen(350);		//The street length is set to 99.
		  
		  s1.addBuilding(0,0,3,1,3);
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setColor("red");
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setRoom(3);
		  
		  s1.addBuilding(0,1,3,1,3);
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setColor("blue");
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setRoom(5);
		  
		  s1.addBuilding(0,0,9,3,3);
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setColor("pink");
		  ((House)s1.buildings.get(0).get(s1.HouseCount-1)).setRoom(7);
		  
		  s1.addBuilding(3,0,7,5,11); 	//INCORRECT INPUT, MUST FAIL AND SHOW ERROR MESSAGE!
		  						  		//THERE IS A PLAYGROUND TRY TO ADDED BETWEEN 7 TO 12 IN LEFT SIDE OF THE STREET.
		  								//WHILE THERE IS ALREADY A STRUCTURE
		  								//IT MUST NOT BE IN THE LIST
		  s1.addBuilding(1,1,29,3,3);
		  ((Office)s1.buildings.get(1).get(s1.OfficeCount-1)).setJobType("Bank");
		  
		  s1.addBuilding(3, 0, 211, 30, 3);
		  
		  s1.addBuilding(1,0,70,3,3);
		  ((Office)s1.buildings.get(1).get(s1.OfficeCount-1)).setJobType("Engineer");
		  
		  s1.addBuilding(2,0,39,3,3);
		  ((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setOpenTime("09.00");
		  ((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setCloseTime("21.00");
		  
		  s1.addBuilding(1,1,52,3,3);
		  ((Office)s1.buildings.get(1).get(s1.OfficeCount-1)).setJobType("Technology");
		  
		  s1.addBuilding(1,3,133,11,3);	//TRIES TO ADD A STRUCTURE TO SIDE 3 WHICH IS NOT VALID,MUST FAIL
		  
		  s1.addBuilding(2,1,188,9,5);
		  ((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setOpenTime("08.30");
		  ((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setCloseTime("20.00");
		  
		  s1.ListBuildings();	//PRINTS THE LIST OF STRUCTURES
		  System.out.println();
		  /*
		   * Delete method is testing
		   */
		  s1.DeleteBuilding(0, 2);	//DELETES SECOND HOUSE IN THE LIST
		  s1.ListBuildings();
		  System.out.println();
		  
		  s1.DeleteBuilding(1, 1);	//DELETES FIRST OFFICE IN THE LIST
		  s1.ListBuildings();
		  System.out.println();
		  
		  s1.DeleteBuilding(2, 2); 	//DELETES SECOND MARKET IN THE LIST
		  s1.ListBuildings();
		  
		  s1.DeleteBuilding(3, 1);	//DELETES FIRST PLAYGROUND IN THE LIST
		  s1.ListBuildings();
		  
		  s1.addBuilding(3, 1, 211, 22, 8);
		  s1.ListBuildings();
		  
		  /*
		   * TESTING FOCUS METHOD
		   */
		  s1.focus(1, 229);
		  s1.focus(0, 10);
		  
		  
		  //////////////MENU STARTS FROM HERE, PROGRAM WORKS WITH INPUTS AFTER THAT ////////////////////////
		  
		  int editorview=-1;
		  int editin=-1;
		  int viewin=-1;
		  String temp1=null;
		  int prm1=-1, prm2=-1, prm3=-1, prm4=-1, prm5=-1;
		  Scanner sc = new Scanner(System.in);
		  
		  while(true) {
			try {
				System.out.println("Press 1 for edit menu, press 2 for viewing menu!(LinkedList)");
				System.out.println("Press 99 for exit the program.");
				editorview=sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Input is incorrect!!! Please enter again!");
				sc.next();
			}
			
			switch(editorview) {
		  		case 1: 
		  			try {
		  				System.out.println("Press 1 for add a building,");
		  				System.out.println("Press 2 for delete a building, according to list");
		  				editin=sc.nextInt();
		  			}
		  			catch(Exception e) {
		  				System.out.println("Input is incorrect!!! Please enter again!");
		  				sc.next();
		  			}
		  				switch(editin) {
		  					case 1:	
		  						try {
		  							System.out.println("Enter the type of building you want to add.! (BuildingType=0 is House, BuildingType=1 is Office, BuildingType=2 is Market and BuildingType=3 is Playground).");
		  							prm1=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!! Please enter again!");
		  							sc.next();
		  						}
		  						try {
		  							System.out.println("Enter 0 for left side of street, enter 1 for right side of street!");
		  							prm2=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!! Please enter again!");
		  							sc.next();
		  						}
		  						try {
		  							System.out.println("Enter the Start Position of building in the street!");
		  							prm3=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!! Please enter again!");
		  							sc.next();
		  						}
		  						try {	
		  							System.out.println("Enter the length of building!");
		  							prm4=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!! Please enter again!");
		  							sc.next();
		  						}	
		  						try {
		  							System.out.println("Enter the height of building!");
		  							prm5=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!! Please enter again!");
		  							sc.next();
		  						}
		  						if(s1.isInputsCorrect(prm2, prm3, prm4) == true && s1.checkPosIsFilled(prm2, prm3, (prm3+prm4)) == false ) {
		  							s1.addBuilding(prm1, prm2, prm3, prm4, prm5);
		  							if(prm1 == 0) {
		  								System.out.println("Enter the owner name:");
		  								temp1=sc.nextLine();
		  								sc.nextLine();
		  							try {
		  								((House)s1.buildings.get(0).get(s1.HouseCount-1)).setOwnerName(temp1); //Using typecast for edit ownername of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no house!!!");
		  							}
		  								System.out.println("Enter the color:");
		  								temp1=sc.nextLine();
		  								((House)s1.buildings.get(0).get(s1.HouseCount-1)).setColor(temp1); //Using typecast for edit color of subclass
		  							}
		  							else if(prm1==1) {
		  								System.out.println("Enter the owner name:");
		  								temp1=sc.nextLine();
		  								sc.nextLine();
		  							try {
		  								((Office)s1.buildings.get(1).get(s1.OfficeCount-1)).setOwnerName(temp1); //Using typecast for edit ownername of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no office!!!");
		  							}
		  								System.out.println("Enter the Job-Type:");
		  								temp1=sc.nextLine();
		  							try {
		  								((Office)s1.buildings.get(1).get(s1.OfficeCount-1)).setJobType(temp1); //Using typecast for edit jobtype of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no office!!!");
		  							}
		  							
		  							}
		  							else if(prm1==2) {
		  								System.out.println("Enter the owner name:");
		  								temp1=sc.nextLine();
		  								sc.nextLine();
		  							try {
		  								((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setOwnerName(temp1); //Using typecast for edit ownername of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no market!!!");
		  							}
		  								System.out.println("Enter the open time");
		  								temp1=sc.nextLine();
		  							try {
		  								((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setOpenTime(temp1); //Using typecast for edit opentime of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no market!!!");
		  							}
		  								System.out.println("Enter the close time");
		  								temp1=sc.nextLine();
		  							try {	
		  								((Market)s1.buildings.get(2).get(s1.MarketCount-1)).setCloseTime(temp1); //Using typecast for edit closetime of subclass
		  							}
		  							catch(ArrayIndexOutOfBoundsException e){
		  								System.out.println("There is no market!!!");
		  							}
		  							}
		  							s1.ListBuildings();
		  						}
		  						else {
		  							System.out.println("INCORRECT INPUTS! ERROR!!!");
		  						}
		  						
		  							
		  							break;
		  				
		  					case 2: s1.ListBuildings();
		  							int prmbt=-1;
		  							int prmln=-1;
		  						try {
		  							System.out.println("Enter Building Type! (BuildingType=0 is House, BuildingType=1 is Office, BuildingType=2 is Market and BuildingType=3 is Playground).");
		  							prmbt=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!!");
		  							sc.next();
		  						}
		  						
		  						try {
		  							System.out.println("Enter list number of building!");
		  							prmln=sc.nextInt();
		  						}
		  						catch(Exception e) {
		  							System.out.println("Input is incorrect!!!");
		  							sc.next();
		  						}
		  						try {
		  							s1.DeleteBuilding(prmbt, prmln);
		  						}
		  						catch(ArrayIndexOutOfBoundsException e){
	  								System.out.println("There is no structure!!!");
	  							}
		  							break;
		  					default:System.out.println("Undefinied case!");
		  							break;
		  				}
		  				break;
		  		
		  		case 2: 
		  			try {
		  				System.out.println("Press 1 for display the total remaining length of lands on the street.");
		  				System.out.println("Press 2 for display the list of buildings on the street.");
		  				System.out.println("Press 3 for o display the number and ratio of lenth of playgrounds in the street.");
		  				System.out.println("Press 4 for calculate the total length of street occupied by the markets, houses or offices.");
		  				System.out.println("Press 5 for display the skyline silhouette of the street.");
		  				viewin=sc.nextInt();
		  			}
		  			catch(Exception e) {
		  				System.out.println("Input is incorrect!!!");
		  				sc.next();
		  			}
		  				s1.viewAnswers(viewin);
		  				break;
		  				
		  		case 99:System.exit(0);
		  				break;
		  		default:System.out.println("Undefinied case!");
		  				break;
		  	}
		  }
	  }
	 
}
