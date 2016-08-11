package com.glennboudaer.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiverPool 
{
	private ArrayList<AbstractDiver> pool;
	
	public DiverPool()
	{
		this.pool = new ArrayList<AbstractDiver>();
	}
	
	public void addDiver(AbstractDiver aDiver)
	{
		this.pool.add(aDiver);
	}
	
	public ArrayList<AbstractDiver> getDivers()
	{
		return this.pool;
	}

	public void join(DiverPool pPool)
	{
		if (pPool == null)
			return;
		
		for (AbstractDiver diver : pPool.getDivers())
		{
			addDiver(diver);
		}
	}
	
	public int size()
	{
		return this.pool.size();
	}
	
	public AbstractDiver get(int index)
	{
		return this.pool.get(index);
	}
	
	public void remove(int index)
	{
		this.pool.remove(index);
	}
	
	public boolean isEmpty()
	{
		if (this.pool == null)
			return true;
		
		return this.pool.isEmpty();
	}
	
	public void sort()
	{
	    Collections.sort(pool, new Comparator<AbstractDiver>() {
	        @Override 
	        public int compare(AbstractDiver p1, AbstractDiver p2) {
	            return p1.getNumberOfDives() - p2.getNumberOfDives();
	        }
	    });
	}
}


