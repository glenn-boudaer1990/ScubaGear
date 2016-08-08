package com.glennboudaer.dto;

import com.glennboudaer.enums.Brevet;

public class Diver extends AbstractDiver 
{
	public Diver()
	{
		this(Brevet.DIVER);
	}
	
	public Diver (Brevet pBrevet)
	{
		this(1, pBrevet, 0);
	}
	
	public Diver (int pNumOfStars, Brevet pBrevet, int pNumOfDives)
	{
		this (null, pNumOfStars, pBrevet, pNumOfDives, false);
	}
	
	public Diver (String pName, int pNumOfStars, Brevet pBrevet, int pNumOfDives, boolean pProof)
	{
		this.name = pName;
		this.numberOfStars = pNumOfStars;
		this.brevet = pBrevet;
		this.numberOfDives = pNumOfDives;
		this.proof = pProof;
	}
}
