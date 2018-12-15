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

Question 2


Question 3

Question 4


Question 5

