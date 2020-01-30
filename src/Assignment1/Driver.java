package Assignment1;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
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
		final String PASSWORD = "c249"; // Set password as unchangeable
		
		
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
			choice = keyIn.nextInt();
			System.out.println();

			// 3. Core logic:
			switch(choice) {
				case 1:
					int countPassInner = 0; // To count the number of times the password has been entered wrong inside choice 1
					boolean pass = false; // To exit the do-while-loop if needed
					do {
						System.out.print("Please enter the password > ");
						passEntered = keyIn.next();
						if(passEntered.equals(PASSWORD)) {// Check if password is correct
							// If password entered correctly, reset all attempts
							countPassInner = 0;
							countPass = 0;
							
							// Check if inventory is full
							if(Appliance.findNumberOfCreatedAppliance() < maxAppliances) {
								// Create a new appliance
								Appliance newApp = new Appliance();
								System.out.print("Type of appliance > ");
								String typeEntered = keyIn.next();
								newApp.setType(typeEntered);
								System.out.print("Brand of appliance > ");
								String brandEntered = keyIn.next();
								newApp.setBrand(brandEntered);
								System.out.print("Serial Number > ");
								long serialEntered = keyIn.nextLong();
								newApp.setSerialNum(serialEntered);
								System.out.print("Price > ");
								double priceEntered = keyIn.nextDouble();
								newApp.setPrice(priceEntered);
								System.out.println();
								
								boolean exist = false;	// To check if the appliance already exist
								for(int i = 0; i < inventory.length; i++) {
									if(inventory[i] != null && inventory[i].equals(newApp)) {
										exist = true;
									}
								}
								
								// If the appliance hasn't existed, add it to inventory
								if(exist == false) {
									inventory[Appliance.findNumberOfCreatedAppliance()-1] = newApp;
								} else {
									System.out.println("Appliance already exist!");
								}
							} else {
								System.out.println("Inventory is full!\n");
							}
							pass = true;	// Exit this do-while loop for choice 1
						} else {
							if(countPassInner < 2) {
								System.out.println("Password incorrect! Please try again!\n");
								countPassInner += 1;
								continue;
							} else if (countPass < 9) {
								System.out.println("Password was entered incorrectly 3 times!!!\n");
								countPassInner += 1;
								countPass += countPassInner;
								pass = true; // Exit this do-while loop to go back to the main menu
							} else if(countPass == 9) {// The count set to 9 for the last 3 attempts are the final attempts
								// When password was entered incorrectly 12 times, the program exit
								System.out.println("Program detected suspicious activities and will determinate immediately!");
								pass = true; // To exit this do-while loop
								exit = true; // To exit the entire program
							}
						}
					} while(!pass);
					break;	// Prevent the program from going into 2nd choice
				case 2:
					// Reset the tracking variables
					countPassInner = 0;
					pass = false;
					
					do {
						System.out.print("Please enter the password > ");
						long seriEntered;
						int index = -1;		// Index for the specific item chosen to be changed
						boolean passOpt2 = false;	// Modifier for inner do-while loop of choice 2
						passEntered = keyIn.next();
						if(passEntered.equals(PASSWORD)) {
							countPassInner = 0;
							countPass = 0;
							System.out.print("Please enter the serial number > ");
							seriEntered = keyIn.nextLong();
							for(int i = 0; i < inventory.length; i++) {
								if(seriEntered == inventory[i].getSerialNum()) {
									index = i;	// Mark the index for future changes
									System.out.println(inventory[i] + "\n");
								}
							}
							
							// Check if the serial number exist inside inventory
							if(index == -1) {
								System.out.println("The serial number entered is incorrect!");
								System.out.println("Do you wish to: ");
								System.out.println("\t1.\tTry again");
								System.out.println("\t2.\tGo back to the main menu");
								System.out.println("\t(Enter number to go back to the main menu)");
								System.out.print("Please enter your choice > ");
								
								int choiceEntered = keyIn.nextInt();
								switch(choiceEntered) {
								case 1:
									System.out.println();
									continue;
								default:
									System.out.println();
								}
								break;
							}
							
							do {
								// Prompt the user which information to change
								System.out.println("What information would you like to change?");
								System.out.println("\t1.\tbrand");
								System.out.println("\t2.\ttype");
								System.out.println("\t3.\tprice");
								System.out.println("\t4.\tQuit");
								System.out.print("Please enter your choice > ");
								int changeChoice = keyIn.nextInt();

								switch(changeChoice) {
								case 1:
									// Ask for input of new brand and print out appliance after modify
									System.out.print("Please enter the new brand > ");
									String brandEntered = keyIn.next();
									inventory[index].setBrand(brandEntered);
									System.out.println("\n" + inventory[index]);
									break;
								case 2:
									// Ask for the input of new type and print out appliance after modify
									System.out.print("Please enter the new type > ");
									String typeEntered = keyIn.next();
									inventory[index].setType(typeEntered);
									System.out.println("\n" + inventory[index]);
									break;
								case 3:
									// Ask for the input of new price and print out appliance after modify
									System.out.print("Please enter the new Price > ");
									double priceEntered = keyIn.nextDouble();
									inventory[index].setPrice(priceEntered);
									System.out.println("\n" + inventory[index]);
									break;
								case 4:
									// Only quit the loop when option 4 is chosen
									passOpt2 = true;
									System.out.println();
									break;
								default:
									System.out.println("Choice invalid! Please try again!\n");
								}
							} while(!passOpt2);
							pass = true;
						} else {
							if(countPassInner < 2) {
								System.out.println("Password incorrect! Please try again!\n");
								countPassInner += 1;
								continue;
							} else if (countPass < 9) {
								System.out.println("Password was entered incorrectly 3 times!!!\n");
								countPassInner += 1;
								countPass += countPassInner;
								pass = true;
							} else if(countPass == 9) {
								// When password was entered incorrectly 12 times, the program exit
								System.out.println("Program detected suspicious activities and will determinate immediately!");
								pass = true; // To exit this do-while loop
								exit = true; // To exit the entire program
							}
						}
					} while(!pass);
					break;
				case 3:
					// Ask for the brand looking for and print out all appliances of that brand
					pass = false;
					do {
						System.out.print("Please enter the brand you are looking for > ");
						String brandEntered = keyIn.next();
						Appliance.findApplianceByBrand(brandEntered, inventory);
						
						System.out.println("Search done! What do you want to do?");
						System.out.println("\t1.\tSearch again");
						System.out.println("\t2.\tGo back to the main menu");
						System.out.println("\t(Enter any number (except 1) to return to the main menu)");
						System.out.print("Please enter your choice > ");
						
						int choiceEntered = keyIn.nextInt();
						System.out.println();
						switch(choiceEntered) {
						case 1:
							break;
						default:
							pass = true;
							break;
						}
					} while(!pass);
					break;
				case 4:
					pass = false;
					do {
						System.out.print("Please enter the maximum price > ");
						double priceEntered = keyIn.nextDouble();
						Appliance.findCheaperThan(priceEntered, inventory);
						
						System.out.println("Search done! What do you want to do?");
						System.out.println("\t1.\tSearch again");
						System.out.println("\t2.\tGo back to the main menu");
						System.out.println("\t(Enter any number (except 1) to return to the main menu)");
						System.out.print("Please enter your choice > ");
						
						int choiceEntered = keyIn.nextInt();
						System.out.println();
						switch(choiceEntered) {
						case 1:
							break;
						default:
							pass = true;
							break;
						}
					} while(!pass);
					break;
				case 5:
					exit = true;
					System.out.println("\n\t\tThank you for coming to our store!!!");
					break;
				default:
					System.out.println("Choice invalid! Please try again!\n");
			}
		} while (!exit);
		
		// 4. Clean-up:
		keyIn.close();	// To make Java happy!
	}

}
