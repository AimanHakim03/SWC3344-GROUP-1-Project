/**
GUI Program Application for Lotus Hypermarket
 **/
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class LotusCheckout extends JFrame {
    
	
	private JPanel contentPane;
	private JTextField textFieldCounterNo;
	private JTextField textFieldCustId;
	private JTextArea textArea;
	private JTable table_2;
    
	
	static ArrayList<ItemInformation> purchasedItemsList;
	static LinkedList<CustomerInformation>customerList;
	Queue<CustomerInformation>counter1 = new LinkedList<CustomerInformation>();
	Queue<CustomerInformation>counter2 = new LinkedList<CustomerInformation>();
	Queue<CustomerInformation>counter3 = new LinkedList<CustomerInformation>();
	
	DefaultTableModel dtm;
	int row,col;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LotusCheckout frame2 = new LotusCheckout();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void addToList() throws IOException
	{	//Read CustomerInformation.txt to store into purchasedItemsList and CustomerList
	File file = new File("C:\\Users\\Roy\\eclipse-workspace\\GUI\\CustomerInformation.txt");
	try (Scanner readFile = new Scanner(file)) {
		StringTokenizer token = null;
		 
		//Initialize the variables that is needed to instantiate the object
		String custId = "";
		String custIc = "";
		int counterPaid = 0;
		String itemId = "";
		String itemName = "";
		double itemPrice = 0.00;
		String datePurchase = "";
		int itemQuantity = 0; 
		
		while(readFile.hasNextLine()) {
			 token  = new StringTokenizer(readFile.nextLine(), ";");
		     
			 //use the information from one line to initialize the variables needed to instantiate the object
				custId = token.nextToken();
				custIc = token.nextToken();
				counterPaid = Integer.parseInt(token.nextToken());
				itemId = token.nextToken();
				itemName = token.nextToken();
				itemPrice = Double.parseDouble(token.nextToken());
				datePurchase = token.nextToken();
				itemQuantity = Integer.parseInt(token.nextToken()); 
			 
			//store into purchasedItemsList and customerList
			 CustomerInformation customer = new CustomerInformation(custId,custIc,counterPaid);
			 customerList.add(customer);
			 ItemInformation item = new ItemInformation(customer,itemId,itemName,itemPrice,datePurchase,itemQuantity);
			 purchasedItemsList.add(item);
			
			 
			 
		}
	} catch (NumberFormatException e) {

		e.printStackTrace();
	}
}
	//Queue
	private Queue<CustomerInformation>defaultCounter = counter1;
	public  Queue<CustomerInformation>lineUp()
	{
		if(defaultCounter.equals(counter1))
		{
			defaultCounter = counter2;
		}
		else if(defaultCounter.equals(counter2))
		{
			defaultCounter = counter3;
		}
		else if(defaultCounter.equals(counter3))
		{
			return defaultCounter;
		}
		
		return defaultCounter;
	}
	
	//Return counter numbers
	public int counterNumber(Queue<CustomerInformation> counter) {
        if (counter.equals(counter1)) 
        {
        	return 1;
        }
        else if (counter.equals(counter2))
        {
        	return 2;
        }
        else if (counter.equals(counter3))
        {
        	return 3;
        }
        return 0;
    }
    
	//Add counter to CustomerInformation customer
    public void addToCounter1(CustomerInformation customer) 
    {
        customer.setCounterPaid(counterNumber(counter1));
        counter1.add(customer);
    }

    public void addToCounter2(CustomerInformation customer)
    {
    	customer.setCounterPaid(counterNumber(counter2));
        counter2.add(customer);
    }
    
    public void addToCounter3(CustomerInformation customer) 
    {
    	customer.setCounterPaid(counterNumber(counter3));
        counter3.add(customer);
    }
   
    //dequeue all customer
    public static void flush(Queue<CustomerInformation> remove) {
        CustomerInformation customer = remove.poll();
         customer = remove.poll();
        }
    }
	
	/**
	 * Create the frame.
	 * 
	 */
	public LotusCheckout() {
		
	    //JFrame Title
		setTitle("Lotus Checkout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1316, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(854, 11, 402, 546);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 384, 524);
		panel_1.add(textArea);
		
		JLabel lblItemList = new JLabel("Item Checkout");
		lblItemList.setForeground(new Color(0, 0, 128));
		lblItemList.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblItemList.setBounds(342, 123, 172, 27);
		contentPane.add(lblItemList);
		
		textFieldCounterNo = new JTextField();
		textFieldCounterNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCounterNo.setFont(new Font("Lucida Console", Font.BOLD, 20));
		textFieldCounterNo.setColumns(10);
		textFieldCounterNo.setBounds(618, 568, 122, 27);
		contentPane.add(textFieldCounterNo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Roy\\OneDrive\\Pictures\\lotuss-logo-vector-01-1024x484.png"));
		lblNewLabel.setBounds(143, 11, 706, 88);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		panel.setBounds(10, 161, 834, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 814, 359);
		panel.add(scrollPane);
		
		//JTable add Mouse Listener for user to click selected row
		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int i = table_2.getSelectedRow();
			    String custId = dtm.getValueAt(i,0).toString();
			    String custIc = dtm.getValueAt(i,1).toString();
			    String counterPaid = dtm.getValueAt(i,2).toString();
			    String itemId = dtm.getValueAt(i,3).toString();
			    String itemName = dtm.getValueAt(i,4).toString();
			    String itemPrice = dtm.getValueAt(i,5).toString();
			    String datePurchase = dtm.getValueAt(i,6).toString();
			    String itemQuantity = dtm.getValueAt(i,7).toString();
			    
			    textFieldCustId.setText(custId);
			}
		});
		
		//Create table
		dtm = new DefaultTableModel();
		Object[] column = {"Customer ID","Customer IC","Counter","Item ID", "Item Name" , "Item Price" , "Purchase Date" , "Item Quantity"};
		dtm.setColumnIdentifiers(column);
		table_2.setModel(dtm);
		
		scrollPane.setViewportView(table_2);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(185);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(102);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(103);
		table_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		
		//Button to add purchasedItemsList to JTable
		JButton btnAddToQueue_1 = new JButton("Add to Queue");
		btnAddToQueue_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			try {
				String filePath = "C:\\Users\\Roy\\eclipse-workspace\\GUI\\CustomerInformation.txt";
				File file = new File(filePath);
				BufferedReader br = new BufferedReader(new FileReader(file));
				
			    Object[] purchasedItemsList = br.lines().toArray();
			    for(int i = 0; i<purchasedItemsList.length;i++)
			    {
			    	String line = purchasedItemsList[i].toString().trim();
			    	String[] dataRow = line.split(";");
			    	dtm.addRow(dataRow);
			    }
				
			} catch(Exception e1)
			{
				System.out.println("Error in retrieving file!");
			}
				
			} 
		});

		btnAddToQueue_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddToQueue_1.setBounds(10, 568, 145, 27);
		contentPane.add(btnAddToQueue_1);
		
		//Receipt button when customer paid
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
			        int i = table_2.getSelectedRow();
				    String custId = dtm.getValueAt(i,0).toString();
				    String custIc = dtm.getValueAt(i,1).toString();
				    String counterPaid = textFieldCounterNo.getText();
				    String itemId = dtm.getValueAt(i,3).toString();
				    String itemName = dtm.getValueAt(i,4).toString();
				    String itemPrice = dtm.getValueAt(i,5).toString();
				    String datePurchase = dtm.getValueAt(i,6).toString();
				    String itemQuantity = dtm.getValueAt(i,7).toString();
				      	
               //Set data to textArea 
				if(table_2.
                getSelectedRowCount()==1)
			    {textArea.setText(textArea.getText()+ "\t\tLotus Hypermarket" + 
						"\nCustomer ID: " + custId + "\t\tCustomer IC: " + custIc +
						"\nCounter Paid: " + counterPaid + "\t\tDate: " + datePurchase +
						"\n\n============================================================================" +
						"\nItem ID: " + itemId + 
						"\n\nItem Name: " + itemName + 
						"\n\nTotal Items: " + itemQuantity);
				textArea.setText(textArea.getText()+"\n===========================================================================" + 
						"\n\t\t\t              Total: RM" + itemPrice +
						"\n===========================================================================" +
						"\n\n\t          Thank you for shopping with us!" + 
						"\n============================================================================\n");
					
					
			}
			else
				JOptionPane.showMessageDialog(null, "Error!");
			}	
		});
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setBounds(966, 568, 165, 27);
		contentPane.add(btnReceipt);
		
		textFieldCustId = new JTextField();
		textFieldCustId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCustId.setFont(new Font("Lucida Console", Font.BOLD, 20));
		textFieldCustId.setColumns(10);
		textFieldCustId.setBounds(348, 567, 122, 27);
		contentPane.add(textFieldCustId);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setForeground(new Color(0, 0, 128));
		lblCustomerId.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblCustomerId.setBounds(194, 568, 152, 27);
		contentPane.add(lblCustomerId);
		
		//Pay button asks for confirmation from customer to proceed
		JButton btnAddToQueue_1_1 = new JButton("Pay");
		btnAddToQueue_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JOptionPane.showConfirmDialog(null, "Proceed to checkout?");
				 int i = table_2.getSelectedRow();
			
				    int itemQuantity = Integer.parseInt(dtm.getValueAt(i,7).toString());
				    
				    if(table_2.getSelectedRowCount()==1)
					{
				    	 if(itemQuantity >5)
						    {   
						    	
						    	textFieldCounterNo.setText("3");
						    }
						    else if(itemQuantity <=5)
						    {	
						    	textFieldCounterNo.setText("2");
						    }
						    else if(itemQuantity <=3)
						    {
						    	textFieldCounterNo.setText("1");
						    }
						
						JOptionPane.showMessageDialog(null, "Complete!");
					}
					else if(table_2.getSelectedRowCount()==0)
					{
						JOptionPane.showMessageDialog(null, "Invalid!");
					}
				    
		}});
		btnAddToQueue_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddToQueue_1_1.setBounds(854, 568, 102, 27);
		contentPane.add(btnAddToQueue_1_1);
		
		JLabel lblCounter = new JLabel("Counter");
		lblCounter.setForeground(new Color(0, 0, 128));
		lblCounter.setFont(new Font("Lucida Console", Font.BOLD, 20));
		lblCounter.setBounds(507, 568, 111, 27);
		contentPane.add(lblCounter);
		
		JButton btnAddToQueue_1_1_1 = new JButton("Next");
		btnAddToQueue_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete queue
				if(table_2.getSelectedRowCount()==1)
				{
					dtm.removeRow(table_2.getSelectedRow());
					textFieldCounterNo.setText("");
					textFieldCustId.setText("");
					textArea.setText("");
					
					JOptionPane.showMessageDialog(null, "Thank you! Have a nice day!");
				}
				else
					JOptionPane.showMessageDialog(null, "Pay first to checkout!");
				
				
				
			}
		});
		btnAddToQueue_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddToQueue_1_1_1.setBounds(1141, 568, 115, 27);
		contentPane.add(btnAddToQueue_1_1_1);
		
		
		
		
		
	}
}//end of Lotus Checkout
