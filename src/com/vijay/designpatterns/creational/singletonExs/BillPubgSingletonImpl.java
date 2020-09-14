package com.vijay.designpatterns.creational.singletonExs;

public class BillPubgSingletonImpl {

	//private static BillPubgSingletonImpl bpSingleInstance;
	private BillPubgSingletonImpl()
	{
		
	}
   private  static class SingleHelper
	{
		/*static BillPubgSingletonImpl setSingle()
		{
			bpSingleInstance= new BillPubgSingletonImpl();
			return bpSingleInstance;
		}*/
	   private static BillPubgSingletonImpl bpSingleInstance = new BillPubgSingletonImpl();
	}
	
    public static BillPubgSingletonImpl getInstance()
    {
    	return SingleHelper.bpSingleInstance;
    }
}
