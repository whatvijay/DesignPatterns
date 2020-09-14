package com.vijay.designpatterns.structural;
/*
 * proxy means in place of  on behalf of so we create a wrapper and make the
 * outside world believe they are interacting with real objects
 * 
 *gfg *
 * There are few differences between the related patterns. Like Adapter pattern gives a different 
 * interface to its subject, while Proxy patterns provides the same interface from the original object
 *  but the decorator 
 * provides an enhanced interface. Decorator pattern adds additional behaviour at runtime.
 * 
 * when to use : to restrict access to few objects.
 * when not to use : When access to realObj is neccessary.
 */
public class ProxyPatternImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Pass pass = new ProxyPass ();
			String passValue;
			passValue=pass.giveMePass("abcd123");
			System.out.println(passValue);
			passValue=pass.giveMePass("BlockedID");
			System.out.println(passValue);
	}

}

interface Pass
{
	public String giveMePass(String id);
}
class RealPass implements Pass
{

	@Override
	public String giveMePass(String id) {
		// TODO Auto-generated method stub
		return "allowed"+"id";
	}
	
}

class ProxyPass implements Pass
{

	// one instance of realpass is required inside proxy . The proxy methods will 
	//internally call the real object
	private RealPass realPass= new RealPass();
	@Override
	public String giveMePass(String id) {
		// TODO Auto-generated method stub
		if(id.equalsIgnoreCase("BlockedID"))
		{
			return "pass is blocked";
		}
		else
		{
		return realPass.giveMePass(id);
		}
	}
	
}