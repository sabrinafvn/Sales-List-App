import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SalesApp {

	private JFrame frame;
	private JTextField itemField;
	private JTextField costField;
	private JTextField quantityField;
	private JTextField totalOutput;
	private JButton addItemButton;
	private JTextArea SalesListOutput;
	private JButton totalButton;
	private SalesSlip newSale;
	private ArrayList<SalesItem> salesList;

	/**
	 * Launch the application.
	 */
	/**
	 * @author Sabrina Nunn
	 * @version 1.0 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesApp window = new SalesApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesApp() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 6, 450, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setBounds(25, 28, 61, 16);
		frame.getContentPane().add(itemLabel);
		
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(25, 95, 61, 16);
		frame.getContentPane().add(quantityLabel);
		
		JLabel costLabel = new JLabel("Cost");
		costLabel.setBounds(25, 60, 61, 16);
		frame.getContentPane().add(costLabel);
		
		itemField = new JTextField();
		itemField.setBounds(109, 23, 266, 26);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		costField = new JTextField();
		costField.setBounds(109, 55, 130, 26);
		frame.getContentPane().add(costField);
		costField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(109, 90, 130, 26);
		frame.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		addItemButton = new JButton("Add Item to Sales List");
		addItemButton.setBounds(134, 117, 181, 29);
		frame.getContentPane().add(addItemButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 259, 396, -90);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 158, 396, 82);
		frame.getContentPane().add(scrollPane_1);
		
		SalesListOutput = new JTextArea();
		scrollPane_1.setViewportView(SalesListOutput);
		
		JLabel totalSaleLabel = new JLabel("Total Sales");
		totalSaleLabel.setBounds(158, 252, 96, 16);
		frame.getContentPane().add(totalSaleLabel);
		
		totalOutput = new JTextField();
		totalOutput.setBounds(248, 247, 181, 26);
		frame.getContentPane().add(totalOutput);
		totalOutput.setColumns(10);
		
		totalButton = new JButton("Compute Total");
		totalButton.setBounds(25, 247, 117, 29);
		frame.getContentPane().add(totalButton);
		
		newSale = new SalesSlip();
		salesList = newSale.buildSalesList();
	}
	
	private void createEvents() {
		addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
		}
				
			}
				
				);
		
		//button for Total Sales
		totalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deliverTotal();
		}
				
			}
				
				);
		
		
		
	}
	
	private void buildOutput() {
		//Every time Button is pressed, add item to list in SalesSlip
		
		//Instantiate Sales Slip object
		//newSale = new SalesSlip();
		
		//instantiate new arrayList from sales slip
	
		//Cost + Quantity Input to integer
		float cost = Float.parseFloat(costField.getText());
		int quantity = Integer.parseInt(quantityField.getText());
		
		//turn input into a sales Item
		SalesItem item = new SalesItem(itemField.getText(),cost,quantity);
		
		//Add Sales Item to List in Slip
		salesList.add(item);
	
		//Display newSale Items
		
		//Call Upon SalesSlip array
		
		StringBuilder b = new StringBuilder();
		for(SalesItem s : salesList){
			SalesListOutput.append(s + "\n");
			b.append(s.getItem() + "        " + "$"+ s.getCost() +"          " + s.getQuantity()+"\n");
			}
		SalesListOutput.setText(b.toString());
		
		
	}
	
	
	public void deliverTotal() {
		float total = newSale.computeTotal();
		//Convert Int to String
		String totalS = Float.toString(total);
		
		
		//Display Sales total to output field
		totalOutput.setText(totalS);
	}
}
