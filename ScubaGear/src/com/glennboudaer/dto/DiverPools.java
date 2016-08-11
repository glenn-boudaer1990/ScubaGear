package com.glennboudaer.dto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiverPools
{
	private Map<String, DiverPool> pools;
	
	public DiverPools()
	{
		pools = new HashMap<String, DiverPool>();
	}
	
	public boolean addDiver(AbstractDiver aDiver)
	{
		Map<String, DiverPool> backup = pools;
		
		try
		{
			String diverType = aDiver.getType();
			DiverPool pool = pools.get(diverType);
			
			if (pool == null) 
			{
				pool = new DiverPool();

				pools.put(diverType, pool);
			}

			pool.addDiver(aDiver);
			
			return true;
		} 
		catch (Exception ex)
		{
			pools = backup;
			
			return false;
		}
	}
	
	public DiverPool getPoolByType(String pType)
	{
		return this.pools.get(pType);
	}
	
	public void joinAndAddInstructorPools()
	{
		DiverPool joinedPool = new DiverPool();
		
		String[] instructorTypes = {"AI", "1*INSTRUCTOR", "2*INSTRUCTOR", "3*INSTRUCTOR"};
		
		for (String type : instructorTypes)
			joinedPool.join(getPoolByType(type));
		
		pools.put("INSTRUCTOR", joinedPool);
	}
	
	public void sortPools()
	{
	    Iterator it = pools.entrySet().iterator();
	    
	    while (it.hasNext()) 
	    {
	    	Map.Entry<String, DiverPool> entry = (Map.Entry<String, DiverPool>) it.next();
	    	
	    	entry.getValue().sort();
	    }
	}
}
