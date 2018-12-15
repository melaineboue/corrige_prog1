Exercice 24 Juin 2015

Question 1
On verifie si la table contient une clé nommé employeeId et parmis les valeurs associé à la clé 
il y a certificate

public boolean checkCertificate(String employeeId, String certificate)
{
	Set<String> certificate_list = contains(employeeId);
	return certificate!=null && certificate.contains(certificate);
}


Question 2
On parcours toute la table, et pour chaque employeeId, on  recupère la valeur associée et 
on verifie s'il contient certificateId, si oui on ajoute employeeId dans l'ensemble à retourner
public Set<String> hasCertificate(String certificateId)
{
	Iterator<String> it = iterator();
	//Car Set est une interface, on peut pas l'instancier
	Set<String> employees = new HashSet<String>();
	while(it.hasNext())
	{
		String employeeId = it.next();
		Set<String> certificates = this.getValue(employeeId);
		if(certificates.contains(certificateId)
		{
			employees.add(employeeId);
		}
	}
	return employees;
}

Question 3
public removeCertificate(String certificateId)
{
	Iterator<String> it = iterator();
	while(it.hasNext())
	{
		String employeeId = it.next();
		this.getValue(employeeId).remove(certificateId);
	}
}