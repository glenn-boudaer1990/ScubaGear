package com.glennboudaer.dto;

import java.io.StringWriter;
import java.util.ArrayList;

public class PairMaker 
{
	private DiverPools pools;
	
	private ArrayList<Pair> ProofPairs = null;
	private ArrayList<Pair> PairsList = null;
	private int firstfree = 0;
	  
	public PairMaker(DiverPools pPools) 
	{
		this.pools = pPools;
	    this.ProofPairs = new ArrayList<Pair>();
	    this.PairsList = new ArrayList<Pair>();
	}

	public void makePairs() 
	{
		//checkForProofs();

		pools.joinAndAddInstructorPools();
		
	    for (AbstractDiver instructor : pools.getPoolByType("INSTRUCTOR").getDivers()) 
	    {
	    	if (!this.pools.getPoolByType("1*DIVER").isEmpty()) 
	    	{
	            this.PairsList.add(new Pair(instructor, this.pools.getPoolByType("1*DIVER").get(0)));
	            this.pools.getPoolByType("1*DIVER").remove(0);
	    	} 
	    	else if (!this.pools.getPoolByType("2*DIVER").isEmpty()) 
	    	{
	            this.PairsList.add(new Pair(instructor, this.pools.getPoolByType("2*DIVER").get(0)));
	            this.pools.getPoolByType("2*DIVER").remove(0);
	    	} 
	    	else if (!this.pools.getPoolByType("3*DIVER").isEmpty()) 
	    	{
	            this.PairsList.add(new Pair(instructor, this.pools.getPoolByType("3*DIVER").get(0)));
	            this.pools.getPoolByType("3*DIVER").remove(0);
	    	}
	    }
	    
	    pair2starDiversWith3StarDivers();
	    
	    while (!pools.getPoolByType("3*DIVER").isEmpty() && !pools.getPoolByType("1*DIVER").isEmpty())
	    {
	    	if (pools.getPoolByType("1*DIVER").get(0).getNumberOfDives() < 15)
	    		pairStar1DiversWithInstructorPairsFormingTrio();
	    	else
	    		pairStar1DiversWithStar3Divers();
	    }
	    
		if (!pools.getPoolByType("1*DIVER").isEmpty()) 
		{
			pairStar1DiversWithInstructorPairsFormingTrio();
		}

		if (!pools.getPoolByType("2*DIVER").isEmpty()) 
		{
			pairStar2DiversTogether();

			pairStar2DiversWithInstructorPairsFormingTrio();
		}

		if (!pools.getPoolByType("3*DIVER").isEmpty()) 
		{
			pairStar3DiversTogether();

			if (!pools.getPoolByType("3*DIVER").isEmpty()) 
			{
				((Pair) PairsList.get(PairsList.size() - 1)).setOptionalThirdPerson(pools.getPoolByType("3*DIVER").get(0));
			}
		}

		PairsList.addAll(ProofPairs);
	
		printOutput();
	}

	public ArrayList<Pair> getPairs()
	{
		return PairsList;
	}
	
	private void pair2starDiversWith3StarDivers()
	{
		while (!pools.getPoolByType("2*DIVER").isEmpty() && !pools.getPoolByType("3*DIVER").isEmpty())
		{
			this.PairsList.add(new Pair(pools.getPoolByType("3*DIVER").get(0), pools.getPoolByType("2*DIVER").get(0)));
			
			pools.getPoolByType("2*DIVER").remove(0);
			pools.getPoolByType("3*DIVER").remove(0);
		}
	}

	private void pairStar1DiversWithInstructorPairsFormingTrio() 
	{
		((Pair) PairsList.get(firstfree)).setOptionalThirdPerson(pools.getPoolByType("1*DIVER").get(0));
		
		pools.getPoolByType("1*DIVER").remove(0);
		pools.getPoolByType("INSTRUCTOR").remove(0);
		
		this.firstfree += 1;
	}
	
	private void pairStar1DiversWithStar3Divers() 
	{
		if (!pools.getPoolByType("3*DIVER").isEmpty() && pools.getPoolByType("1*DIVER").get(0).getNumberOfDives() >= 15) 
		{
			PairsList.add(new Pair(pools.getPoolByType("3*DIVER").get(0), pools.getPoolByType("1*DIVER").get(0)));
			
			pools.getPoolByType("1*DIVER").remove(0);
			pools.getPoolByType("3*DIVER").remove(0);

			if (!pools.getPoolByType("1*DIVER").isEmpty())
				pairStar1DiversWithStar3Divers();
		}
	}
	
	private void pairStar2DiversTogether() 
	{
		while (pools.getPoolByType("2*DIVER").size() > 1) 
		{
			PairsList.add(new Pair(pools.getPoolByType("2*DIVER").get(0), pools.getPoolByType("2*DIVER").get(1)));
			
			pools.getPoolByType("2*DIVER").remove(0);
			pools.getPoolByType("2*DIVER").remove(0);
		}
	}

	private void pairStar2DiversWithInstructorPairsFormingTrio() 
	{
		while (!pools.getPoolByType("2*DIVER").isEmpty() && !pools.getPoolByType("INSTRUCTOR").isEmpty()) 
		{
			((Pair) PairsList.get(this.firstfree)).setOptionalThirdPerson(pools.getPoolByType("2*DIVER").get(0));
			
			pools.getPoolByType("2*DIVER").remove(0);
			pools.getPoolByType("INSTRUCTOR").remove(0);
			
			firstfree += 1;
		}
	}

	private void pairStar3DiversTogether() 
	{
		while (pools.getPoolByType("3*DIVER").size() > 1) 
		{
			PairsList.add(new Pair(pools.getPoolByType("3*DIVER").get(0), pools.getPoolByType("3*DIVER").get(1)));
			
			pools.getPoolByType("3*DIVER").remove(0);
			pools.getPoolByType("3*DIVER").remove(0);
		}
	}
		  
	private void checkForProofs() 
	{
		for (int i = 0; i < pools.getPoolByType("PROOF").size(); i++) 
		{
		      this.ProofPairs.add(new ProofPair(pools.getPoolByType("INSTRUCTOR").get(i), pools.getPoolByType("PROOF").get(i)));
		      
		      pools.getPoolByType("PROOF").get(i).setProof(false);
		}
	}
	
	private StringWriter printOutput() 
	{
		StringWriter writer = new StringWriter();
		writer.append("Duiker hoogste brevet \t Duiker1 \t\t Duiker2 \t\t Proef\n");
		writer.append("--------------------------------------------------------------------------------\n");

		for (Pair pair : this.ProofPairs) 
		{
			writer.append("- " + pair.getPersonHighestRank().getName() + "(" + pair.getPersonHighestRank().getBrevet()
					+ ")" + " \t " + pair.getPersonLowerRank().getName() + "(" + pair.getPersonLowerRank().getBrevet()
					+ ") \t" + "X \n");
		}

		for (Pair pair : PairsList) 
		{
			if (pair.getOptionalThirdPerson() == null)
				writer.append("- " + pair.getPersonHighestRank().getName() + "("
						+ pair.getPersonHighestRank().getBrevet() + ")" + " \t " + pair.getPersonLowerRank().getName()
						+ "(" + pair.getPersonLowerRank().getBrevet() + ") \n");
			else 
			{
				writer.append("- " + pair.getPersonHighestRank().getName() + "("
						+ pair.getPersonHighestRank().getBrevet() + ")" + " \t " + pair.getPersonLowerRank().getName()
						+ "(" + pair.getPersonLowerRank().getBrevet() + ")" + " \t "
						+ pair.getOptionalThirdPerson().getName() + "(" + pair.getOptionalThirdPerson().getBrevet()
						+ ")\n");
			}
		}
		
		return writer;
	}
}
