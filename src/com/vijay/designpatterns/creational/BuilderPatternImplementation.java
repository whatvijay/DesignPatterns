package com.vijay.designpatterns.creational;

/**
 * 
 * @author vijay bUilder pattern
 * Separate object construction from its structure 
 * 
 * when too many constructor args we have situation where we have a problem with order of args
 * so we try setter injection then we may forget one setter leading incorrect Object state
 *
 *So we use builder patter based on a "fluent interface is an object-oriented 
 *API whose design relies extensively on method chaining. Its goal is to increase 
 *code legibility by creating a domain-specific language (DSL). The term was coined in 
 *2005 by Eric Evans and Martin Fowler." -- wikipedia
 *
 *We create a builder which has all the parameters of 
 *class and then we make Constructor of the class in question as private
 *
 *we make builder class as static and access its constructor and then to each buillder method
 *each builder method set the parameter and and returns this the builder object which ensures fluid pattern
 *
 *finally build will create a object using constructor and fills the info and returns the object
 */
public class BuilderPatternImplementation {

	public static void main(String args[]) {
	Person person = new Person.PersonBuilder().buildFirstName("firstName123").
			buildLastName("lastname123").buildAddr("adr123").build();
	System.out.println(person.toString());
	}
	
}

// consider a person class

class Person {
	
	String firstName;
	String lastName;
	String addr;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	static  class PersonBuilder
	{
	String firstName;
	String lastName;
	String addr;
	
	public PersonBuilder(){
		
	}
	public PersonBuilder buildFirstName(String firstName)
	 {
		 this.firstName=firstName;
		 
		 return this;
	 }
	public PersonBuilder buildLastName(String lastName)
	{
		this.lastName=lastName;
		return this;
	}
	public PersonBuilder buildAddr(String addr)
	{
		this.addr=addr;
		return this;
	}
	
	public Person build()
	{
		Person person = new Person();
		person.setFirstName(this.firstName);
		person.setLastName(this.lastName);
		person.setAddr(this.addr);
		return person;
	}
	}
	private Person()
	{
		
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", addr=" + addr + "]";
	}
}
