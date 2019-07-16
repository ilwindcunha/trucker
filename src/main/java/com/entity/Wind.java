package com.entity;


public class Wind {

	private double speed;
	private int degree;

	@Override
	public String toString() {
		return "Wind [speed=" + speed + ", degree=" + degree + "]";
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

}
