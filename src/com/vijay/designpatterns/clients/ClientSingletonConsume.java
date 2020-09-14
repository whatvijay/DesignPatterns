package com.vijay.designpatterns.clients;

import com.vijay.designpatterns.creational.SingletonPatternImplementation;

public class ClientSingletonConsume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			if(SingletonPatternImplementation.getSingletonPatternImplementation()==SingletonPatternImplementation.getSingletonPatternImplementation())
			{
			 System.out.println("it is singleton");
			}
			Consumer2 consumer2 = new Consumer2();
			if(SingletonPatternImplementation.getSingletonPatternImplementation()==consumer2.conSingle())
			{
				System.out.println("it is singleton");
			}
	}

}
// both returned it is singleton
class Consumer2
		{
			public SingletonPatternImplementation conSingle()
			{
				return SingletonPatternImplementation.getSingletonPatternImplementation();
			}
		}