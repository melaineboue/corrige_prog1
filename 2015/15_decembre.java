Examen Prog 1 15 décembre 2015

Exercice 1 

public boolean existingCommune(String deptName; String communeName){
	if(this.contains(deptName)){   
		Set<String> communes = this.get(deptName);  
		return communes != null && communes.contains(communeName);   
	}
	return false;	
}


Question 2
 
 
 
 
 
 
 
 
Exercice 2

Question 4

public int numberOfNodes()
{
	int number_of_nodes = 0;
	Iterator<PostCard> it = iterator();
	
	while(it.nodeType()==SIMPLE_LEFT || t.nodeType()==DOUBLE)
	{
		//le nombre du fils droit plus l'element courant
		number_of_nodes += it.getValue().rightTotal + 1; 
		it.goLeft();
	}	
	return number_of_nodes;
}


Question 5 

public boolean addAux(Iterator<PostCard> it, PostCard postcard)
{
	PostCard value = it.getValue();
	boolean isAdded = false;
	
	if(it.nodeType()!=LEAF && value.number != postcard.number)
	{
		if(postcard.number < value.number)
		{
			it.goLeft();
			isAdded = addAux(it,postcard);
			it.goUp();
			if(isAdded)
			{
				if(postcard.number < value.minimum )
					//mettre à jour le minimum si l'element ajouté a un number le plus petit
					value.minimum = postcard.minimum; 
			}	
		}			
		if(postcard.number > value.number)
		{
			it.goRight();
			isAdded = addAux(it,postcard);
			it.goUp();
			if(isAdded)
				value.rightTotal++;  //incrementer de 1 si le nouvel element
		}
		if(postcard.number == value.number)
		{
			it.goUp();
			addAux(it);
		}
	}
	else if(value.number == postcard.number)
	{
		return false;
	}
	else
	{	
		postcard.minimum = postcard.number;
		postcard.rightTotal = 0;
		it.AddValue(postcard);
		return true;
	}
}