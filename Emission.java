package com.example.dit.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@XmlRootElement(name ="category")
@Entity 
public class Emission {

	private int id;
	
	private String category;
	private String Scenario;
	private String GasUnits;
	private Boolean Value;
	private int Year;
	
	public Emission() {

	}

	public Emission(String category, String Scenario, String GasUnits, Boolean Value, int Year) {
		this.category = category;
		this.Scenario = Scenario;
		this.GasUnits = GasUnits;
		this.Value = Value;
		this.Year = Year;
		
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@XmlElement
	public String getScenario() {
		return Scenario;
	}

	public void setScenario(String Scenario) {
		this.Scenario = Scenario;
	}
	
	@XmlElement
	public String getGasUnits() {
		return GasUnits;
	}

	public void setGasUnits(String GasUnits) {
		this.GasUnits = GasUnits;
	}
	
	@XmlElement
	public Boolean getValue() {
		return Value;
	}

	public void setValue(Boolean Value) {
		this.Value = Value;
	}
	
	@XmlElement
	public int getYear() {
		return Year;
	}

	public void setYear(int Year) {
		this.Year = Year;
	}
}
