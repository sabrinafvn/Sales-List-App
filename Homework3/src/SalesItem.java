
public class SalesItem {
	
	String item;
	int cost;
	int quantity;
	
	public SalesItem(String itemName, int price, int amount) {
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
	public int getCost() {
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
