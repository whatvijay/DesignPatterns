package com.vijay.designpatterns.creational;

import java.util.List;
/*  when not sure of concrete classes to call implement a factory 
 which accepts a common value and gives respective vehicles
 * 
 */
/*
 * Avoid when the number of items inside factory is very few like 2 to 3 .Handle the case in caller itself
 * 
 *  any new addition of concrete class we have modify the if else logic which breaks open to extension 
 *  closed for modification principle
 *  so if we modify the existing logic we need to retest entire code.
 *  
 *  in addition to avoid when items are of small number use it for only moderate number of items .
 * */
public class FactoryPatternImplementation {

	// consider a scenario based on number of tourists need to pick a vehicle . 
	public Object getMeAVehicle(int numberOfPassengers)
	{
		if(numberOfPassengers <= 2 && numberOfPassengers >0 )
		{ 
			return new Bike();
		}
		else if(numberOfPassengers <= 5 && numberOfPassengers >2 )
		{
			return new Car();
		}
		else if(numberOfPassengers <= 10 && numberOfPassengers >5 )
		{
			return new MUV();
		}
		else
		{
			return new Bus();
		}
	}
}

class Bike
{
	Bike()
	{
		
	}
	List<String> passengerList;
	public List<String> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<String> passengerList) {
		this.passengerList = passengerList;
	}
}

class Car
{
	Car()
	{
		
	}
	List<String> passengerList;
	public List<String> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<String> passengerList) {
		this.passengerList = passengerList;
	}
}
class MUV
{
	MUV()
	{
		
	}
	List<String> passengerList;
	public List<String> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<String> passengerList) {
		this.passengerList = passengerList;
	}
}
class Bus
{
	Bus()
	{
		
	}
	List<String> passengerList;
	public List<String> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<String> passengerList) {
		this.passengerList = passengerList;
	}
}