/**
 * SWC3444 Group Project
 * Class Item Information
 *
 */



public class ItemInformation {
	
	String itemId;
    String itemName;
    double itemPrice;
    String datePurchase;
    int itemQuantity;
	
	public ItemInformation(CustomerInformation customer, String itemId, String itemName, double itemPrice, String datePurchase, int itemQuantity)
	{
		itemId = null;
		itemName = null;
		itemPrice = 0.00;
		itemQuantity = 0;
		datePurchase = null;
		
		
	}//end of no-args constructor
	
	public ItemInformation(String Iid, String Iname, double Iprice, int Iquantity, String date )
	{   
		itemId = Iid;
		itemName = Iname;
		itemPrice = Iprice;
		itemQuantity = Iquantity;
		datePurchase = date;
		
		
	}//end of normal constructor
	
	
	//Setter method
	public void setItemId(String Iid)
	{
		itemId = Iid;
	}
	
	public void setItemName(String Iname)
	{
		itemName = Iname;
	}
	
	public void setItemPrice(double Iprice)
	{
		itemPrice = Iprice;
	}
	
	
	public void setItemQuantity(int Iquantity)
	{
		itemQuantity = Iquantity;
	}
	
	public void setDatePurchase(String date)
	{
		datePurchase = date;
	}
	
	//Getter method
	
	public String getItemId()
	{
		return itemId;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public Double getItemPrice()
	{
		return itemPrice;
	}
	
	
	public int getItemQuantity()
	{
		return itemQuantity;
	}
	
	public String getDatePurchase()
	{
		return datePurchase;
	}
	
	//toString
	public String toString()
	{
		return ("Item Id: " + itemId + "Item Name: " + itemName + "Item Price: " + itemPrice + "Item Quantity: " + itemQuantity + "Purchase Date:" + datePurchase );
	}//end of toString
	
	
	
	
}//end of Item Information Class


