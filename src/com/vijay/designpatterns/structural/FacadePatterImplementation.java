package com.vijay.designpatterns.structural;

/*
 * define a higher level interface to subclasses with poor api and make the use easy
 * wraps the methods of subclasses with a better name 
 * adapter involves signature change but this involves only name change.
 * hides underlying complexity
 * 
 * decouples subsystems.
 * 
 * how to make a facade pattern - It involves a class which has objects of all subclasses 
 * and it has set of methods which will call different subclass methods.
 * 
 * when to use : legacy system use. combine func into one 
 * when not to use : when using subclasses at granual level is required with heavy customization
 */
public class FacadePatterImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentGatewayCommon pgc = new PaymentGatewayCommon();
		pgc.payUsingGatway1();
		pgc.payUsingGatway2();
	}

}
class PaymentGW1{
	
	public void payNow()
	{
		System.out.println("paymentGw1 paid");
	}
}

class PaymentGW2
{
	public void checkOut()
	{
		System.out.println("paymentGw2 paid");
	}
}

class PaymentGatewayCommon
{
	private PaymentGW1 pyGw1;
	private PaymentGW2 pyGw2;
	PaymentGatewayCommon()
	{
		pyGw1 = new PaymentGW1();
		pyGw2 = new PaymentGW2();
	}
	
	public void payUsingGatway1()
	{
		pyGw1.payNow();
	}
	public void payUsingGatway2()
	{
		pyGw2.checkOut();
	}
}