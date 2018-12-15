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

Question 4
public int numberOfCertificates()
{
	Iterator<String> it = iterator();
	Set<String> certificates = new HashSet<String>();
	
	while(it.hasNext())
	{
		String employeeId = it.next();
		Set<String> current_certificates = this.getValue(employeeId);
		certificates.AddAll(this.getValue(employeeId));
	}
	return certificates.size();
}


Question 5
public void addCertificates(Table<String,String> table)
{
	Iterator<String> it = table.iterator();
	while(it.hasNext())
	{
		String employee = it.next();
		String certificate = table.getValue(employee);
		if(this.contains(employee))
		{
			this.getValue(employee).add(certificate);
		}
		else
		{
			Set<String> nouveau_certificat = new HashSet<String>();
			nouveau_certificat.add(certificate)
			this.addValue(employee,nouveau_certificat);
		}
	}
}