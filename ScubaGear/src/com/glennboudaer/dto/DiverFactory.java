package com.glennboudaer.dto;

import com.glennboudaer.enums.Brevet;

public class DiverFactory 
{
	public DiverFactory()
	{
	}

	public AbstractDiver makeDiver()
	{
		return makeDiver(Brevet.DIVER);
	}
	
	public AbstractDiver makeDiver (Brevet pBrevet)
	{
		return makeDiver (1, pBrevet, 0);
	}
	
	public AbstractDiver makeDiver (int pNumOfStars, Brevet pBrevet, int pNumOfDives)
	{
		return makeDiver ("", pNumOfStars, pBrevet, pNumOfDives ,false);
	}
	
	public AbstractDiver makeDiver(String pName, int pNumOfStars, Brevet pBrevet, int pNumOfDives, boolean pProof)
	{
	    AbstractDiver aDiver = null;
	
	    switch (pBrevet)
	    {
			case DIVER:
			case INSTRUCTOR:
			case AI:
				aDiver = new Diver(pName, pNumOfStars, pBrevet, pNumOfDives, pProof);
			default:
				break;
	    }
	    
	    return aDiver;
	}
}
