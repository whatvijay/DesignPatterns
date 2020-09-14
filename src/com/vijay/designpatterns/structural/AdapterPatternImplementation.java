package com.vijay.designpatterns.structural;

/*
 * Provides a go between interface for multiple incompatible clients to communicate
 * when to use when trying to integrate a legacy system we may find incompatible systems
 * when not to use - This is a indication of poor design pattern
 * So if possible redesign to remove this .
 */
/*
 * 

    Class Adapter uses inheritance and can only wrap a class. It cannot wrap an 
    interface since by definition it must derive from some base class.

    Object Adapter uses composition and can wrap classes or interfaces, or both.
     It can do this since it contains, as a private, encapsulated member, the class or 
     interface object instance it wraps.

 */
/*
 * When there is no way to subclass the class which is going to be adapted as per client's interface. 
 * Examples like, when MyExistingServiceClass is declared as final.

When client expects a contract which is not an inteface but an abstract class implementation. 
In this case, we have no other way than to subclass the client's expected class and as we can't 
subclass more than one class, 
there is no other way than using the class to be adapted as a composition.

When you need to adapt more than one object. Such case are when you are not directly
 working with object to be adapted. A good example here would be JTable class in javax.swing. 
 This class creates a GUI (graphical user interface) table component filled with the information 
 that your adapter feeds to it. To display data from your domain, JTable provides constructors
  that accept an instance of the TableModel defined in javax.swing.table.
 JDK provides an existing abstract implementation of TableModel with AbstractTableModel.
 */
public class AdapterPatternImplementation {

	public static void main(String args[])
	{
		// it tries to consume toBeConsumed but it has only 2 params with it so it uses a adapter.
		ObjectAdapter objectAdapter = new ObjectAdapter();
		objectAdapter.doATaskMethodAdapter("firstName","LastName");
		
		ClassAdapter classAdapter = new ClassAdapter();
		classAdapter.doATaskMethodAdapter("firstName", "LastName");
		
	}
	
}
//adapter which acts on object of adaptee
class ObjectAdapter{
	
	public void doATaskMethodAdapter(String fname,String lname)
	{
		TobeConsumed toBeConsumed = new TobeConsumed();
		String addr ="dummy";
		toBeConsumed.doATask(fname, lname, addr);
	}
}

class ClassAdapter extends TobeConsumed{
	
	public void doATaskMethodAdapter(String fname,String lname)
	{
		
		String addr ="dummy";
		super.doATask(fname, lname, addr);
	}
}

//adaptee
class TobeConsumed
{
	//it accepts 3 params
	
	public void doATask(String fname,String lname,String addr)
	{
		System.out.println(fname+lname+addr);
	}
}
