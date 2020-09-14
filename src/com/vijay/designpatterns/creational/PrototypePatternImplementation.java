package com.vijay.designpatterns.creational;

import java.util.HashMap;
import java.util.Map;

/*
 * prototype - instead of creating objects using new it uses clone of Clonebale interface to make objects
 * with out overriding clone we ensure shallow copy which references to original object
 * with clone overrided we ensure deep copy .
 * 
 *  */
/*
 * When to go - when object needs lot of properties to set we use prototype and the object required is identical to existing
 * 
 * When not to go -if objects are singleton or final and if they have chance of circular dependency.
 */
/*
 * 
 * Structure of this pattern and key parts.
 * 1. Should have objects which can be cloned so we need classes which implement cloneable
 * 2. Should have a map which can hold the objects from where we can fetch and apply clone.
 *
 */
public class PrototypePatternImplementation {
	
	public static void main(String args[])
	{
		// to use prototype we need to have a protoregistry object
		ProtoRegistry protoRegistry = new ProtoRegistry();
		System.out.println(protoRegistry.getPrototype("item1").hashCode());
		System.out.println(protoRegistry.getPrototype("item1").hashCode());
		System.out.println(protoRegistry.getPrototype("item1").hashCode());
		System.out.println(protoRegistry.getPrototype("item1").hashCode());
		System.out.println(protoRegistry.getPrototype("item2").hashCode());
		System.out.println(protoRegistry.getPrototype("item2").hashCode());
		System.out.println(protoRegistry.getPrototype("item2").hashCode());
		System.out.println(protoRegistry.getPrototype("item2").hashCode());
		//observed that all hashcodes are different.
	}

}

class ProtoRegistry
{
	// Has a hashMap
	private Map<String,CloneableItems> itemCache = new HashMap();
	
	 ProtoRegistry()
	 {
		 // as soon as it is constructed we load all items and save it into itemCache.
		 Item1 item1 =new Item1();
		 itemCache.put(item1.itemType,item1);
		 Item2 item2 = new Item2();
		 itemCache.put(item2.itemType,item2);
	 }
	 public CloneableItems getPrototype(String itemType)
	 {
		 return (CloneableItems) itemCache.get(itemType).clone();
	 }
	
}
abstract class  CloneableItems implements Cloneable
{
	//we use protected so it can be seen in child 
	protected String itemType;
	
	public Object clone()
	{
		Object clony = null;
		try {
			clony= super.clone();
		}
		catch(Exception e)
		{
			
		}
		return clony;
	}
}

class Item1 extends CloneableItems
{
	//identity it is item1
	public Item1()
	{
	 itemType="item1";
	}
}
class Item2 extends CloneableItems
{
	//identity it is item2
	public Item2()
	{
		itemType="item2";
	}
}
