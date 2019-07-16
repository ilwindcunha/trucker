package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Readings {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String vin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	private double latitude;
	private double longitude;
	private String timestamp;
	private double fuel;
	private int speed;
	private int engineHp;
	private boolean checkEngineLightOn;
	private boolean cruiseControlOn;
	private boolean engineCooolantLow;
	private int engineRpm;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Tires tires;

	public Readings() {
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public boolean isEngineCooolantLow() {
		return engineCooolantLow;
	}

	public void setEngineCooolantLow(boolean engineCooolantLow) {
		this.engineCooolantLow = engineCooolantLow;
	}

	public int getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Tires getTires() {
		return tires;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		return "Readings [latitude=" + latitude + ", longitude=" + longitude + ", timestamp=" + timestamp + ", fuel="
				+ fuel + ", speed=" + speed + ", engineHp=" + engineHp + ", checkEngineLightOn=" + checkEngineLightOn
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineCooolantLow=" + engineCooolantLow + ", engineRpm="
				+ engineRpm + tires.toString();
	}

	
	public boolean check(){
		if(tires.getFrontLeft() < 32 || tires.getFrontLeft()>36)
			return true;
		if(tires.getFrontRight() < 32 || tires.getFrontRight() >36)
			return true;
		if(tires.getRearLeft() <32 || tires.getRearLeft() >36)
			return true;
		if(tires.getRearRight() <32 || tires.getRearRight() >36)
			return true;
		return false;
	}
}
