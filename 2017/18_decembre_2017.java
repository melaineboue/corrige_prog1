Question 1
public boolean isIdPresent(String store, Integer id)
{
	Stock stock = this.getValue(store);
	return store!=null && store.contains(id);
}


Question 2 
public boolean isSolid(String store, String name)
{
	Iterator<String> it = iterator();
	while(it.hasNext())
	{
		String store = it.next();
		Stock stock = getValue(store);
		Iterator<Integer> it2 = stock.iterator();
		while(it2.hasNext())
		{
			Interger id = it2.next();
			Product produit = stock.getValue(id);
			if(produit.name.equals(name))
			{
				return true;
			}
		}
	}
	return false;
}


Question 3
public String morePopularBrand(String brand1, String brand2)
{
	int nombre_brand1 = 0, nombre_brand2 = 0
	Iterator<String> it = iterator();
	while(it.hasNext())
	{
		String store = it.next();
		Stock stock = getValue(store);
		Iterator<Integer> it2 = stock.iterator();
		while(it2.hasNext())
		{
			Interger id = it2.next();
			Product produit = stock.getValue(id);
			if(produit.brand.equals(brand1))
			{
				nombre_brand1++;
			}
			else if(produit.brand.equals(brand2))
			{
				nombre_brand2++;
			}
		}
	}
	return (nombre_brand1>nombre_brand2)? brand1 : brand2;
}


Question 4
public void addNewStock(StoreStocks stocks)
{
	Iterator<String> it = stocks.iterator();
	while(it.hasNext())
	{
		String nouveau_store = it.next();
		Stock nouveau_stock = stocks.getValue(nouveau_store);
		
		if(this.contains(nouveau_store))
		{
			Stock ancien_stock = this.getValue(nouveau_store);
			
			Iterator<Integer> it2 = nouveau_stock.iterator();
			while(it2.hasNext())
			{
				Integer id_produit = it2.next();
				Product produit = nouveau_stock.getValue(id_produit);
				
				if(ancien_stock.contains(id_produit))
				{
					ancien_stock.getValue(id_produit).quantity += produit.quantity ;
				}
				else 
				{
					ancien_stock.addValue(id_produit,produit);
				}
			}
		}
		else
		{
			this.addValue(nouveau_store,nouveau_stock);
		}
	}
}




Exercice 2


Question 1

public boolean exists(String countyName)
{
	Iterator<Country> it = iterator();
	while(it.nodeType()!=LEAF || it.nodeType()!=SENTINEL)
	{
		Country pays = it.getValue();
		if(pays.name.equals(countyName))
			return true;
		if(pays.compareTo(countyName) > 0)
			it.goLeft();
		else if(pays.compareTo(countyName))
			it.goRight();
	}
	return false;
}

Question 2

public void printNodeOf(int depth)
{
	printNodeOfAux(iterator(),depth,0);
}

public void printNodeOfAux(Iterator<Country> it, int depth, int profondeur)
{
	if(it.nodeType()!=LEAF || it.nodeType()!=SENTINEL
	{
		it.goLeft();
		profondeur++;
		printNodeOfAux(it,depth,profondeur);
		it.goUp();
		profondeur--;
		if(profondeur == depth)
			System.out.println(it.getValue().name);
		it.goRight();
		profondeur++;
		printNodeOfAux(it,depth,profondeur);
		it.goUp();
		profondeur--;
	}
	else 
	{
		if(profondeur == depth)
			System.out.println(it.getValue().name);
	}
}


Question 3
public Country largestCountry()
{
	Country pays = null;
	largestCountryAux(iterator(),pays);
	return pays;
}

public void largestCountryAux(Iterator<Country> it, Country pays)
{
	if(pays==null || it.getValue().surface > pays.surface)
		pays = it.getValue();
	
	
	if(it.nodeType()!=LEAF || it.nodeType()!=SENTINEL
	{
		it.goLeft();
		largestCountryAux(it,pays);
		it.goUp();
		it.goRight();
		largestCountryAux(it,pays);
		it.goUp();
	}
}

Question 4
public boolean isPerfect()
{
	ArrayList<Integer> distances = new ArrayLis<Integer>();
	isPerfectAux(iterator(),distances);
	if(distances.size()!=0)
	{
		Integer nombre = distances.get(0);
		for(Integer nombre_current : distances)
		{
			if(nombre != nombre_current)
				return false;
		}
	}
	return true;
}

public void isPerfectAux(Iterator<Country> it, ArrayList<Integer> distances, profondeur)
{
	
	if(it.nodeType()!=SENTINEL)
	{
		it.goLeft();
		profondeur++;
		isPerfectAux(it,distances,profondeur);
		it.goUp();
		profondeur--;
		it.goRight();
		profondeur++;
		isPerfectAux(it,distances,profondeur);
		it.goUp();
		profondeur--;
	}
	else 
		distances.add(profondeur);
}


Question 5

public void add Country(Country country)
{
	Iterator<Country> it = iterator();
	boolean trouve = false;
	while(it.nodeType()!=SENTINEL)
	{
		Country pays = it.getValue();
		if(pays.name.equals(countyName))
		{
			trouve true;
			break;
		}
			
		if(pays.compareTo(country.name) > 0)
			it.goLeft();
		else if(pays.compareTo(country.name))
			it.goRight();
	}
	
	if(!trouve)
		it.setValue(country);
	
}

