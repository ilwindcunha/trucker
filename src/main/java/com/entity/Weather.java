package com.entity;

import java.time.LocalDate;

public class Weather {

	private String city;
	private String description;
	private int humidity;
	private int pressure;
	private int tempreature;
	private Wind wind;
	private LocalDate timestamp;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getTempreature() {
		return tempreature;
	}

	public void setTempreature(int tempreature) {
		this.tempreature = tempreature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Weather [city=" + city + ", description=" + description + ", humidity=" + humidity + ", pressure="
				+ pressure + ", tempreature=" + tempreature + ", wind=" + wind + ", timestamp=" + timestamp + "]";
	}

}
