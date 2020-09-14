package com.vijay.designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/*
 * an object hold all the neccesary info to call a method i.e its sig info as a command
 * command = methodname +method params +owning object
 * Basic building blocks 1)Command 2) Invoker 3) Reciever 4) Client.
 * ex : queue commands and undo/redo commands.
 *  advantage : decouples object that invokes op from the one that know how to perform it.
 */
/* Tutorial point
 * Command pattern is a data driven design pattern and falls under behavioral pattern category. 
 * A request is wrapped under an object as command and passed to invoker object. Invoker object looks 
 * for the appropriate object
 *  which can handle this command and passes the command to the corresponding 
 *  object which executes the command.
 */
/*
 * Officer commands employee 
 * consumeRawmaterial
 * buyRawMaterial
 * 
 * Officer is Invoker
 * Employee is Receiver
 * He recives consume and buy commands.
 * 
 * Commands are in simple terms wrapper of employee object.each has what method of employee to be called.
 */
public class CommandDesignPatternImpl {

	public static void main(String args[])
	{
		Officer officer = new Officer();
		Employee employee = new Employee();
		BuyRMCommand buyRC = new BuyRMCommand(employee);
		ConsumeRMCommand consRC = new ConsumeRMCommand(employee);
		officer.recieveACommand(buyRC);
		officer.recieveACommand(consRC);
		officer.executeCommands();
	}
}

// Specify Duties of employee

class Employee
{
	public void consumeRM()
	{
		System.out.println("consume raw material"); 
	}
	
	public void buyRM()
	{
		System.out.println("buy raw material");
	}
}

interface Command 
{
	public void execute();
}
// commands employee can recieve
class BuyRMCommand implements Command
{
	Employee employee;
	BuyRMCommand(Employee emp)
	{
		employee= emp;
	}
	
	public void execute()
	{
		employee.buyRM();
	}
}

class ConsumeRMCommand implements Command
{
	Employee employee;
	ConsumeRMCommand(Employee emp)
	{
		employee= emp;
	}
	public void execute()
	{
		employee.consumeRM();
	}
}

//Officer
class Officer 
{
	List<Command> commandList = new ArrayList();
	
	public void recieveACommand(Command c)
	{
		commandList.add(c);
	}
	
	public void executeCommands()
	{
		for(Command c:commandList)
		{
			//commandList.remove(c);
			c.execute();
			
		}
	}
}