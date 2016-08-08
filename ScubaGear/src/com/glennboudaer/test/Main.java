package com.glennboudaer.test;

import com.glennboudaer.dto.AbstractDiver;
import com.glennboudaer.dto.DiverFactory;
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
		
	}

}
