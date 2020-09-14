package com.vijay.designpatterns.behavioural;

/*
 * access elements of a collection in a sequential manner without knowing its underlying implementation.
 * Basic blocks of this pattern are Iterator interface with 2 methods next and hasNext
 * The collection is responsible for implementing the iterator interface.
 * 
 */
public class IteratorPatternImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarList  clist = new CarList();
		Iterator cIterator=clist.iterator();
		while(cIterator.hasNext())
		{
			String s=(String) cIterator.next();
			System.out.println(s);
		}

	}

}

interface Iterator
{
	public Object next();
	public boolean hasNext();
}

class CarList 
{

	private String[] listOfCars= {"bmw","audi"};
	
	public CarIterator iterator()
	{
		return new CarIterator();
	}
	
	private class CarIterator implements Iterator
	{
		int index=0;
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		if(this.hasNext())
		return listOfCars[index++];
		else
			return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index < listOfCars.length)
		return true;
		else
			return false;
	}
	}
	
}