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
		number_of_nodes += it.getValue().rightTotal + 1; //le nombre du fils droit plus l'element courant
		it.goLeft();
	}	
	return number_of_nodes;
}