package exercise17_12;

/*
 * Use the sample data shown in Fig. 17.25 .
Class Invoice includes four instance variables—a partNumber (type
String), a part-Description (type String), a quantity of the
item being purchased (type int) and a pricePerItem (type double)
and corresponding get methods
 */
public class Invoice {
	
	private int partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	
	public Invoice(int partNumber, String partDescription, int quantity, double pricePerItem) {
		super();
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	
	
	
	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public String toString() {
		return String.format("%-5d%-20s%-5d%-5.2f", 
				getPartNumber(), getPartDescription(), getQuantity(), getPricePerItem());
		
	}
	
	
	
}
