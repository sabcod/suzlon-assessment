package com.suzlon.assessment.turbines.api;

public class Turbine {
	
	private String model;
	private int ratedPower;
	private int cutInWindSpeed;
	private double ratedWindSpeed;
	private int cutOutWindSpeed;
	
	public Turbine(String model, int ratedPower, int cutInWindSpeed, double ratedWindSpeed, int cutOutWindSpeed) {
		this.model = model;
		this.ratedPower = ratedPower;
		this.cutInWindSpeed = cutInWindSpeed;
		this.ratedWindSpeed = ratedWindSpeed;
		this.cutOutWindSpeed = cutOutWindSpeed;
		
		
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRatedPower() {
		return ratedPower;
	}
	public void setRatedPower(int ratedPower) {
		this.ratedPower = ratedPower;
	}
	public int getCutInWindSpeed() {
		return cutInWindSpeed;
	}
	public void setCutInWindSpeed(int cutInWindSpeed) {
		this.cutInWindSpeed = cutInWindSpeed;
	}
	public int getCutOutWindSpeed() {
		return cutOutWindSpeed;
	}
	public void setCutOutWindSpeed(int cutOutWindSpeed) {
		this.cutOutWindSpeed = cutOutWindSpeed;
	}
	public double getRatedWindSpeed() {
		return ratedWindSpeed;
	}
	public void setRatedWindSpeed(int ratedWindSpeed) {
		this.ratedWindSpeed = ratedWindSpeed;
	}
}
