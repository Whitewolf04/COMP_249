package Assignment1;

public class Appliance {
	private String type, brand;
	private long serialNum;
	private double price;
	public static int count = 0;
	
	/**
	 * Default constructor
	 */
	public Appliance() {
		this.type = null;
		this.brand = null;
		this.serialNum = 0;
		this.price = 0.0;
		count += 1;
	}
	
	public Appliance(Appliance otherAppliance) {
		otherAppliance.brand = this.brand;
		otherAppliance.type = this.type;
		otherAppliance.serialNum = this.serialNum;
		otherAppliance.price = this.price;
		count += 1;
	}
	
	/**
	 * Accessor and Mutator Methods
	 */
	public String getType() {
		return this.type;
	}
	public String getBrand() {
		return this.brand;
	}
	public long getSerialNum() {
		return this.getSerialNum();
	}
	public double getPrice() {
		return this.price;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * toString method to be printed
	 */
	public String toString() {
		return("This product is a " + getType() + " from " + getBrand() + " with serial number " 
				+ getSerialNum() + " has a price of " + getPrice());
	}
	
	/**
	 * Finding the number of created appliance
	 * The method uses a static variable to count all subclasses activities
	 * @return the number of created appliance so far
	 */
	public static int findNumberOfCreatedAppliance() {
		return count;
	}
	
	/**
	 * Equals method to compare to appliance object
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
	
	
	
}
