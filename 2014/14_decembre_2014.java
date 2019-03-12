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





Exercice 2
Question 1
public boolean isEnrolled(int id)
{
	Iterator<Student> it = iterator();
	while(it.nodeType()!=LEAF)
	{
		Student etudiant = it.getValue();
		if(etudiant.id == id)
			return true;
		else if(id < etudiant.id)
			it.goLeft();
		else 
			it.goRight();
	}
	return false;
}


Question 2
public boolean hasOnlyOneranch()
{
	Iterator<Student> it = iterator();
	while(it.nodeType()!=LEAF)
	{
		if(it.nodeType()==DOUBLE)
			return false;
		else if (it.nodeType()==SIMPLE_LEFT)
			it.goLeft();
		else 
			it.goRight();
	}
	return true;
}


Question 3
public String longestName()
{
	String long_nom = "";
	longestNameAux(iterator(), long_nom);
	return long_nom;
}

public void longestNameAux(Iterator<Student> it, String long_nom)
{
	if(it.getValue().name.length()> long_nom.length())
		long_nom = it.getValue().name;
	
	if(it.nodeType()!=LEAF)
	{
		it.goLeft();
		longestNameAux(it,long_nom);
		it.goUp();
		it.goRight();
		longestNameAux(it,long_nom);
		it.goUp();
	}
}


Examen 14 decembre 2014 (A Corriger)
Question 4
public int height()
{
	if(this.isEmpty())
		return -1;
	else
		return heightAux(iterator());
}

public int heightAux(Iterator<Student> it)
{
	Student etudiant = it.getValue();
	if(it.nodeType()!=LEAF && it.nodeType()!=SIMPLE_RIGHT)
	{
		it.goLeft();
		int long_gauche = heightAux(it);
		it.goUp();
		return (long_gauche > etudiant.rightHeight)?long_gauche+1:rightHeight+1;
	}
	else if(it.nodeType()!=SIMPLE_RIGHT )
		return etudiant.rightHeight + 1;
	else 
		return -1;
}


Question 5
public int enrollAux(Iterator<Student> it, Student student)
{
	Student etudiant = it.getValue();
	int hauteur = 0;
	if(it.nodeType()!=SENTINEL)
	{
		if(student.id < etudiant.id)
		{
			etudiant.leftTotal++;
			it.goLeft();
			hauteur = enrollAux(it,student) + 1;
			it.goUp();
			return hauteur;
		}	
		else if(student.id > etudiant.id)
		{
			
			it.goRight();
			hauteur = enrollAux(it,student) + 1;
			it.goUp();
			etudiant.rightHeight = (hauteur > etudiant.rightHeight) ? hauteur : etudiant.rightHeight;
			return hauteur;
		}
	}
	else
	{
		student.rightHeight = -1;
		student.leftTotal = 0;
		it.setValue(student);
		return 0;
	}
	
}