package com.vijay.designpatterns.creational.singletonExs;

import java.io.Serializable;

public class SIngletonSerializable implements Serializable{
	
	/**
	 * 
	 */
	private SIngletonSerializable()
	{
		
	}
	private static final long serialVersionUID = 1930782310466316597L;

	static class SingleHelper{
		static SIngletonSerializable singleIns = new SIngletonSerializable();
	}

	public static SIngletonSerializable getInstance()
	{
		return SingleHelper.singleIns;
	}
	
	protected Object readResolve() {
        return SingleHelper.singleIns;
    }
	
}
