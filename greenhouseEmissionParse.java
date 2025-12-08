package com.example.parse;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//https://data.gov.ie/dataset/greenhouse-gas-emissions-projections
public class GreenhouseEmissionsParse { 

	private String jsonString="";

	public GreenhouseEmissionsParse() throws IOException, ParseException {
		URL url = new URL("https://data.gov.ie/dataset/greenhouse-gas-emissions-projection.json");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
		conn.setRequestMethod("GET");
		conn.connect(); 
		
		 int responseCode = conn.getResponseCode(); 
		 
		 if(responseCode != 200) 
			 throw new RuntimeException("HTTP Response code "+ responseCode);
		 else {
			 Scanner scanner = new Scanner(url.openStream());
			 while(scanner.hasNext()) {
				 jsonString +=scanner.nextLine();
			 }
			 
			 //What that "file" looks like as a String
			 System.out.println("JSON from call as a String");
			 System.out.println(jsonString);
			 
			 //What that "file" looks like as a Java Object
			 JSONParser parser = new JSONParser(); 
			 Object obj = parser.parse(jsonString); 
			 System.out.println("JSON as a Java Object");
			 System.out.println(obj);
			 
			 //What that "file" looks like parsed as JSON objects/arrays
			 JSONObject jobj = (JSONObject)parser.parse(jsonString);
			 JSONArray jsonArray = (JSONArray) jobj.get("Emissions"); 
			 System.out.println("JSON as a JSONArray= data collection");
			 System.out.println(jsonArray);
			 
			 //iterate through the elements in the array
			 for(int i=0; i <jsonArray.size(); i++) {
				 
				//Get the index of the JSON object and print the values as per the index
				JSONObject jo1 = (JSONObject)jsonArray.get(i);
				System.out.println("JSON Objects under posts array parsed");
				System.out.println("Category: " +jo1.get("Category"));
				System.out.println("Gas Units: " +jo1.get("Gas Units"));
		        System.out.println("Value: " +jo1.get("Value"));
			 
			 
			 }
		 }
	}

	public static void main(String[] args) {
		try {
			new GreenhouseEmissionsParse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	
