package com.glennboudaer.test;

import com.glennboudaer.dto.AbstractDiver;
import com.glennboudaer.dto.DiverFactory;
import com.glennboudaer.dto.DiverPools;
import com.glennboudaer.dto.Pair;
import com.glennboudaer.dto.PairMaker;
import com.glennboudaer.enums.Brevet;

public class Main {

	public static void main(String[] args) 
	{
		DiverFactory factory = new DiverFactory();
		
		AbstractDiver duiker1 = factory.makeDiver(1, Brevet.DIVER, 10);
		AbstractDiver duiker2 = factory.makeDiver(2, Brevet.DIVER, 50);
		AbstractDiver duiker3 = factory.makeDiver(1, Brevet.DIVER, 15);
		AbstractDiver duiker4 = factory.makeDiver(3, Brevet.DIVER, 75);
		AbstractDiver duiker5 = factory.makeDiver(1, Brevet.DIVER, 12);

		AbstractDiver instructeur1 = factory.makeDiver(1, Brevet.INSTRUCTOR, 100);
		AbstractDiver instructeur2 = factory.makeDiver(2, Brevet.INSTRUCTOR, 183);
		AbstractDiver instructeur3 = factory.makeDiver(3, Brevet.INSTRUCTOR, 200);
		AbstractDiver instructeur4 = factory.makeDiver(0, Brevet.AI, 279);
		
		DiverPools pools = new DiverPools();
		pools.addDiver(duiker1);
		pools.addDiver(duiker2);
		pools.addDiver(duiker3);
		pools.addDiver(duiker4);
		pools.addDiver(duiker5);
		
		pools.addDiver(instructeur1);
		pools.addDiver(instructeur2);
		pools.addDiver(instructeur3);
		pools.addDiver(instructeur4);
		
		pools.sortPools();
		
		PairMaker pairMaker = new PairMaker(pools);
		pairMaker.makePairs();
		
		for (Pair pair : pairMaker.getPairs()) 
		{
			if (pair.getOptionalThirdPerson() == null)
				System.out.println(pair.getPersonHighestRank().toString() + " duikt met " + pair.getPersonLowerRank().toString());
			else
				System.out.println(pair.getPersonHighestRank().toString() + " duikt met " + pair.getPersonLowerRank().toString() + "("
						+ " en derde duiker: " + pair.getOptionalThirdPerson().toString());
		}
	}
}
