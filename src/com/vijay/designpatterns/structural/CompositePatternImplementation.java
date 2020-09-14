package com.vijay.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * An object designed as a composition of one or more SIMILAR objects all having similar functionality.
 * 
 * To treat a single object and its group in similar manner. Manipulate group in same manner as group of nodes
 * Finally we end up creating a tree structure of objects
 * It has 2 main parts a Component and its composition(Collection of components)
 * 
 * GFG -
 * When dealing with Tree-structured data, programmers often have 
 * to discriminate between a leaf-node and a branch. This makes code more complex, and therefore,
 *  error prone. The solution is an interface that allows 
 *  treating complex and primitive objects uniformly.
 *  SO instead of tree go with Composite pattern.
 *  
 * when to use :
 * 1)represent part whole hierarchies  of objects
 * 2) clients can ignore difference between composition of objects and indi objects
 * 3) clients will treat all  objects in composite structure uniformly
 *  when not to use
 * specific on subobject or restricted behaviours which is hard to implement and will incur performance hits
 * 
 * What are the scenarios we have tree like structure of relations
 * Employee hierarchy , Animal chart , Family Tree.
 * 
 * We will implement for a family tree. Component is person
 */
public class CompositePatternImplementation {

	public static void main(String args[])
	{
		////going with patriarchial
		Person grandFather = new Person();
		grandFather.setName("gf");
		Person son = new Person();
		son.setName("s");
		Person wife = new Person();
		wife.setName("w");
		Person grandson = new Person();
		grandson.setName("gs");
		
		grandFather.addPerson(son);
		son.addPerson(grandson);
		son.addPerson(wife);
		// start accessing from grandfather
		System.out.println(grandFather.getName());
		for(Person p:grandFather.familyUnderhim)
		{
			System.out.println(p.getName());
			if(null !=p.familyUnderhim)
			{
				for(Person q:p.familyUnderhim)
				{System.out.println(q.getName());}
			}
		}
	}

	
}

class Person
{
	String name;

	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", familyUnderhim=" + familyUnderhim + "]";
	}
	List<Person> familyUnderhim;
	Person()
	{
		this.familyUnderhim= new ArrayList<>();
	}
	// in addition to setters and getters we will have two more methods of add person and remove person the collection.
	
	public void addPerson(Person p)
	{
		this.familyUnderhim.add(p);
	}
	public void removePerson(Person p)
	{
		this.familyUnderhim.remove(p);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Person> getFamilyUnderhim() {
		return familyUnderhim;
	}
	public void setFamilyUnderhim(List<Person> familyUnderhim) {
		this.familyUnderhim = familyUnderhim;
	}
	
}
