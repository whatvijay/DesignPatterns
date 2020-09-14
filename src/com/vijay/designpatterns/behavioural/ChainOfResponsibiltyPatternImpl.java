package com.vijay.designpatterns.behavioural;

/*
 * A way of passing a request along a chain of objects until a object 
 * handles it entirely or a group of objects handle it partially
 * 
 * Promotes loose coupling
 * servlet filters and servlet chaining are examples.
 */
// 2 types constructor chaining and setter chaining
// will implement setter chaining
// Consider food processor unit with chain of activities
//current processor should call nextproc processor if its not null 
public class ChainOfResponsibiltyPatternImpl {
		
	public static void main(String[] args) {
		System.out.println("kai");
		ProcessChainer pchainer =new ProcessChainer();
		pchainer.chainProcs().procWork();
	}
}

abstract class AbstractProc
{
	private AbstractProc nextProc;
	
	String nameOfProc;
	
	public String getNameOfProc() {
		return nameOfProc;
	}

	public void setNameOfProc(String nameOfProc) {
		this.nameOfProc = nameOfProc;
	}

	public AbstractProc getNextProc() {
		return nextProc;
	}

	public void setNextProc(AbstractProc nextProc) {
		this.nextProc = nextProc;
	}
	
	public void procWork()
	{
		System.out.println("completed proc work"+nameOfProc);
		if(null != this.nextProc)
		this.nextProc.procWork();
	}
}
	class RawMaterialProc extends AbstractProc
	{
		RawMaterialProc()
		{
			super.setNameOfProc("RawProcessor");
		}
	}
	
	class CookMaterialProc extends AbstractProc
	{
		CookMaterialProc()
		{
			super.setNameOfProc("CookingProc");
		}
	}
	
	class PackingProc extends AbstractProc
	{
		PackingProc()
		{
			super.setNameOfProc("PackingProc");
		}
	}
	
	class ProcessChainer
	{
		// it creates all processors and chains them
		//here can go for setters also for simplicity using cons
		RawMaterialProc rawMaterialProc;
		CookMaterialProc cookMaterialProc;
		PackingProc packProc;
		ProcessChainer()
		{
			rawMaterialProc= new RawMaterialProc();
			cookMaterialProc= new CookMaterialProc();
			packProc= new PackingProc ();
		}
		
		public AbstractProc chainProcs()
		{
			rawMaterialProc.setNextProc(cookMaterialProc);
			cookMaterialProc.setNextProc(packProc);
			return rawMaterialProc;
		}
	}

