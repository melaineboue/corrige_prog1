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


