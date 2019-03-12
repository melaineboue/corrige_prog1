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