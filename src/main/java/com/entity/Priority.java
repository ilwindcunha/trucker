package com.entity;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Priority {
	@Id
	private String vin;
	private PriorityTypes type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Priority(String vin, PriorityTypes type){
		this.vin = vin;
		this.type = type;
		this.createDate = Calendar.getInstance().getTime();
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public PriorityTypes getType() {
		return type;
	}
	public void setType(PriorityTypes type) {
		this.type = type;
	}
	
	
}
