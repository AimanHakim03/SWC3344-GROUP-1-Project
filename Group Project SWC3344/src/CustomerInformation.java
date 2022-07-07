**
 * SWC3444 Group Project
 * @author NUR DANEENA ROYDEAN 
           AIMAN HAKIM REDZA
 * Class Customer Information
 *
 */

//Customer Information Class
public class CustomerInformation {
	
	//Declaration of attributes for CustomerInformation Class
	String custId;
	String custIc;
	int counterPaid;
	private ItemInformation item; //Customer has-a item
	
	
	//Getter and setter for ItemInformation class
	public ItemInformation getItem() {
		return item;
	}

	public void setItem(ItemInformation item) {
		this.item = item;
	}

	//Without parameter constructor
	public CustomerInformation()
	{
		custId = null;
		custIc = null;
		counterPaid = 0;
	}//end of no-args constructor
	
	//With parameter constructor
	public CustomerInformation(String Cid, String Cic, int counter)
	{
		custId = Cid;
		custIc = Cic;
		counterPaid = counter;
		
		
	}//end of normal constructor
	
	
	//Setter Method
	public void setCustId(String Cid)
	{
		custId = Cid;
	}
	
	public void setCustIc(String Cic)
	{
		custIc = Cic;
	}
	
	public void setCounterPaid(int counter)
	{
		counterPaid = counter;
	}
	
	//Getter method
	public String getCustId()
	{
		return custId;
	}
	
	public String getCustIc()
	{
		return custIc;
	}
	
	public int getCounterPaid()
	{
		return counterPaid;
	}
	
	//toString
	public String toString()
	{
		return ("Customer Id: " + custId + "Customer Ic: " + custIc + "Counter Paid: " + counterPaid);
	}//end of toString
	
	
}// end of Customer Information class

