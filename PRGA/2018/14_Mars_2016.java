Problème 1

@Test
public void testTirageAvecRemise()
{
	//int[] ou Integer[] , pas il n'y a pas de type integer
	int[] tab = {1,2,...,10}; //j'ai la paresse de tout ecrire
	Urne urne = new Urne(tab);
	int size = urne.taille();
	
	for(int j=1;j<=Nombre_Tirage;j++)
	{
		urne.tirageAvecRemise(3);
		assertEquals(size,urne.taille());
		Set<Integer> ensemble = urne.getBoules();
		for(int i=1; i<=tab.lenght;i++)
		{
			assertTrue(ensemble.contains(tab[i]));
		}
	}	
}





Problème 2


Question 2.1

public Personne(int ident)
{
	//on ira chercher dans la base de données la personne ayant pour identifiant ident 
	//passé en paramètre
	try
	{
		Connexion connexion = RessourcesExam.getConnexion(); //on se connecte à la base de données
		Statement statement = connexion.createStatement();
		String query = "SELECT * FROM personnes WHERE ident="+ident;
		ResultSet result = statement.executeQuery(query);
		
		if(result.next())
		{
			//on a bien trouvé la personne, on recupère ses informations
			this.ident = result.getInt("");
			this.nom = result.getString("nom");
			this.prenom = result.getString("prenom");			
		}
		else
		{
			//la personne n'existe pas dans la base de données 
			this.ident = -1;
			this.nom = "inconnu";
			this.prenom = "inconnu";			
		}
		statement.close();
	}
	catch(Exception e)
	{
		//il y a une exception
		this.ident = -1;
		this.nom = "inconnu";
		this.prenom = "inconnu";
	}	
}



Question 2.2

class RessourcesExam
{
	//cette variable va contenir les personnes déjà extraite
	public static HashMap<Integer,Personne> personnes = new HashMap<Integer,Personne>();
	
	public static Personne extrairePersonne(int ident)
	{
		if(personnes.containsKey(ident))
			return personnes.get(ident); //on retourne la personne stocké ayant comme identifiant ident
		else 
		{
			Personne p = new Personne(ident);//il recupèrela personne dans la base de données
			if(p.getIdent()==-1) //il n'a rien trouvé 
				return null;
			else
			{
				//si on a trouvé une personne sur ce identifiant
				personnes.put(p.getIdent(),p) //on l'enregistre
				return p;
			}
		}
	}
}


Question 2.3

public void extraireAuteurs()
{
	try
	{
		Connexion connexion = RessourcesExam.getConnexion(); //on se connecte à la base de données
		Statement statement = connexion.createStatement();
		String query = "SELECT * FROM AUTEUR_LIVRE WHERE ident_livre="+this.ident+ " ORDER BY ordre_apparition";
		
		ResultSet result = statement.executeQuery(query);
		
		while(result.next())
		{
			int ident_personne = result.getInt("ident_personne");
			Personne p = new Personne(ident_personne); //un auteur de ce livre
			auteurs.add(p);
		}
		statement.close();
	}
}


Question 2.4

public void sauvegarder() 
{
	try 
	{
		Connexion connexion = RessourcesExam.getConnexion();
		Statement statement = connexion.createStatement();
		//insertion du livre
		String query_livre = "INSERT INTO LIVRE (ident,titre,annee,editeur) VALUES ";
		query_livre = query_livre + "("+this.getIdent()+","+this.getTitre()+","+this.getAnnee()+","+this.getEditeur()+")";
		statement.executeUpdate(query_livre);
		int ordre = 1;
		for( Personne p : auteurs)
		{
		    String query_auteurs = "INSERT INTO AUTEUR _LIVRE(ident_personne,ident_livre,ordre_apparition) VALUES ";
		    query_auteurs = query_auteurs + "("+p.getIdent()+","+this.getIdent()+","+ordre+")";
		    statement.executeUpdate(query_auteurs);
		    
		    ordre++;
		}
		
		statement.close();
	}
	
	
}
