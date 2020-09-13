import java.util.ArrayList;

public class SalesSlip {
	
	//variable for Array List
	public ArrayList <SalesItem> salesArray;
	//Variable for Total Sale Cost
	public int salesTotal;
	
	//Construct List of Sales Items
	public ArrayList<SalesItem> buildSalesList(){
		salesArray = new ArrayList<SalesItem>();
		return salesArray;
	}
	
	//Method for adding sales item
	public void addSalesItem(SalesItem newItem)
	{
		salesArray.add(newItem);
	}
	
	//Compute + Return total sales
	public int computeTotal() {
		
		int l = salesArray.size();
		int total=0;
		for(int i=0; i<l;i++) {
			int itemCost = salesArray.get(i).getCost()*salesArray.get(i).getQuantity();
			total+=itemCost;
		}
		
		return total;
	}

	public ArrayList<SalesItem> getSalesArray() {
		return salesArray;
	}

	public void setSalesArray(ArrayList<SalesItem> salesArray) {
		this.salesArray = salesArray;
	}

	public int getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(int salesTotal) {
		this.salesTotal = salesTotal;
	}
	
	
	
	
	
	
	
	

}
