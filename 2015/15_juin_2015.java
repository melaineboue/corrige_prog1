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







Exercice 2

Question1

L'ordre postfixe veut dire qu'on affiche d'abord le fils gauche, ensuite le fils et enfin la racine
public static void printSmallValues(BinaryTree<Integer> tree, int value)
{
	printSmallValuesAux(tree.iterator(), int valeur);
}

public static void printSmallValuesAux(Iterator<Integer> it, int value)
{
	if(it.nodeType()!=LEAF)
	{
		it.goLeft();
		printSmallValuesAux(it,value);
		it.goUp();
		it.goRight();
		printSmallValuesAux(it,value);
		it.goUp();
	}
	
	Integer nombre = it.getValue();
	if(nombre < valeur)
		System.out.println(nombre);
}


Question 2

public static int numberOfSimpleNodes(BinaryTree<Integer> tree)
{
	int nombre = 0;
	numberOfSimpleNodes(tree.iterator(), nombre);
	return nombre;
}

public static void numberOfSimpleNodesAux(Iterator<Integer> it, int nombre)
{
	if(it.nodeType()==SIMPLE_LEFT || it.nodeType()==SIMPLE_RIGHT)
		nombre++;
	
	if(it.nodeType()!=LEAF && it.nodeType()!=SENTINEL)
	{
		it.goLeft();
		numberOfSimpleNodesAux(it,nombre);
		it.goUp();
		it.goRight();
		numberOfSimpleNodesAux(it,nombre);
		it.goUp();
	}
}


Question 3
public static BinaryTree<Integer> merge(BinaryTree<Integer> tree1, BinaryTree<Integer> tree2, int root)
{
	BinaryTree<Integer> final_tree = new BinaryTree<Integer>();
	Iterator<Integer> it = final_tree.iterator();
	it.addValue(root);
	it.goLeft();
	affectAux(it,tree1.iterator());
	it.goUp();
	it.goRight();
	affectAux(it,tree2.iterator());
	it.goUp();
}

public static void affectAux(Iterator<Integer> it,Iterator<Integer> it2)
{
	it.addValue(it.getValue());
	
	if(it2.nodeType()!=LEAF && it2.nodeType()!=SENTINEL)
	{
		it.goLeft();
		it2.goLeft();
		affectAux(it,it2);
		it.goUp();
		it2.goUp();
		it.goRight();
		it2.goRight();
		affectAux(it,it2);
		it.goUp();
		it2.goUp();
	}
}


Question 4
On va stocker les enfants de l'arbre gauche dans une liste 1 
et les enfants de l'arbre droit dans une liste 2
Et on doit s'assurer pour un element donné, il est superieur aux elemens de son fils gauche et inferieur aux elemens de son fils droit
Donc on fera un parcours postfixe

public static boolean isSymetric(BinaryTree<Integer> tree)
{
	boolean estSymetrique = true;
	isSymetricAux(tree.iterator(), estSymetrique)
	return estSymetrique;
}

public static Set<Integer> isSymetricAux(Iterator<Integer> it, boolean estSymetrique)
{
	Set<Integer> fils_gauche = new HashSet<Integer>();
	Set<Integer> fils_droit = new HashSet<Integer>();
	Integer value = it.getValue();
	
	if(it.nodeType()!=LEAF && it.nodeType()!=SENTINEL && !estSymetrique)
	{	
		it.goLeft();
		fils_gauche = isSymetricAux(it, estSymetrique);
		it.goUp();
		it.goRight();
		fils_droit = isSymetricAux(it, estSymetrique);
		it.goUp();
		
		for(Integer current:fils_gauche)
		{
			if(value < current)
				estSymetrique = false;
		}
		
		for(Integer current:fils_droit)
		{
			if(value > current)
				estSymetrique = false;
		}
		
		fils_gauche.add(value);
		fils_gauche.addAll(fils_droit)
		return fils_gauche;
		
	}
	else if(nodeType()==LEAF)
	{
		Set<Integer> fils = new HashSet<Integer>();
		fils.add(value);
		return fils;
	}
	else 
		return new HashSet()
}



Question 5
public static BinaryTree<Pair> deseqTree(BinaryTree<Integer> tree)
{
	BinaryTree<Pair> tree_result = new BinaryTree<Pair>();
	deseqTreeAux(tree_result.iterator(), tree.iterator());
	return tree_result;
}

public static int deseqTreeAux(Iterator<Integer> it,Iterator<Integer> it1)
{
	int hauteur_gauche = 0;
	int hauteur_droit = 0;
	it.AddValue(new Pair(it.getValue(),0));
	if(it1.nodeType()!=LEAF && it1.nodeType()!=SENTINEL)
	{	
		it1.goLeft();
		it.goLeft();
		hauteur_gauche = isSymetricAux(it1, estSymetrique);
		it1.goUp();
		it.goUp();
		it1.goRight();
		it.goRight();
		hauteur_droit = isSymetricAux(it1, estSymetrique);
		it1.goUp();
		it.goUp();
		
		it.getValue().deseq = hauteur_gauche - hauteur_droit;
		return (hauteur_gauche > hauteur_droit)? hauteur_gauche +1 : hauteur_droit + 1;
	}
	else if(it1.nodeType()==LEAF)
		return 1
	else 
		return 0;
	
}
