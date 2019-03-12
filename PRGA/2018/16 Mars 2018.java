Problème 1

Question 1.1

/* 
 Nous allons utiliser la fonction 
 assertTrue(condition) : le test reussie quand la condition est vrai ou
 assertEquals(a,b) : le test reussit quand a = b ou 
 assertFalse(condition) : le test reussit quand la condition est fausse 
 */
import static org.junit.Assert.*;
import org.junit.Test;
public class IterateurIntervalleTest {
@Test
public void test1aN() {
IterateurIntervalle iter = new IterateurIntervalle(1,5);
// à compléter
	//ici l'iterateur iter a été crée, donc il faut tester si la fonction next() parcours bien les nombres de 1 à 5
	// et que la fonction hasNext() renvoie true quand il reste encore des nombre et false sinone
	assertTrue(iter.hasNext()); //on est sur le premier nombre, la fonction hasNext() de l'iterateur iter doit nous retourner true 
	//pour dire qu'il y a d'autres nombres après
	
	for(int i = 0; i<=5; i++)
		assertTrue(iter.next()==i);
	
	assertFalse(iter.hasNext()); //on a lu tous les nombres. hastNext() doit nous retourner false 
}
}


Question 1.2
/*
Ce scénario ne couvre pas tous les cas.
Il doit gérer le cas où l'exception est lévé par l'appel de next() après que hasNext() aie retourné false.
*/



Problème 2

class TableNomen implements Nomenclature
{
	//on remarque que presque toutes prennent en paramètres le code, et retourne l'entree ou  le libelle
	//donc on va stocker toutes les entrées dans une table (HashMap), le code(String) sera la clé et l'entrée (Entree) sa valeur
	HashMap<Striing,Entree> les_entrees; //il stocke les entrées
	
	public TableNomen()
	{
		les_entrees = new HashMap<Striing,Entree>();
	}
	
	
	public Entree getEntree(String code)
	{
		return les_entrees.get(code); //retourne l'entree qui est associée à la clé code
	}
	
	public String getLibelle(String code)
	{
		return les_entrees.get(code).getLibelle();
	}
	
	public Entree getPere(Entree entree)
	{
		String codePere = les_entrees.get(entree.getCode()).getCodePere();
		if(codePere == null)
			return null;
		else
			return les_entrees.get(codePere);
	}
	
	public int getNiveau(Entree entree)
	{
		//on va parcourir tous ses parents (père, grand père, arrière grand père,...) en les comptant. Son niveau egal au nombre de ses parents +1
		int niveau = 1;
		Entree entree_copie = entree.clone(); // on le clone pour eviter les changement de valeur par reference
		while(entree_copie.getCodePere()!=null)
		{
			entree_copie = les_entrees.get(entree.getCodePere());
			niveau++;
		}
		return niveau;
	}
	
	public boolean ajoutPossible(Entree e)
	{
		if(!les_entrees.contains(e.getCodePere()) || e.getCode()=="" || e.getLibelle() =="" || les_entrees.contains(e.getCode() )
		{
			//si le codePère est absent
			//si le code est absent 
			//si le libelle est absent
			//si la nomenclature contient déjà le code de l'element
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	
	public void ajouter(Entree e) throws Exception
	{
		if(!ajouterPossible(e))
		{
			//si on peut pas ajouter l'entree e, on lève une exception
			throws Exception();
		}
		else 
		{
			les_entrees.put(e.getCode(), e); //on l'ajoute dans la table, avec pour clé son code
		}
	}
	
}

