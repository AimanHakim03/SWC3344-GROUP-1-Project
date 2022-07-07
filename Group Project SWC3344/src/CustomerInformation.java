
public class CustomerInformation {

	String custId;
	String custIc;
	int counterPaid;
	private ItemInformation item; //Customer has-a item
	
	public CustomerInformation()
	{
		custId = null;
		custIc = null;
		counterPaid = 0; }
	
	public CustomerInformation(String custId, String custIc, int counterPaid) {
		this.custId = custId;
		this.custIc = custIc;
		this.counterPaid = counterPaid;
		
	}

	
	public ItemInformation getItem() {
		return item;
	}

	public void setItem(ItemInformation item) {
		this.item = item;
	}
	
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

