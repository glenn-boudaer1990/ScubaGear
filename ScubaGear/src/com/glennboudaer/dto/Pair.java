package com.glennboudaer.dto;

public class Pair 
{
	private AbstractDiver PersonHighestRank;
	private AbstractDiver PersonLowerRank;
	private AbstractDiver OptionalThirdPerson;

	protected boolean performProof;

	public Pair(AbstractDiver pHighest, AbstractDiver pLower) 
	{
		this.PersonHighestRank = pHighest;
		this.PersonLowerRank = pLower;
	}

	public AbstractDiver getOptionalThirdPerson() 
	{
		return this.OptionalThirdPerson;
	}

	public void setOptionalThirdPerson(AbstractDiver optionalThirdPerson) 
	{
		this.OptionalThirdPerson = optionalThirdPerson;
	}

	public AbstractDiver getPersonHighestRank() 
	{
		return this.PersonHighestRank;
	}

	public AbstractDiver getPersonLowerRank() 
	{
		return this.PersonLowerRank;
	}

	public boolean performProof() 
	{
		return this.performProof;
	}

	public void setPerformProof(boolean value) 
	{
		this.performProof = true;
	}
}