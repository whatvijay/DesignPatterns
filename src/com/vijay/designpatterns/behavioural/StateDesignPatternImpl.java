package com.vijay.designpatterns.behavioural;

/*
 * Allow an object to alter its behaviour when its internal state changes. 
 * The Object in question appears to change its class.
 * 
 * how is it achieved - change its subclass when we switch to a different method.
 * cons - results in many small classes and can cause tigth coupling also
 * 
 * it is made of context and states , context behaviour chnages as its state object chnages.
 * when building a complex state machine
 */
/*
 * example is student has lot of states lets take pass fail states.
 * here student is a context which has a state.
 * 
 *https://www.geeksforgeeks.org/state-design-pattern/
 */
public class StateDesignPatternImpl {
	
	public static void main(String args[])
	{
		Student  stu1 = new Student();
		State pass= new Pass();
		State fail = new Fail();
		stu1.setStudentState(fail);
		stu1.doSomething();
		stu1.setStudentState(pass);
		stu1.doSomething();
		
	}

}

interface State
{
	public void activity();
}

class Pass implements State
{

	@Override
	public void activity() {
		// TODO Auto-generated method stub
		System.out.println("relaxing");
	}
	
}

class Fail implements State
{

	@Override
	public void activity() {
		// TODO Auto-generated method stub
		System.out.println("studying");
	}
	
}

class Student 
{
	State studentState;

	public State getStudentState() {
		return studentState;
	}

	public void setStudentState(State studentState) {
		this.studentState = studentState;
	}
	
	public void doSomething()
	{
		 studentState.activity();
	}
}