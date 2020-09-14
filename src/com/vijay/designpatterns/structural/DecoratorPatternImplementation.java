package com.vijay.designpatterns.structural;

/*
 * add remove responsibilty to/form an obj dynamically at run time
 * 
 * sub classing achieved using extnds will add functionality at compile time
 * 
 * when to use : when decorators add various features which cannot be done with interfaces
 * when not to use :it can result in lot of classes and if there is limited variation due to deoration avoid it.
 * 
 * basic building blocks 
 * we should have a interface of component to be decorated, component implementing interface.
 * we should have a decorator abstract class which implement
 *  component interface and a concrete decorator which actually adds some more functionality.
 * 
 * So we will take a example of home and demo decorator.
 */
public class DecoratorPatternImplementation {

	public static void main(String args[])
	{
		Home baseHome = new BasicHome();
		GlassDecorator glassDec = new GlassDecorator(baseHome);
		glassDec.area();
	}
}

interface Home{
	
	public void area();
}

class BasicHome implements Home
{

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("my area is 1000sft");
	}
	
}

abstract class HomeDecorator implements Home
{
	// all common act are put in abstract class
	// as part of it we define a object on whom decoration has to be done
	//add its methods and call the tobedeco class methods inside it.
	Home homeTobeDecorated;
	
	HomeDecorator(Home decorateHome)
	{
		homeTobeDecorated=decorateHome; 
	}
	// wrapper done.
	public void area()
	{
		homeTobeDecorated.area();
	}
}
//concrete decorator
class GlassDecorator extends HomeDecorator
{

	GlassDecorator(Home decorateHome) {
		super(decorateHome);
		// TODO Auto-generated constructor stub
	}
	// new functionality added under the hood of old functionality
	public void area()
	{
		super.area();
		decorateWithGlasses();
	}
	// only area should be called this should work under the hood
	private void decorateWithGlasses()
	{
		System.out.println("decoration with glassess complted");
	}
}
