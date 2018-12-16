Examen du 3 janvier 2017

Exercice 1

Question 1
public boolean practiceSport(String clubName, String sportName)
{
	Club club = this.getValue(clubName);
	return club!=null && club.contains(sportName);
}

Question 2
public int countVeryAthleticMembers(String clubName)
{
	Set<Person> athletes = new HashSet();
	if(this.contains(clubName)
	{
		Club club = this.getValue(clubName);
		Iterator<String> club.iterator();
		while(it.hasNext())
		{
			String sport = it.next();
			Set<Person> persons = club.getValue(sport);
			if(athletes.size()==0)
				athletes = persons;
			else
			{
				athletes.intersection(persons);
			}
		}
	}
	return athletes.size();
}


Question 3
public void removePerson(Person person)
{
	Iterator<String> it = this.iterator();
	while(it.hasNext())
	{
		String clubName = it.next();
		Club club = this.getValue(clubName);
		Iterator<String> it2 = club.iterator();
		while(it2.hasNext())
		{
			String sport personnes = it.next();
			Set<Person> personnes = club.getValue(sport);
			personnes.remove(person);
		}
	}
}


Question 4
public void acquisition(String clubName1, String clubName2)
{
	Club club1 = this.getValue(clubName1);
	Club club2 = this.getValue(clubName2);
	
	Iterator<String> it = club2.iterator();
	while(it.hasNext())
	{
		String sport = it.next();
		Set<Person> personnes2 = club2.getValue(sport);
		
		if(club1.contains(sport))
		{
			Set<Person> personnes1 = club1.getValue(sport);
			personnes1.union(personnes2);
		}
		else
		{
			club1.addValue(sport,personnes2);
		}
	}
}



Question 5
On le fera en deux etape, on va aplatir la grande table pour avoir
une autre table qui prendra comme clé le nom du sport et comme valeur
les personnes qui pratiquent ce sport

public String mostPopularSport()
{
	//Aplatissement
	Iterator<String> it = this.iterator();
	Table<String,Set<Person>> table_aplati = new Table<String,Set<Person>>()
	while(it.hasNext())
	{
		String clubName = it.next();
		Club club = this.getValue(clubName);
		Iterator<String> it2 = this.iterator();
			
		while(it2.hasNext())
		{
			String sport = it2.next();
			Set<Person> personnes = club.getValue(sport);
					
			if(table_aplati.contains(sport))
			{
				Set<Person> personnes1 = table_aplati.getValue(sport);
				personnes1.union(personnes);
			}
			else
			{
				table_aplati.addValue(sport,personnes);
			}
		}
	}
	//Fin de l'aplatissement
	String popularSport = "";
	int max = 0;
	Iterator<String> it3 = table_aplati.iterator();
	while(it3.hasNext())
	{
		String sport = it3.next();
		Set<Person> personnes_regroupe = club.getValue(sport);
		if(personnes_regroupe.size() > max)
		{
			max = personnes_regroupe.size();
			popularSport = sport;
		}
	}
}



Exercice 2

Question 1
public boolean memberCompany(long siretCode)
{
	Iterator<Company> it = iterator();
	while(it.nodeType()!=LEAF || it.nodeType()!=SENTINEL)
	{
		Company entreprise = it.getValue();
		if(entreprise.siretCode ==siretCode)
			return true;
		if(siretCode < entreprise.siretCode)
			it.goLeft();
		else if(siretCode > entreprise.siretCode)
			it.goRight();
	}
	return false;
}


Question 2
public int numberOfCompanies(){
	int nombre = 0;
	Iterator<Company> it = this.iterator();
	while(it.nodeType()!=SENTINEL)
	{
		nombre+=it.getValue().rightTotal+1;
		it.goLeft();
	}
	return nombre;
}


Question 3 
public void printSameSirenNumber(long sirenCode)
{
	printSameSirenNumberAux(iterator(), sirenCode);
}

public void printSameSirenNumberAux(Iterator<Company> it, long sirenCode)
{
	Company compagnie = it.getValue();
	if(it.nodeType()!=SENTINEL)
	{
		it.goLeft();
		printSameSirenNumberAux(it,sirenCode);
		if((sirenCode+"").equals((compagnie.siretCode+"").substring(0,9)))
			System.out.println(compagnie.name);
		it.goUp();
		it.goRight();
		printSameSirenNumberAux(it,sirenCode);
		it.goUp();
	}
}

Question 4


Question 5