package com.bridgeit.objectOriented;

import java.io.FileNotFoundException;

import javax.json.JsonReader;

import com.bridgeit.utility.OopUtility;

public class InventoryDataMgt {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "/home/user/Fellowship/Fellowship/src/assets/InventoryData.json";
		JsonReader file = OopUtility.readJsonFile(path);
		ShopInventory[] inventory= OopUtility.getDataFromJson(file);
		for(ShopInventory item : inventory) {
			System.out.println(item.toString());
		}
//		System.out.println(inventory.toString());
	}

}
