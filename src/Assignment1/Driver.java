package Assignment1;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Welcome Banner
		System.out.println("\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
		System.out.println("\t*                                               *");
		System.out.println("\t*\t Welcome to the Appliance Store!\t*");
		System.out.println("\t*                                               *");
		System.out.println("\t*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
		
		// 1. Initialization:
		Scanner keyIn = new Scanner(System.in);
		Appliance[] inventory;
		int maxAppliances, choice, countPass = 0;
		String passEntered;
		boolean exit = false;
		final String PASSWORD = "c249";
		
		
		// 2. User-prompt:
		// Prompting the owner for the maxAppliances
		System.out.print("Please enter the maximum number of appliance in your store: ");
		maxAppliances = keyIn.nextInt();
		inventory = new Appliance[maxAppliances];
		
		do {
			// Prompting the user for choice of action
			System.out.println("What do you want to do?");
			System.out.println("\t1.\tEnter new appliances (password required)");
			System.out.println("\t2.\tChange information of an appliance (password required)");
			System.out.println("\t3.\tDisplay all appliances by a specific brand");
			System.out.println("\t4.\tDisplay all appliances under a certain price");
			System.out.println("\t5.\tQuit");
			System.out.print("Please enter your choice > ");

			// Checking if the choice is valid
			int[] choiceArray = {1, 2, 3, 4, 5};
			boolean rightChoice = false;
			do {
				choice = keyIn.nextInt();
				for(int i = 0; i < 5; i++) {
					if(choice == choiceArray[i]) {
						rightChoice = true;
					} else {
						rightChoice = false;
					}
				}
			}while (!rightChoice);

			// 3. Core logic:
			switch(choice):
				case 1:
					int countPassInner = 0; // To count the number of times the password has been entered wrong
					boolean pass = false; // To exit the do-while-loop if needed
					System.out.print("Please enter the password > ");
					do {
						passEntered = keyIn.next();
						if(passEntered.equals(PASSWORD)) {
							if(Appliance.findNumberOfCreatedAppliance() < maxAppliances) {
								Appliance newApp = new Appliance();
								System.out.print("Type of appliance > ");
								newApp.setType(keyIn.next());
								System.out.print("Brand of appliance > ");
								newApp.setBrand(keyIn.next());
								System.out.print("Serial Number > ");
								newApp.setSerialNum(keyIn.nextLong());
								System.out.print("Price > ");
								newApp.setPrice(keyIn.nextDouble());
								
								inventory[Appliance.findNumberOfCreatedAppliance()] = newApp;
							} else {
								System.out.println("Inventory is full!");
							}
							pass = true;
						} else {
							if(countPassInner < 3) {
								countPassInner += 1;
							} else if (countPass < 12) {
								countPass += countPassInner;
								pass = true;
							} else if(countPass == 12) {// When password was entered incorrectly 12 times, the program exit
								System.out.println("Program detected suspicious activities and will determinate immediately!");
								pass = true; // To exit this do-while loop
								exit = true; // To exit the entire program
							}
						}
					} while(!pass);
					break;
				case 2:
					// Reset the tracking variables
					countPassInner = 0;
					pass = false;
					
					System.out.print("Please enter the password > ");
					

		} while (!exit);
	}

}
