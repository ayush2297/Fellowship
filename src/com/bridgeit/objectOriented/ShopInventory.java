package com.bridgeit.objectOriented;

public class ShopInventory {

	String itemName;
	double itemWeight;
	double costPerKg;
	
	public String getItem() {
		return itemName;
	}
	
	public void setItem(String itemName) {
		this.itemName = itemName;
	}
	
	public double getWeight() {
		return itemWeight;
	}
	
	public void setWeight(double itemWeight) {
		this.itemWeight = itemWeight;
	}
	
	public double getCostPerKg() {
		return costPerKg;
	}
	
	public void setCostPerKg(double CostPerKg) {
		this.costPerKg = CostPerKg;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**************Inventory************\n");
		sb.append("Name : "+itemName+"\n");
		sb.append("Item weight : "+itemWeight+"\n");
		sb.append("Cost per Kg  : "+costPerKg+"\n");
		return sb.toString();
	}
}
