package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Vehicles implements Serializable {
	@Id
	private String vin;
	
	public Vehicles(){
		
	}
	private String make;
	private String model;
	private int year;
	private int redlineRpm;
	private int maxFuelVolume;
	private String lastServiceDate;
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public String getlastServiceDate() {
		return lastServiceDate;
	}

	public void setlastServiceDate(String localDate) {
		this.lastServiceDate = localDate;
	}

	@Override
	public String toString() {
		return "Vehicles [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm="
				+ redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", localDate=" + lastServiceDate + "]";
	}

}
