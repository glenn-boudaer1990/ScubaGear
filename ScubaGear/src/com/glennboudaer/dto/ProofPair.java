package com.glennboudaer.dto;

public class ProofPair extends Pair
{
	public ProofPair(AbstractDiver pHighest, AbstractDiver pLowest)
	{
		super(pHighest, pLowest);
		
		pLowest.setProof(true);
		this.setPerformProof(true);
	}
}
