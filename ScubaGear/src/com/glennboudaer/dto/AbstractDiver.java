package com.glennboudaer.dto;

import com.glennboudaer.enums.Brevet;

public abstract class AbstractDiver 
{
	protected String name;
	protected int numberOfStars;
	protected Brevet brevet;
	protected int numberOfDives;
	protected boolean proof;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfStars() {
		return numberOfStars;
	}
	
	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}
	
	public Brevet getBrevet() {
		return brevet;
	}
	
	public void setBrevet(Brevet brevet) {
		this.brevet = brevet;
	}
	
	public int getNumberOfDives() {
		return numberOfDives;
	}
	
	public void setNumberOfDives(int numberOfDives) {
		this.numberOfDives = numberOfDives;
	}
	
	public boolean wantsProof() {
		return proof;
	}
	
	public void setProof(boolean proof) {
		this.proof = proof;
	}
}
