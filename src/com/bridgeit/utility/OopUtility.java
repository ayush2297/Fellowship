package com.bridgeit.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

import com.bridgeit.objectOriented.InventoryDataMgt;
import com.bridgeit.objectOriented.ShopInventory;

public class OopUtility {

	public static JsonReader readJsonFile(String path) 
			throws FileNotFoundException{
		InputStream fis = new FileInputStream(path);		
		JsonReader fileReader = Json.createReader(fis);
		return fileReader;
	}

	public static ShopInventory[] getDataFromJson(JsonReader file) {
		JsonObject fileBaseObj = file.readObject();
		file.close();
		
		JsonArray shopArray = fileBaseObj.getJsonArray("shop");
		
		ShopInventory[] tempObjArr = new ShopInventory[shopArray.size()]; 
		int index4Obj = 0;
		
		for(JsonValue item : shopArray) {
//			System.out.println(((JsonObject) item).getString("name"));
			String name = ((JsonObject) item).getString("name").toString();
			double weight = (Double.parseDouble((((JsonObject) item).getString("weight"))));
			double cost = (Double.parseDouble((((JsonObject) item).getString("pricekg"))));
//			System.out.println(((JsonObject) item).getString("weight"));
			ShopInventory tempObj = new ShopInventory();
			tempObj.setItem(name);
			tempObj.setWeight(weight);
			tempObj.setCostPerKg(cost);
			
			tempObjArr[index4Obj++] = tempObj;
		}
		
//		ShopInventory tempObjArr = new ShopInventory();
//		tempObjArr.setItem(fileBaseObj.getString("name"));
//		tempObjArr.setWeight(Double.parseDouble((fileBaseObj.getString("weight"))));
//		tempObjArr.setCostPerKg((Double.parseDouble(fileBaseObj.getString("pricekg"))));
		return tempObjArr;
	}

	public static void useRegex(String ipString) {
		Pattern pattObj1 = Pattern.compile("<<name>>");
		Pattern pattObj2 = Pattern.compile("<<full name>>");
		Pattern pattObj3 = Pattern.compile("x{10}");
		Pattern pattObj4 = Pattern.compile("(0[1-9]|1[0-9]|2[0-9]|[30|31])"
				+ "[\\/](0[1-9]|[10|11|12])"
				+ "[\\/]([0-9]{4})");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String currDate = dtf.format(localDate);

		String name = "Ayush";
		String fullName = name+ " Chandresh Saraf";
		String contact = "8793432373";
		
		String ipString1 =ipString;
		
		Matcher matchObj1 = pattObj1.matcher(ipString1);
		
		if(matchObj1.find()) {
			System.out.println("match 1 found");
//			System.out.println(matchObj1.replaceAll(name));
			ipString1 = matchObj1.replaceAll(name);
		}
		Matcher matchObj2 = pattObj2.matcher(ipString1);
		if(matchObj2.find()) {
			System.out.println("match 2 found");
//			System.out.println(matchObj2.replaceAll(fullName));
			ipString1 = matchObj2.replaceAll(fullName);
		}
		Matcher matchObj3 = pattObj3.matcher(ipString1);
		if(matchObj3.find()) {
			System.out.println("match 3 found");
//			System.out.println(matchObj3.replaceAll(contact));
			ipString1 = matchObj3.replaceAll(contact);
		}
		Matcher matchObj4 = pattObj4.matcher(ipString1);
		if(matchObj4.find()) {
			System.out.println("match 4 found");
//			System.out.println(matchObj4.replaceAll(currDate));
			ipString1 = matchObj4.replaceAll(currDate);
		}
		
		
		System.out.println("after regex::::::::::::\n");
		System.out.println(ipString1);
	}

}
