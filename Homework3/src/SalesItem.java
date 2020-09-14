
public class SalesItem {
	
	String item;
	float cost;
	int quantity;
	
	
	
	
	public SalesItem(String itemName, float price, int amount) {
		// TODO Auto-generated constructor stub
		item = itemName;
		cost=price;
		quantity = amount;
	}


	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
