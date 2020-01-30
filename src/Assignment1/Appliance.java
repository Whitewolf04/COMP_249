package Assignment1;

/**
 * Represents an appliance in an appliance store
 * @author Tuan To
 * @version 1.0.0
 */
public class Appliance {
	private String type, brand;
	private long serialNum;
	private double price;
	public static int count = 0;
	
	/**
	 * Create an empty appliance
	 * Sets all attributes to default
	 */
	public Appliance() {
		this.type = null;
		this.brand = null;
		this.serialNum = 0;
		this.price = 0.0;
		count += 1;
	}
	
	/**
	 * Creates an appliance duplicating another appliance
	 * @param Another appliance
	 */
	public Appliance(Appliance otherAppliance) {
		otherAppliance.brand = this.brand;
		otherAppliance.type = this.type;
		otherAppliance.serialNum = this.serialNum;
		otherAppliance.price = this.price;
		count += 1;
	}
	
	/**
	 * Gets the type of the appliance
	 * @return Type of appliance as a string
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Gets the brand of the appliance
	 * @return Brand of appliance as a string
	 */
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * Gets the appliance's serial number
	 * @return A serial number which contains 7 digits
	 */
	public long getSerialNum() {
		return this.serialNum;
	}
	
	/**
	 * Gets the appliance's price
	 * @return Price of the appliance in decimals
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Sets the appliance's type
	 * @param A type of appliance in string
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Sets the appliance's brand
	 * @param A brand of appliance in string
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Sets the appliance's serial number
	 * @param A 7-digit number
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	
	/**
	 * Sets the appliance's price
	 * @param Any real number larger than 1
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Prints out the attributes of an appliance
	 * @return A string displaying all attributes of the appliance
	 */
	public String toString() {
		return("Appliance Serial # " + getSerialNum()
				+ "\nBrand: " + getBrand()
				+ "\nType: " + getType()
				+ "\nPrice: " + getPrice());
	}
	
	/**
	 * Finds the number of appliance created
	 * Static method to be called by the name of the class and be able to access all appliances' data
	 * @return The number of created appliance so far
	 */
	public static int findNumberOfCreatedAppliance() {
		return count;
	}
	
	/**
	 * Compare two appliances to each other
	 * @param Another appliance
	 * @return Whether they are the same or not
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null) {
			return false;
		} else if(getClass() != otherObject.getClass()) {
			return false;
		} else {
			Appliance otherAppliance = (Appliance) otherObject;
			return(type.equals(otherAppliance.type) && brand.equals(otherAppliance.brand) 
					&& serialNum == otherAppliance.serialNum && price == otherAppliance.price);
		}
	}
	
	/**
	 * Finds appliances by their brand
	 * Static method to access all appliances data
	 * @param A brand the user is looking for
	 * @param An array of appliances to look into
	 */
	public static void findApplianceByBrand(String brandLF, Appliance[] inventory) {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null) { // Check if there is an appliance in the current spot
				if(inventory[i].getBrand().equalsIgnoreCase(brandLF)) {
					System.out.println(inventory[i] + "\n");
					System.out.println("---------------------------------------\n");
				}
			}
		}
	}
	
	/**
	 * Finds appliances under a certain price
	 * @param The maximum price that the user wants
	 * @param An array of appliances to look into
	 */
	public static void findCheaperThan(double priceLF, Appliance[] inventory) {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i] != null) {
				if(inventory[i].getPrice() < priceLF) {
					System.out.println(inventory[i] + "\n");
					System.out.println("--------------------------------------\n");
				}
			}
		}
	}
	
}
