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


Question 4


Question 5

