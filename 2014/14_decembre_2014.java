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
