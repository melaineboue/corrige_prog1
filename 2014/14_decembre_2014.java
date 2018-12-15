Exercice 1 

Question 1

public String whichBus(String driver, String day)
{
	return this.getValue(driver).getValue(day);
}


Question 2
public Set<String> whichDays(String driver, String bus)
{
	DriverSchedule jours_conduite = this.getValue(driver);
	Set<String> jours = new HashSet<String>();
	Iterator<String> it = jours_conduite.iterator();
	while(it.hasNext())
	{
		String jour_courant = it.next();
		String busId = jours_conduite.getValue(jour_courant);
		if(busId.equals(bus))
		{
			jours.add(jour_courant);
		}
	}
	return jours;
}

Question 3
public void printInfoForEachBus(Set<String> busSet)
{
	Iterator<String> it = iterator();
	while(it.hasNext())
	{
		String driver = it.next();
		DriverSchedule jours_conduite = getValue(driver);
		Iterator<String> it2 = jours_conduite.iterator();
		while(it2.hasNext())
		{
			String jour = it2.next();
			String bus = jours_conduite.getValue(jour);
			if(busSet.contains(bus))
			{
				System.out.println("("+driver+","+jour+","+bus+")");
			}
		}
	}
}



Question 4 

public void mergeSchedules(BusDepot newDepot)
{
	Iterator<String> it = newDepot.iterator();
	while(it.hasNext())
	{
		String nouveau_driver = it.next();
		DriverSchedule nouveau_programme = newDepot.getValue(nouveau_driver);
		
		if(this.contains(nouveau_driver))
		{
			DriverSchedule ancien_programme = this.getValue(nouveau_driver);
			
			Iterator<String> it2 = nouveau_programme.iterator();
			while(it2.hasNext())
			{
				String jour = it2.next();
				String bus = nouveau_programme.getValue(jour);
				
				if(ancien_programme.contains(jour))
				{
					ancien_programme.modifyValue(jour,bus);
				}
				else 
				{
					ancien_programme.addValue(jour,bus);
				}
			}
		}
		else
		{
			this.addValue(nouveau_driver,nouveau_programme);
		}
	}
}