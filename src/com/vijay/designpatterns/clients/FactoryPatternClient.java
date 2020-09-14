package com.vijay.designpatterns.clients;

import com.vijay.designpatterns.creational.FactoryPatternImplementation;

public class FactoryPatternClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FactoryPatternImplementation factoryPatternImplementation = new FactoryPatternImplementation();
		Object o=factoryPatternImplementation.getMeAVehicle(2);
		System.out.println(o.getClass().getTypeName());
		o=factoryPatternImplementation.getMeAVehicle(5);
		System.out.println(o.getClass().getTypeName());
		o=factoryPatternImplementation.getMeAVehicle(6);
		System.out.println(o.getClass().getTypeName());
	}

}
